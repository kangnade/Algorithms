package Chapter1.Section2;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

public class exercise_1_2_14 {
    private String who;
    private double amount;
    private Date when;

    public exercise_1_2_14(String who, Date when, double amount){
        if(Double.isNaN(amount) || Double.isInfinite(amount)){
            throw new IllegalArgumentException("Amount cannot be infinite or NaN");
        }
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public String who(){
        return who;
    }

    public Date when(){
        return when;
    }

    public double amount(){
        return amount;
    }

    @Override
    public String toString(){
        return who + " spent " + amount + " on " + when;
    }

    public boolean equals(Object that){
        if(this == that){
            return true;
        }
        if(this.getClass() != that.getClass()){
            return false;
        }
        if(that == null){
            return false;
        }
        exercise_1_2_14 thatX = (exercise_1_2_14) that;
        if(this.who() != thatX.who()){
            return false;
        }
        if (this.when() != thatX.when()){
            return false;
        }
        if(this.amount() != thatX.amount()){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        exercise_1_2_14 transaction1 = new exercise_1_2_14("George", new Date("1/1/2018"), 5000);
        exercise_1_2_14 transaction2 = new exercise_1_2_14("Bill", new Date("1/2/2018"), 8000);
        exercise_1_2_14 transaction3 = transaction1;
        StdOut.println(transaction1);
        StdOut.println(transaction2);
        StdOut.println("Equals 1: Actual: " + transaction1.equals(transaction3) + " Expected: True");
        StdOut.println("Equals 2: Actual: " + transaction2.equals(transaction3) + " Expected: False");
    }
}
