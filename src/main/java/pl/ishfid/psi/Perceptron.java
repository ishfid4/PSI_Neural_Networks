package pl.ishfid.psi;

import java.util.Random;

import static java.lang.StrictMath.exp;

/**
 * Created by ishfi on 2.12.2016.
 */
public class Perceptron extends Neuron{
    private double learningRate = 0.05;     // TODO: make this dependant on  variable in Network class
    private double bias;
    private Random random;

    public Perceptron(int inputCount) {
        super(inputCount);
        this.random = new Random();
        this.bias = randnomBias();
    }

    public Perceptron(int inputCount, boolean inInputLayer) {
        super(inputCount, inInputLayer);
        this.random = new Random();
        this.bias = randnomBias();
    }

    // Calculate output including activation function
    @Override
    public void calcOutput(){
        if (calcSum() + bias > 0){
            outputVal = 1;
        }else{
            outputVal = 0;
        }
    }

    @Override
    public void updateWeights(){
        for (NeuronInput input: this.getInputs()) {
            double newWeight = input.getWeight() + learningRate *
                    (this.targetVal - this.outputVal * derivativeFunction() * input.getInputVal());
            input.setWeight(newWeight);
        }
        this.bias += learningRate * (this.targetVal - this.outputVal);
    }

    protected double randnomBias() {
        double rangeMax = 1;
        double rangeMin = -1;
        double randomValue = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
        return randomValue;
    }
}
