package com.temr1.lesson2_3_maven.monkeytype.Models;

import java.util.ArrayList;

public class MistakesGraphModel extends BaseGraphModel{
    private ArrayList<MistakesParameters> mistakesGraph = new ArrayList<>();

    public ArrayList<MistakesParameters> getGraphPointsArray() {
        return mistakesGraph;
    }

    @Override
    public void setPointsToGraph(int numberOfSecond, int counterOfMistakes) {
        MistakesParameters mistakesParameters = new MistakesParameters(counterOfMistakes, numberOfSecond);
        mistakesGraph.add(mistakesParameters);
    }
}
