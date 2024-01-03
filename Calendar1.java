/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	static int sundaysOnFirst = 0;
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
	    int debugDaysCounter = 0; 
	    //// Write the necessary initialization code, and replace the condition
	    //// of the while loop with the necessary condition 
		while (year <= 1999) {
            advance();
            // Print current date
            System.out.println(dayOfMonth + "/" + month + "/" + year + (dayOfWeek == 1 ? " Sunday" : ""));
            // Check for Sundays on the first day
            if (dayOfMonth == 1 && dayOfWeek == 1) {
                sundaysOnFirst++;
            }
            year++;
        }
        // Print final report
        System.out.println("During the 20th century, " + sundaysOnFirst + " Sundays fell on the first day of the month");
    }

    // Function to advance counters
    private static void advance() {
        dayOfMonth++;

        if (dayOfMonth > nDaysInMonth) {  // Move to next month if needed
            dayOfMonth = 1;
            month++;
        }

        if (month > 12) {  // Move to next year if needed
            month = 1;
            year++;
        }

        dayOfWeek = (dayOfWeek % 7) + 1;  // Ensure dayOfWeek cycles from 1 to 7

        nDaysInMonth = nDaysInMonth(month, year);  // Update month length for new month/year
    }
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    boolean isLeapYear;
		// Checks if the year is divisible by 400
		isLeapYear = ((year % 400) == 0);
		// Then checks if the year is divisible by 4 but not by 100
		isLeapYear = isLeapYear || (((year % 4) == 0) && ((year % 100) != 0));
		return isLeapYear;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		int days = 0;
		if (month == 4 || month == 6 || month == 9 || month == 11) {
				days = 30;
			}
		else if (month == 2) {
				if(isLeapYear(year)) {
					days = 29;
				}
				else {
					days = 28;
				}
			}
		else {
			days = 31;
		}
		return days;
	}
}
