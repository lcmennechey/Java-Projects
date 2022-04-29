import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Author name: Lisbeth Mennechey
 * Date: 11/22/20
 */

//This Hashing class creates a list of holidays and sorts the list by earliest date
public class Hashing {

	public static void main(String[] args) {

		// create date objects
		Date newYears = new Date(2020, 1, 1);
		Date martinLutherKingsDay = new Date(2020, 1, 20);
		Date presidentsDay = new Date(2020, 2, 17);
		Date memorialDay = new Date(2020, 5, 25);
		Date independenceDay = new Date(2020, 4, 4);
		Date laborDay = new Date(2020, 9, 7);
		Date colombusDay = new Date(2020, 10, 12);
		Date veteransDay = new Date(2020, 11, 11);
		Date thanksgiving = new Date(2020, 11, 26);
		Date christmas = new Date(2020, 12, 25);
		
		//create list of dates and add holidays
		List<Date> holidayList = new ArrayList<>();

		holidayList.addAll(Arrays.asList(thanksgiving, newYears, martinLutherKingsDay,
				presidentsDay, memorialDay, veteransDay, independenceDay,
				christmas, colombusDay, laborDay));

		//sort dates and display holiday list
		Collections.sort(holidayList);

		System.out.println("The sorted holiday list for 2020 is: \n" + holidayList);
	}
}

class Date implements Comparable<Date> {
	private int year;
	private int month;
	private int day;

	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	
	//The equals method returns true if the object has the same year, month, and day
	@Override 
	public boolean equals(Object otherDate) {
		return year == ((Date) otherDate).year && month == ((Date) otherDate).month && day == ((Date) otherDate).day;
	}

	
	//The hashCode method returns an integer value that is representative of the input value
	@Override
	public int hashCode() {
		return year * 10000 + month * 100 + day;
	}

	
	//The compareTo method compares the hashcode for each Date object	
	public int compareTo(Date otherDate) {
	 
		// if this.hashcode is less than the otherDate hashcode, it returns -1
		// if this.hashcode is more than the otherDate hashcode, it returns 1
		// else it returns 0
		return this.hashCode() < otherDate.hashCode() ? -1 : this.hashCode() > otherDate.hashCode() ? 1 : 0;
	}

	@Override
	public String toString() {
		return month + "/" + day + "/" + year;
	}
}
