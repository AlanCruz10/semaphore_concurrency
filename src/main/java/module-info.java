module com.sem.semaphore {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sem.semaphore to javafx.fxml;
    exports com.sem.semaphore;
    exports com.sem.semaphore.controllers;
    opens com.sem.semaphore.controllers to javafx.fxml;
}