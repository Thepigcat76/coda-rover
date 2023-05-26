package com.coda_rover.coda_rover

import javafx.fxml.FXML
import javafx.scene.control.Label

class HelloController {
    @FXML
    private lateinit var welcomeText: Label

    @FXML
    private fun onHelloClick() {
        welcomeText.text = "Greetings"
    }
}