
public class Date {
	int day, month, year,DaysSince2000;

	public Date(int day, int month, int year) {
		this.day = day;
		this.year = year;
		this.month = month;
		int sumdays = 0;
		for(int i = 1; i<month; i++) {
			int daysper;
			if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
				daysper = 31;
			}
			if(i == 4 || i == 6 || i == 9 || i == 11) {
				daysper = 30;
			}
			if(i == 2 && year%4 == 0) {
				daysper = 29;
			}
			else {
				daysper = 28;
			}
			sumdays+=daysper;
		}
		
		this.DaysSince2000=(int)(day+sumdays+(year-2000)*365.25);
		
	}
	


	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public int getDaysSince2000() {
		return DaysSince2000;
	}
}
