package Chapter1.Section2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class exercise_1_2_11 {
    private int day;
    private int month;
    private int year;

    public exercise_1_2_11(int month, int day, int year){
        if (!isDateValid(month, day, year)){
            throw new IllegalArgumentException("Invalid Date!");
        }
        this.month = month;
        this.day = day;
        this.year = year;
        }

    public int day(){
        return day;
    }

    public int month(){
        return month;
    }

    public int year(){
        return year;
    }

    public String toString(){
        //return month() + "-" + day() + "-" + year();
        return  year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
    }

    public boolean isDateValid(int month, int day, int year) {
        int[] dayInEachMonthLeapYr = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] dayInEachMonthNonLeapYr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean valid = true;

        // We need to check if the year is a leap year or not
        // A leap year is divisible by 4 but not 100; A leap year is also divisible by 400
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            if (year < 1 || month < 1 || month > 12 || day < 1 || day > dayInEachMonthLeapYr[month - 1]) {
                valid = false;
            }
        } else {
            if (year < 1 || month < 1 || month > 12 || day < 1 || day > dayInEachMonthNonLeapYr[month - 1]) {
                valid = false;
            }
        }
        return valid;
    }

    public static void main(String[] args){
        // examples:
        // exercise_1_2_11 validDate = new exercise_1_2_11(9, 3, 1988);
        // exercise_1_2_11 invalidDate = new exercise_1_2_11(12, 40, 1990);
        // exercise_1_2_11 invalidLeapDate = new exercise_1_2_11(2,29,1990);
        // exercise_1_2_11 validLeapDate = new exercise_1_2_11(2,29,2000);
        StdOut.print("Enter month: ");
        int month = StdIn.readInt();
        StdOut.print("Enter day: ");
        int day = StdIn.readInt();
        StdOut.print("Enter year: ");
        int year = StdIn.readInt();
        exercise_1_2_11 smartDate = new exercise_1_2_11(month,day,year);
        StdOut.println(smartDate);
    }
}
