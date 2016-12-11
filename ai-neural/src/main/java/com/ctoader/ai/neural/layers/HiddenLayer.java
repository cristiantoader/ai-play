package com.ctoader.ai.neural.layers;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by crist on 12/11/2016.
 */
public class HiddenLayer implements Layer {

    private Layer nextLayer;
    private final List<HiddenNeuron> hiddenNeurons;

    public HiddenLayer(int inputSize, int numHiddenNeurons, Function<Double, Double> hiddenFunction) {
        this.hiddenNeurons = IntStream.of(0, numHiddenNeurons - 1)
                .mapToObj(i -> new HiddenNeuron(inputSize, hiddenFunction))
                .collect(Collectors.toList());

        this.nextLayer = new OutputLayer(numHiddenNeurons);
    }

    @Override
    public void setNextLayer(Layer layer) {
        this.nextLayer = layer;
    }

    @Override
    public List<Double> forwardPass(List<Double> inputs) {
        List<Double> layerOutputs = IntStream.of(0, this.hiddenNeurons.size() - 1)
                .mapToObj(i -> this.hiddenNeurons.get(i))
                .map(hiddenNeuron -> hiddenNeuron.calculate(inputs))
                .collect(Collectors.toList());

        return this.nextLayer.forwardPass(layerOutputs);
    }

    @Override
    public int getNeuronCount() {
        return this.hiddenNeurons.size();
    }
}
