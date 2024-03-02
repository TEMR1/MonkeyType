package com.temr1.lesson2_3_maven.monkeytype.Models;

import com.temr1.lesson2_3_maven.monkeytype.Controllers.Controller;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class TimerModel implements Runnable{
    private Label label;
    private int seconds;

    private Controller controller;
    private MistakesGraphModel mistakesGraphModel;

    public void setParameters(Label label, int seconds, Controller controller, MistakesGraphModel mistakesGraphModel){
        this.label = label;
        this.seconds = seconds;
        this.controller = controller;
        this.mistakesGraphModel = mistakesGraphModel;
    }

    @Override
    public void run() {
        for (int time = seconds; time >= 0; time--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            int counterOfMistakes = controller.getCounterOfMistakes();
            int finalTime = time;

            Platform.runLater(() -> {
                label.setText(String.valueOf(finalTime));
                mistakesGraphModel.setPointsToGraph(finalTime, counterOfMistakes);
            });
        }

        Platform.runLater(controller::showMistakesGraph);
    }

    public MistakesGraphModel getMistakesGraphModel() {
        return mistakesGraphModel;
    }
}
