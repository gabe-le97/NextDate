package homework1;
import java.util.Scanner;
/**
 * Asks the user for the month, day, and year in order to print the next data in
 *  the format month/day/year
 * @author gabe
 *
 */
public class MyProgram {
	public static void main(String[] args) {
		Scanner numb = new Scanner(System.in);
		Date dateObj;
		
		// run until the correct inputs are given
		while(true) {
			try {
				System.out.print("What is the month number? ");
				int month = numb.nextInt();
				System.out.print("What is the day number? ");
				int day = numb.nextInt();
				System.out.print("What is the year? ");
				int year = numb.nextInt();
			
				dateObj = new Date(month, day, year);
				// will throw a runtimeException if any one of the numbers are invalid
				dateObj.advance();
				break;
			} catch(RuntimeException e) {
				System.out.println("Please check your month number, day, or year again");
			}
		}
		String dateString = dateObj.toString();
		System.out.println("\nThe next date is " + dateString);
		numb.close();
	}
}
