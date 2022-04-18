module com.example.xadrezfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.xadrezfx to javafx.fxml;
    exports com.example.xadrezfx;
}