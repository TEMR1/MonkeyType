module com.temr1.lesson2_3_maven.monkeytype {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.temr1.lesson2_3_maven.monkeytype to javafx.fxml;
    exports com.temr1.lesson2_3_maven.monkeytype.Controllers;
    opens com.temr1.lesson2_3_maven.monkeytype.Controllers to javafx.fxml;
    exports com.temr1.lesson2_3_maven.monkeytype.Models;
    opens com.temr1.lesson2_3_maven.monkeytype.Models to javafx.fxml;
    opens com.temr1.lesson2_3_maven.monkeytype.View to javafx.fxml;
    exports com.temr1.lesson2_3_maven.monkeytype.View;
}