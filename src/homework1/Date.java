/**
 * This class will take in 3 parameters and create the next date
 * out of them.
 * 
 * @author Gabe Le
 * Created 6/27/2017
*/
package homework1;

public class Date {
	// needs 3 parameters: the month, day, and year all in integers
	private int month1, day1, year1;
	
	// all the months are contained in this array
	private  final String[] monthArray = {"January", "February", "March", "April", "May",
			"June", "July", "August", "September", "October", "November", "December"};
	
	// this is where the integer month will be converted into a string
	private String wordMonth;
	
	/**
	 * Creates a new date with 3 unique values
	 * @param month
	 * @param day
	 * @param year
	 */
	public Date(int month, int day, int year) {
		this.month1 = month;
		this.day1 = day;
		this.year1 = year;
	}
	
	
	/**
	 * Group of if statements checking every scenario of the date
	 * if it is a leap year, end of year, if the day exists in the 
	 * month, etc.
	 */
	public void advance() {
		// checking if all variables are valid numbers, if not then throw an error
		if(month1 > 12 || month1 < 1 || day1 > 31 || day1 < 1 || year1 < 0) 
			throw new java.lang.RuntimeException("Invalid input!!!");
		// checking if for months with 30 days, input is valid
		if((month1 == 4 || month1 == 6 || month1 == 9 || month1 == 11) && day1 == 31) {
			throw new java.lang.RuntimeException("Day doesn't exist!!!");
		}
		
		int leap = year1 % 4;
		
		// checking for February leap year and if the day is the very last
		if(month1 == 2 && day1 == 29 && leap == 0) {
			month1++;
			day1 = 0;
		}
		// dealing with February if day is over 28 and not a leap year
		if(month1 == 2 && (day1 == 29 || day1 == 30 || day1 == 31) && leap != 0) {
			throw new java.lang.RuntimeException("Day doesn't exist!!!"); 
		}
		// dealing with February if day is over 29 and a leap year
		else if(month1 == 2 && (day1 == 29 || day1 == 30 || day1 == 31) && leap == 0) {
			throw new java.lang.RuntimeException("Day doesn't exist!!!");
		}
		
		// checks if month is the last day of September then increments the year
		if(month1 == 12 && day1 == 31) {
			month1 = 1;
			day1 = 0;
			year1++;
		}
		
// day checks with and if else loop
		// checks if months with 30 days has a valid day (like not 31) 
		if((month1 == 4 || month1 == 6 || month1 == 9 || month1 == 11) && day1 == 30) {
			month1++;
			day1 = 1;
		}
		// checks if month with 31 days has a valid day
		else if((month1 == 1 || month1 == 2 || month1 == 3 || month1 == 5 || month1 == 7
				|| month1 == 8 || month1 == 10) && day1 == 31) {
			month1++;
			day1 = 1;
		}
		// increment just the date if no if loops run
		else {
			day1++;
		}
		// if a month with 30 days is inputed with 31, then fix the problem
		// by changing the month and day by 1
		if (day1 == 32) {
			month1++;
			day1 = 1;
		}
		// array starts at 0 index
		wordMonth = monthArray[month1 - 1];
	}
	
	
	/**
	 * simple method that returns the formatted string
	 * by inserting data from advance using the .format
	 */
	public String toString() {
		return String.format(wordMonth + "/%d/%d", day1, year1);
	}
}
