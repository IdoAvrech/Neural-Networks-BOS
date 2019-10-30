
public class InputNeuron {
		@Override
	public String toString() {
		return "InputNeuron [Value=" + Value + "]";
	}

		Double Value;
		public InputNeuron(Point Latest, Point other) {
			Value = (Latest.getY()-other.getY())/(Latest.getX()-other.getX());
			if(Latest.getX() == other.getX())this.Value = 1.0;
		}
		public Double getValue() {
			
			return this.Value;
		}
		
		public void setValue(Point Latest, Point other) {
			Value = (Latest.getY()-other.getY())/(Latest.getX()-other.getX());
			if(Latest.getX() == other.getX())this.Value = 1.0;

		}
}
