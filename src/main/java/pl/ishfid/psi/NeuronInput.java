package pl.ishfid.psi;

import java.util.Random;

/**
 * Created by ishfi on 02.12.2016.
 */
public class NeuronInput {
    protected double inputVal;
    protected double weight;
    private double rangeMin = -1;
    private double rangeMax = 1;
    private Random random;

    public NeuronInput() {
        this.random = new Random();
        this.weight = randnomWeight();
    }

    public NeuronInput(double inputVal) {
        this.inputVal = inputVal;
    }

    public NeuronInput(boolean inInputLayer) {
        if(inInputLayer){
            this.weight = 1.0;
        }else{
            this.weight = randnomWeight();
        }
    }

    protected double randnomWeight() {
        double randomValue = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
        return randomValue;
    }

    public double getInputVal() {
        return inputVal;
    }

    public void setInputVal(double inputVal) {
        this.inputVal = inputVal;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getOutputVal() {
        return (this.weight * this.inputVal);
    }

    public void updateWeight(double delata) {
        this.weight += delata;
    }
}