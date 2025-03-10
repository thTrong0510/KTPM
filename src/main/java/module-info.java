module daihocmo.coursecourseapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens daihocmo.coursecourseapp to javafx.fxml;
    exports daihocmo.coursecourseapp;
    
    exports daihocmo.pojo;
    exports daihocmo.service;
}
