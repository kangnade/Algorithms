package Chapter1.Section2;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Date;


public class exercise_1_2_13 {
    private String who;
    private double amount;
    private Date when;

    public exercise_1_2_13(String who, Date when, double amount){
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

    public static void main(String[] args){
        exercise_1_2_13 transaction1 = new exercise_1_2_13("George", new Date("1/1/2018"), 5000);
        exercise_1_2_13 transaction2 = new exercise_1_2_13("Bill", new Date("1/2/2018"), 8000);
        StdOut.println(transaction1);
        StdOut.println(transaction2);
    }
}
