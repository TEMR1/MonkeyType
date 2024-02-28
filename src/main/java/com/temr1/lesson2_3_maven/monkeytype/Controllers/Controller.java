package com.temr1.lesson2_3_maven.monkeytype.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Controller {
    private final String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec accumsan sed mauris sit amet congue. Vestibulum pellentesque lorem eu velit porttitor, sed scelerisque neque maximus. Curabitur eu neque lacinia, mollis ligula eu, dictum diam. Proin luctus dui in cursus tristique. Nullam quis eros velit. Vivamus a lacinia arcu. Fusce id eros ex. Maecenas et nisi metus. Suspendisse potenti. Duis quis ipsum in est varius placerat. Fusce ultrices quam leo, non fermentum lorem ultricies in. Aliquam dignissim ligula eget maximus commodo. Morbi sed tristique ante, eget laoreet felis. Nunc porta elementum aliquam. ";
    @FXML
    private TextFlow textFlow;

    @FXML
    private javafx.scene.layout.VBox VBox;

    private Scene scene;

    private int i = -1;
    private boolean isStart;

    public void setScene(Scene scene) {
        this.scene = scene;
    }
    public void setup(){
        isStart = false;
        for (char c:str.toCharArray()){
            Text newText = new Text(String.valueOf(c));
            newText.setFill(Color.LIGHTGRAY);
            textFlow.getChildren().add(newText);
        }
        scene.addEventFilter(KeyEvent.KEY_PRESSED,this::onKeyTyped);
    }

    public void onKeyTyped(KeyEvent keyEvent){
        if (isStart){
            i++;
            ((Text) textFlow.getChildren().get(i)).setText(keyEvent.getText());
            ((Text) textFlow.getChildren().get(i)).setFill(Color.GREY);
        }
    }

    public void onStartButtonClick(){
        isStart = true;
    }
}