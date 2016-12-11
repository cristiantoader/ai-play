package com.ctoader.ai.neural.network;

import com.ctoader.ai.neural.layers.Layer;
import com.ctoader.ai.neural.layers.OutputLayer;

import java.util.List;

/**
 * Created by crist on 12/11/2016.
 */
public class NeuralNetwork {

    private Layer firstLayer;
    private OutputLayer outputLayer;

    NeuralNetwork(Layer firstLayer, OutputLayer outputLayer) {
        this.firstLayer = firstLayer;
        this.outputLayer = outputLayer;
    }

    public List<Double> processInput(List<Double> inputs) {
        return this.firstLayer.forwardPass(inputs);
    }

    public void trainInput(List<Double> inputs, List<Double> expectedOutputs) {
        List<Double> actualOutputs = this.firstLayer.forwardPass(inputs);
    }


}
