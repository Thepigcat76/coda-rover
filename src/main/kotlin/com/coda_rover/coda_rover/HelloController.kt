package com.coda_rover.coda_rover

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextArea

class HelloController {
    @FXML
    lateinit var welcomeText: Label

    @FXML
    lateinit var mainTextArea: TextArea

    @FXML
    private fun onHelloClick() {
        welcomeText.text = "Greetings"
    }

    @FXML
    private fun onTextFieldClick() {
        mainTextArea.text = "updated text"
    }

    fun initialize() {
        mainTextArea.textProperty().addListener { _, _, newValue ->
            if (newValue == "Hello") {
                mainTextArea.text = "You entered 'Hello'!"
            }
        }
    }
}