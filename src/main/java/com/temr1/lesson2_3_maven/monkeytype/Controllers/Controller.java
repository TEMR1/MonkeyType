    package com.temr1.lesson2_3_maven.monkeytype.Controllers;

    import com.temr1.lesson2_3_maven.monkeytype.Models.*;
    import javafx.fxml.FXML;
    import javafx.scene.Scene;
    import javafx.scene.chart.LineChart;
    import javafx.scene.chart.NumberAxis;
    import javafx.scene.chart.XYChart;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
    import javafx.scene.input.KeyEvent;
    import javafx.scene.paint.Color;
    import javafx.scene.text.Text;
    import javafx.scene.text.TextFlow;
    import javafx.stage.Stage;

    import java.util.ArrayList;

    public class Controller {
        private final TimerModel timerModel = new TimerModel();
        private MistakesGraphModel mistakesGraphModel;
        private final String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec accumsan sed mauris sit amet congue. Vestibulum pellentesque lorem eu velit porttitor, sed scelerisque neque maximus. Curabitur eu neque lacinia, mollis ligula eu, dictum diam. Proin luctus dui in cursus tristique. Nullam quis eros velit. Vivamus a lacinia arcu. Fusce id eros ex. Maecenas et nisi metus. Suspendisse potenti. Duis quis ipsum in est varius placerat. Fusce ultrices quam leo, non fermentum lorem ultricies in. Aliquam dignissim ligula eget maximus commodo. Morbi sed tristique ante, eget laoreet felis. Nunc porta elementum aliquam. ";
        @FXML
        private TextFlow textFlow;
        @FXML
        private Label timerLabel = new Label();
        @FXML
        private Button startButton = new Button();
        private Scene scene;
        private int indexOfLetter = 0;
        private boolean isStart;
        private int counterOfMistakes = 0;

        public void setScene(Scene scene) {
            this.scene = scene;
        }
        public void setup(){
            isStart = false;
            for (char letter:str.toCharArray()){
                Text newText = new Text(String.valueOf(letter));
                newText.setFill(Color.LIGHTGRAY);
                textFlow.getChildren().add(newText);
            }
            scene.addEventFilter(KeyEvent.KEY_PRESSED,this::onKeyTyped);
        }

        public void onKeyTyped(KeyEvent keyEvent){
            if (isStart){
                String enteredText = keyEvent.getText();

                if (!enteredText.isEmpty()){
                    char currentChar = str.charAt(indexOfLetter);
                    char enteredChar = keyEvent.isShiftDown() ? keyEvent.getText().toUpperCase().charAt(0) : keyEvent.getText().charAt(0);

                    Color color;

                    if (enteredChar == currentChar)
                        color = Color.GREY;
                    else{
                        color = Color.RED;
                        counterOfMistakes++;
                    }

                    ((Text) textFlow.getChildren().get(indexOfLetter)).setText(String.valueOf(enteredChar));
                    ((Text) textFlow.getChildren().get(indexOfLetter)).setFill(color);

                    indexOfLetter++;
                }
            }
        }

        public void onStartButtonClick(){
            isStart = true;
            startButton.setDisable(true);

            timerModel.setParameters(timerLabel, 15, this, new MistakesGraphModel());

            Thread timerThread = new Thread(timerModel);
            timerThread.start();
        }

        public void showMistakesGraph(){
            mistakesGraphModel = timerModel.getMistakesGraphModel();
            ArrayList<MistakesParameters> ArrayOfMistakesParameters = mistakesGraphModel.getGraphPointsArray();

            Stage stage = new Stage();
            stage.setTitle("Mistakes Graph");

            final NumberAxis yAxis = new NumberAxis();
            final NumberAxis xAxis = new NumberAxis();
            xAxis.setLabel("Seconds");

            final LineChart<Number,Number> mistakesGraph = new LineChart<Number,Number>(xAxis,yAxis);
            mistakesGraph.setTitle("Mistakes Graph");

            XYChart.Series series = new XYChart.Series();
            series.setName("My portfolio");

            for (MistakesParameters mistakesParameters : ArrayOfMistakesParameters){
                series.getData().add(new XYChart.Data(mistakesParameters.getNumberOfSecond(), mistakesParameters.getCounterOfMistakes()));
            }

            Scene scene = new Scene(mistakesGraph, 800,600);
            mistakesGraph.getData().add(series);

            stage.setScene(scene);
            stage.show();
        }

        public int getCounterOfMistakes() {
            return counterOfMistakes;
        }
    }