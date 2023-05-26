module com.coda_rover.coda_rover {
    requires javafx.controls;
    requires javafx.fxml;
                requires kotlin.stdlib;
    
                            
    opens com.coda_rover.coda_rover to javafx.fxml;
    exports com.coda_rover.coda_rover;
}