import java.util.Arrays;

public class InputLayer {
	
	

	final static int amount = constants.inputneurons;
	InputNeuron[] Neurons = new InputNeuron[amount];
	Point[] data = new Point[amount];
	
	public InputLayer(Point[] data){
		for(int i = 0; i<amount; i++) {
			Neurons[i] = new InputNeuron(data[0], data[i]);
		}
		this.data = data;
	}
	
	public void setData(Point[] data) {
		this.data = data;

		
		for(int i = 0; i<data.length; i++) {
			Neurons[i].setValue(data[0], data[i]);
		}
	}
	
	public String toString() {
		
		String values = "\n";
		for(int i = 0; i<Neurons.length; i++) {
			
			values+="Neuron["+i+"] = "+Neurons[i].getValue();
		}
		return values;
	}

}
