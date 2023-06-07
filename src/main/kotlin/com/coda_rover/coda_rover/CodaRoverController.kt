package com.coda_rover.coda_rover

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.control.TextField

class CodaRoverController {
    @FXML
    lateinit var filePath: TextField

    @FXML
    lateinit var welcomeText: Label

    @FXML
    lateinit var mainTextArea: TextArea

    @FXML
    private fun onOpenClick() {
        welcomeText.text = "Greetings"
        FileHandling(filePath).openFile(filePath, mainTextArea)
    }

    @FXML
    private fun onTextFieldClick() {
        mainTextArea.text = "updated text"
    }

    @FXML
    private fun onSaveClick() {
        FileHandling(filePath).saveFile(mainTextArea)
    }

    fun initialize() {
        mainTextArea.textProperty().addListener { _, _, newValue ->
            if (newValue == "Hello") {
                mainTextArea.text = "You entered 'Hello'!"
            }
        }
    }
}