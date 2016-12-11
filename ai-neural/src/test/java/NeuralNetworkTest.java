import com.ctoader.ai.neural.network.NeuralNetwork;
import com.ctoader.ai.neural.network.NeuralNetworkBuilder;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by crist on 12/11/2016.
 */
public class NeuralNetworkTest {

    private static final Random RNG = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        NeuralNetwork neuralNetwork = new NeuralNetworkBuilder(2)
                .hiddenLayer(20, var -> 1d / 1d + Math.pow(Math.E, -var))
                .hiddenLayer(15, var -> (var + 21) / 27)
                .hiddenLayer(15, var -> (var + 21) / 22)
                .build();

        neuralNetwork.processInput(Arrays.asList(1d, 2d));
    }
}
