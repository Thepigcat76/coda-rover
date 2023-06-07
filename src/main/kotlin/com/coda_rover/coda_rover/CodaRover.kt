package com.coda_rover.coda_rover

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.stage.Stage
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException
import java.nio.file.FileSystems
import java.nio.file.Path
import java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY

class CodaRover : Application() {
    val fxmlLoader = FXMLLoader(CodaRover::class.java.getResource("coda_rover.fxml"))
    val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
    val controller = fxmlLoader.getController<CodaRoverController>()
    val mainTextArea: TextArea = controller.mainTextArea
    val filePath: TextField = controller.filePath
    override fun start(stage: Stage) {
        stage.title = "Hello!"
        stage.icons.add(Image("file:src/main/resources/com/coda_rover/coda_rover/catpig.png"))
        stage.scene = scene
        stage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(CodaRover::class.java)
        }
    }
}

class FileHandling(filePathTextField: TextField) {
    private val file = File(filePathTextField.text)
    private val reader = file.readLines()
    private val newLines = mutableListOf<String>()
    private var fileWatcher: Thread? = null

    fun openFile(filePathTextField: TextField, targetTextArea: TextArea) {
        if (filePathTextField.text != "") {
            for (line in reader) {
                newLines.add(line)
            }
            targetTextArea.text = newLines.joinToString("\n")

            // Start monitoring the file for changes
            startFileMonitoring(filePathTextField.text, targetTextArea)
        }
    }

    fun saveFile(targetTextArea: TextArea) {
        file.writeText(targetTextArea.text)
    }

    private fun startFileMonitoring(filePath: String, targetTextArea: TextArea) {
        val path: Path = Path.of(filePath)
        val watchService = FileSystems.getDefault().newWatchService()

        val directory = path.parent
        directory.register(watchService, ENTRY_MODIFY)

        // Start a new thread to monitor the file
        fileWatcher = Thread {
            while (true) {
                val watchKey = watchService.take()

                for (event in watchKey.pollEvents()) {
                    val kind = event.kind()
                    val modifiedFile = event.context() as Path

                    if (kind == ENTRY_MODIFY && modifiedFile == path.fileName) {
                        // File has been modified, update the targetTextArea
                        val updatedContent = File(filePath).readText()
                        targetTextArea.text = updatedContent
                    }
                }

                watchKey.reset()
            }
        }

        // Start the file monitoring thread
        fileWatcher?.start()
    }
}