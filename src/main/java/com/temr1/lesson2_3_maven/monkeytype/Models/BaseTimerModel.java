package com.temr1.lesson2_3_maven.monkeytype.Models;

import javafx.scene.control.Label;

public abstract class BaseTimerModel implements Runnable{
    public abstract void setParameters(Label label, int seconds);
}
