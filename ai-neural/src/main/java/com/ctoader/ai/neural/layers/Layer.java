package com.ctoader.ai.neural.layers;

import java.util.List;

/**
 * Created by crist on 12/11/2016.
 */
public interface Layer {
    int getNeuronCount();

    void setNextLayer(Layer layer);

    List<Double> forwardPass(List<Double> inputs);

}
