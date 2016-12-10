package pl.ishfid.psi;

import static java.lang.StrictMath.exp;

/**
 * Created by ishfi on 02.12.2016.
 */
public class McCullohPitts extends Neuron{
    public McCullohPitts(int inputCount) {
        super(inputCount);
    }

    public McCullohPitts(int inputCount, boolean inInputLayer) {
        super(inputCount, inInputLayer);
    }

    @Override
    protected double derivativeFunction(){
        return (1 - this.getOutputVal()) * this.getOutputVal();
    }

    // Calculate output including activation function
    @Override
    public void calcOutput(){
        double out = 1 + exp(-calcSum());

        this.outputVal = (1 / out);
    }

    @Override
    public void updateWeights(){
        for (NeuronInput input: this.getInputs()) {
            double newWeight = input.getWeight() + 0.15 *
                    (this.targetVal - this.outputVal * derivativeFunction() * input.getInputVal());
            input.setWeight(newWeight);
        }
    }
}