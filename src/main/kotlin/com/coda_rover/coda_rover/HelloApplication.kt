package com.coda_rover.coda_rover

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.TextArea
import javafx.scene.image.Image
import javafx.scene.layout.VBox
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        val controller = fxmlLoader.getController<HelloController>()
        val mainTextArea: TextArea = controller.mainTextArea

        stage.title = "Hello!"
        stage.icons.add(Image("file:src/main/resources/com/coda_rover/coda_rover/catpig.png"))
        stage.scene = scene
        stage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(HelloApplication::class.java)
        }
    }
}