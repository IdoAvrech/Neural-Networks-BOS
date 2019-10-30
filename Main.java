import java.util.Scanner;
import java.io.File;
public class Main {



	public static void main(String[] args) throws Exception {
		final int datalength = 1360;
		final int neurons = constants.inputneurons;
		final int middle = constants.middleneurons;
		double[] datadouble =new double[1811];
		File file =
				new File("data");
		Scanner sc = new Scanner(file);
		int indexdata = 0;
		while (sc.hasNextLine()){
			datadouble[indexdata] = Integer.valueOf(sc.nextLine());
			indexdata++;
		}

		Point[] data = new Point[datadouble.length];
		for(int i = 0; i<data.length; i++) {
			data[i] = new Point(datadouble[i], i);
		}

		Point[][] TrainData = new Point[datalength-neurons+1][neurons];
		for(int i = 0; i<TrainData.length; i++) {
			for(int j = 0; j<neurons; j++) {
				TrainData[i][j] = data[i+j];
			}
		}
		/*
		for(int i = 0; i<TrainData.length; i++) {
			for(int j = 0; j<neurons; j++) {
				System.out.print(i+", " + j + " "+TrainData[i][j] + " ");
			}
			System.out.println();
		}*/


		double[][] Weights = new double[middle][neurons+1];
		for(int i = 0; i<Weights.length; i++) {
			for(int j = 0; j<Weights[i].length; j++) {
				Weights[i][j] = constants.start;
			}
		}
		double[] WeightsEnd = new double[middle+1];
		for(int j = 0; j<WeightsEnd.length; j++) {
			WeightsEnd[j] = constants.start;
		}
		/*
		Point[] TestData = new Point[365];
		for(int i = 0; i<TestData.length; i++) {
			double value = kb.nextDouble();
			TestData[i] = new Point(value, i);
			System.out.println(TestData[i]);
		}*/



		Neural MyNetwork = new Neural(TrainData[0], Weights, WeightsEnd);
		//System.out.println(MyNetwork.Middle.Neurons[1].sigmoid(10000));
		MyNetwork.FixEverything(TrainData);
		MyNetwork.PrintWeights();
		double[] test = new double[]{20.43,19.88,19.9,19.71,19.74,20.23,20.19,20.04,20.46,20.67,20.56,20.57,20.36,20.48};
		Point[] smalltest = new Point[test.length];
		for(int i = 0; i<test.length; i++) {
			smalltest[i] = new Point(test[i], i);
		}
		System.out.println("idodi is amazing "+MyNetwork.run(smalltest));
		char ans;





	}

}
