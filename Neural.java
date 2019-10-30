import java.util.Arrays;

public class Neural {
	
	InputLayer Input;
	MiddleLayer Middle;
	OutputNeuron Output;
	double[][] WeightsMiddle;
	double[] WeightsEnd;
	Point[] data;

	public Neural(Point[] data, double[][] WeightsMiddle, double[] WeightsEnd) {
		Input = new InputLayer(data);
		Middle = new MiddleLayer(Input, WeightsMiddle);
		Output = new OutputNeuron(Middle, WeightsEnd);
		this.WeightsMiddle = WeightsMiddle;
		this.WeightsEnd = WeightsEnd;
	}
	
	
	public InputLayer getInput() {
		return Input;
	}
	
	public void setInput(InputLayer input) {
		Input = input;
	}
	
	public MiddleLayer getMiddle() {
		return Middle;
	}
	
	public void setMiddle(MiddleLayer middle) {
		Middle = middle;
	}
	
	public OutputNeuron getOutput() {
		return Output;
	}
	
	public void setOutput(OutputNeuron output) {
		Output = output;
	}
	
	public double[][] getWeightsMiddle() {
		return WeightsMiddle;
	}
	
	public void setWeightsMiddle(double[][] weightsMiddle) {
		WeightsMiddle = weightsMiddle;
	}
	
	public double[] getWeightsEnd() {
		return WeightsEnd;
	}
	
	public void setWeightsEnd(double[] weightsEnd) {
		WeightsEnd = weightsEnd;
	}
	
	public Point[] getData() {
		return data;
	}
	
	public void setData(Point[] data) {
		this.data = data;
	}
	
	public double run(Point[] data) {
		Input.setData(data);
		update();
		return Output.getValue();
	}
	
	@Override
	public String toString() {
		return "Neural network: " + "\ninput: " + Input + "\nmiddle" + Middle + "\noutput: " + Output;
	}


	public double costanalysis(Point[][] data) {
		double sum = 0;
		int i;
		for(i = 1; i<data.length; i++) {
			
			sum+=Math.abs((run(data[i])/(data[i-1][0].getY()/data[i-1][1].getY()))-1);
		}
		double avg = sum/(data.length-1);
		return avg*100;

	}
	
	public void update() {
		Middle.update(WeightsMiddle);
		Output.getValue(WeightsEnd);
	}
	
	public void FixWeightMiddle(Point[][] data, int i, int j, int resolution) {
		double change = WeightsMiddle[i][j];
		
		for(int count = 0; count<resolution; count++) {
			toString();	
			double cost = costanalysis(data);
			System.out.println("cost: " + cost + " iteration number " + count + " weight number " + i + ","+j);
			double origianl = WeightsMiddle[i][j];
			this.WeightsMiddle[i][j]+=change;	
			update();
			double costplus = costanalysis(data);
			this.WeightsMiddle[i][j]=WeightsMiddle[i][j]-2*change;
			update();
			double costminus = costanalysis(data);
			this.WeightsMiddle[i][j]+=change; //back to square 1
			update();
			if(min(cost, costplus, costminus) == cost)change=change*constants.delta;
			else if(min(cost, costplus, costminus) == costminus) this.WeightsMiddle[i][j]=WeightsMiddle[i][j]-change;
			else if(min(cost, costplus, costminus) == costplus) this.WeightsMiddle[i][j]=WeightsMiddle[i][j]+change;
		}
		
	}
	
	public void FixWeightEnd(Point[][] data, int i, int resolution) {
		double change = WeightsEnd[i];
		
		for(int count = 0; count<resolution; count++) {
			double cost = costanalysis(data);
			System.out.println("cost: " + cost + " iteration number " + count + " weight number " + i );
			double origianl = WeightsEnd[i];
			this.WeightsEnd[i]+=change;	
			double costplus = costanalysis(data);
			this.WeightsEnd[i]=WeightsEnd[i]-2*change;	
			double costminus = costanalysis(data);
			this.WeightsEnd[i]+=change; //back to square 1
			if(min(cost, costplus, costminus) == cost)change=change*constants.delta;
			else if(min(cost, costplus, costminus) == costminus) this.WeightsEnd[i]=this.WeightsEnd[i]-change;
			else if(min(cost, costplus, costminus) == costplus) this.WeightsEnd[i]=this.WeightsEnd[i]+change;
		}
		
	}
	
	public void FixEverything(Point[][] data) {
		for(int countdowns = 0; countdowns<constants.totalrep; countdowns++) {
			for(int i = 0; i< WeightsMiddle.length; i++) {
				for(int j = 0; j<WeightsMiddle[i].length; j++ ) {
					FixWeightMiddle(data, i, j, i);
				}
			}
		
			for(int i = 0; i<WeightsEnd.length; i++) {
				FixWeightEnd(data, i, i);
			}
			PrintWeights();
		}
		
	}
	
	
	public double min(double a, double b, double c) {
		if(a < b && a < c) return a;
		if(b < a && b < c)return b;
		else return c;
	}
	
	public double middle(double a, double b, double c) {
		if((a < b && a > c) || (a > b && a < c))return a;
		if((b < a && b > c) || (b > a && b < c))return b;
		else return c;
	}
	
	public double max(double a, double b, double c) {
		if(a > b && a > c) return a;
		if(b > a && b > c)return b;
		else return c;
	}
	
	public void PrintWeights() {
		System.out.println("end weights: ");
		for(int i = 0; i< WeightsEnd.length; i++) {
			System.out.print("	" + WeightsEnd[i]);
		}
		
		System.out.println("Middle weights: ");
		
		for(int i = 0; i< WeightsMiddle.length; i++) {
			for(int j = 0; j<WeightsMiddle[i].length; j++) {
				System.out.print("	" + WeightsMiddle[i][j]);
			}
			System.out.println();

		}
		
	}
	 
}
