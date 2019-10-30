import java.util.Arrays;

public class MiddleNeuron {
	final static int Input = constants.inputneurons;
	double value;
	double weights[] = new double[Input+1];
	InputLayer input;
	public MiddleNeuron(InputLayer input, double[] weights) {
		this.input = input;
		double sum = weights[Input];
		this.weights = weights;
		for(int i = 0; i<Input; i++) {
			sum+=weights[i]*input.Neurons[i].getValue();
		}
		
		
		this.value = (sum);
	}
	
	public void update(double[] weights) {
		this.weights = weights;
		double sum = weights[Input];
		this.weights = weights;
		for(int i = 0; i<Input; i++) {
			sum+=weights[i]*input.Neurons[i].getValue();
		}
		//System.out.println("middle sum " + sum);
		this.value = (sum);
		
	}

	@Override
	public String toString() {
		return "MiddleNeuron [value=" + value + ", weights=" + Arrays.toString(weights) + ", input=" + input + "]";
	}

	public  int getInput() {
		return Input;
	}

	public double getValue() {
		return value;
	}

	public double[] getWeights() {
		return weights;
	}
	
	public double sigmoid(double num) {
		return (2/(1+Math.pow(2.718281828459, -num)))-1;
	}
}
