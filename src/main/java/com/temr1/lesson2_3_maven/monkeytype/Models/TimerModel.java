package com.temr1.lesson2_3_maven.monkeytype.Models;

import javafx.scene.control.Label;

public class TimerModel extends BaseTimerModel{
    private Label label;
    private int seconds;

    public void setParameters(Label label, int seconds) {
        this.label = label;
        this.seconds = seconds;
    }

    @Override
    public void run() {
        for (int time = seconds; time >= 0; time--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            label.setText(String.valueOf(time));
        }
    }
}
