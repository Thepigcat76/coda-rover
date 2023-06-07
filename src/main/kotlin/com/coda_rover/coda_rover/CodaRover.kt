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
    val file = File(filePathTextField.text)
    val reader = file.readLines()
    val newLines = mutableListOf<String>()
    fun openFile(filePathTextField: TextField, targetTextArea: TextArea) {
        if (filePathTextField.text != "") {

            for (line in reader) {
                newLines.add(line)
            }

            targetTextArea.text = newLines.joinToString("\n")
        }
    }

    fun saveFile(targetTextArea: TextArea) {
        file.writeText(targetTextArea.text)
    }
}