package com.coda_rover.coda_rover

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.TextArea
import javafx.scene.image.Image
import javafx.stage.Stage

class CodaRover : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(CodaRover::class.java.getResource("coda_rover.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        val controller = fxmlLoader.getController<CodaRoverController>()
        val mainTextArea: TextArea = controller.mainTextArea

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