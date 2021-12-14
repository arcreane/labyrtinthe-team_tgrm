module com.tgrm.labyrtintheteam_tgrm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.tgrm.labyrtintheteam_tgrm to javafx.fxml;
    exports com.tgrm.labyrtintheteam_tgrm;
}