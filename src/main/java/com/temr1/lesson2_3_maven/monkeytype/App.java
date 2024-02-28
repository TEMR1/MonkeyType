package com.temr1.lesson2_3_maven.monkeytype;

import com.temr1.lesson2_3_maven.monkeytype.Controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Method;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        ((Controller) fxmlLoader.getController()).setScene(scene);
        ((Controller) fxmlLoader.getController()).setup();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}