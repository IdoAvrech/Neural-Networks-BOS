import java.util.Arrays;

public class OutputNeuron {
	final static int Middle = constants.middleneurons;
	double value;
	double weights[] = new double[Middle+1];
	MiddleLayer middle;
	public OutputNeuron(MiddleLayer middle, double[] weights) {
		this.middle = middle;
		double sum = weights[Middle];
		this.weights = weights;
		for(int i = 0; i<Middle; i++) {
			sum+=weights[i]*middle.Neurons[i].getValue();
		}
		
		this.value = sum;
	}

	public static int getMiddle	() {
		return Middle;
	}

	public double getValue() {
		
		return value;
	}
	
	public void update(double[] weights) {
		double sum = weights[Middle];
		this.weights = weights;
		for(int i = 0; i<Middle; i++) {
			sum+=weights[i]*middle.Neurons[i].getValue();
		}
		
		this.value = sum;
		
	}
	
	public double getValue(double[] Weights) {
		double sum = weights[Middle];
		this.weights = Weights;
		for(int i = 0; i<Middle; i++) {
			sum+=weights[i]*middle.Neurons[i].getValue();
		}
		this.value = sum;
		//System.out.println("end sum: " + sum);
		return this.value;
	}


	@Override
	public String toString() {
		return "\nOutputNeuron [value=" + value ;
	}

	public double[] getWeights() {
		return weights;
	}
	
	
}
