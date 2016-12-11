package com.ctoader.ai.neural.layers;

import java.util.List;

/**
 * Created by crist on 12/11/2016.
 */
public class OutputLayer implements Layer {

    private final int numNeurons;

    public OutputLayer(int numNeurons) {
        this.numNeurons = numNeurons;
    }

    @Override
    public void setNextLayer(Layer layer) {
        throw new IllegalStateException("Output layers are final layers.");
    }

    @Override
    public int getNeuronCount() {
        return this.numNeurons;
    }

    @Override
    public List<Double> forwardPass(List<Double> inputs) {
        inputs.forEach(System.out::println);
        return inputs;
    }
}
