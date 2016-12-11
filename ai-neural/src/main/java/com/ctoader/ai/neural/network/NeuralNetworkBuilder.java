package com.ctoader.ai.neural.network;

import com.ctoader.ai.neural.layers.HiddenLayer;
import com.ctoader.ai.neural.layers.Layer;
import com.ctoader.ai.neural.layers.OutputLayer;

import java.util.LinkedList;
import java.util.function.Function;

/**
 * Created by crist on 12/11/2016.
 */
public class NeuralNetworkBuilder {

    private final int inputSize;

    private LinkedList<Layer> hiddenLayers = new LinkedList<>();
    private OutputLayer outputLayer = null;

    public NeuralNetworkBuilder(int inputSize) {
        this.inputSize = inputSize;
    }

    public NeuralNetworkBuilder hiddenLayer(int layerSize, Function<Double, Double> hiddenFunction) {
        if (this.hiddenLayers.size() == 0) {
            return this.firstHiddenLayer(layerSize, hiddenFunction);
        }

        return hiddenLayer(this.hiddenLayers.getLast().getNeuronCount(), layerSize, hiddenFunction);
    }

    private NeuralNetworkBuilder hiddenLayer(int inputSize, int layerSize, Function<Double, Double> hiddenFunction) {
        // create it
        HiddenLayer hiddenLayer = new HiddenLayer(inputSize, layerSize, hiddenFunction);

        // link it to the last
        this.hiddenLayers
                .getLast()
                .setNextLayer(hiddenLayer);

        this.hiddenLayers.add(hiddenLayer);
        return this;
    }

    private NeuralNetworkBuilder firstHiddenLayer(int layerSize, Function<Double, Double> hiddenFunction) {
        HiddenLayer hiddenLayer = new HiddenLayer(this.inputSize, layerSize, hiddenFunction);
        this.hiddenLayers.add(hiddenLayer);
        return this;
    }

    public NeuralNetworkBuilder outputLayer(OutputLayer outputLayer) {
        this.outputLayer = outputLayer;
        return this;
    }

    public NeuralNetwork build() {
        NeuralNetwork neuralNetwork = new NeuralNetwork(this.hiddenLayers.getFirst(), this.outputLayer);
        return neuralNetwork;
    }
}
