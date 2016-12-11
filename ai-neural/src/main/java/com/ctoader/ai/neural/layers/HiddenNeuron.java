package com.ctoader.ai.neural.layers;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.ctoader.ai.neural.helper.Validator.checkLengths;
import static com.ctoader.ai.neural.helper.Validator.checkNotNull;

/**
 * Created by crist on 12/11/2016.
 */
public class HiddenNeuron {

    private final List<Double> weights;
    private final Function<Double, Double> hiddenFunction;

    private static final Random RNG = new Random(System.currentTimeMillis());

    public HiddenNeuron(int size, Function<Double, Double> hiddenFunction) {
        this.hiddenFunction = hiddenFunction;
        this.weights = IntStream.range(0, size)
                .mapToObj(i -> RNG.nextDouble())
                .collect(Collectors.toList());
    }

    public Double calculate(List<Double> inputs) {
        checkNotNull(inputs, "hidden layer input");
        checkLengths(this.weights, inputs, "hidden layer and input layer sizes.");

        Double weightedResult = IntStream.range(0, this.weights.size())
                .mapToDouble(i -> this.weights.get(i) * inputs.get(i))
                .sum();

        return this.hiddenFunction.apply(weightedResult);
    }
}
