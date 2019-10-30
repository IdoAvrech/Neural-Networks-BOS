import java.util.Arrays;

public class MiddleLayer {
	
	final static int Middle = constants.middleneurons;
	final static int Input = constants.inputneurons;
	double[][] weights = new double[Middle][Input+1];
	MiddleNeuron[] Neurons = new MiddleNeuron[Middle];
	
	public MiddleLayer(InputLayer input, double[][] weights) {
		this.weights = weights;
		MiddleNeuron[] preNeurons = new MiddleNeuron[Middle];
		for(int i = 0; i<Middle; i++) {
			Neurons[i] = new MiddleNeuron(input, weights[i]);
		}
		
	}
	
	public void update(double[][] weights) {
		this.weights = weights;
		for(int i = 0; i<Middle; i++) {
			Neurons[i].update(weights[i]);
		}
			
		
		
	}

	@Override
	public String toString() {
		System.out.println("middle layer");
		update(weights);
		String values = "\n";
		for(int i =0; i<Middle; i++) {
			values+=" Neurons["+i+"]: value " + Neurons[i].getValue() + "\t";
		}
		return values;
	}
}
