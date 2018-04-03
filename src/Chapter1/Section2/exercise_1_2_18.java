package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;

public class exercise_1_2_18 {
    private double m;
    private double s;
    private int N;

    public void addDataValue(double x){
        N++;
        s = s + 1.0 * (N-1) / N * (x - m) * (x - m);
        m = m + (x - m) / N;
    }

    public double mean(){
        return m;
    }

    public double var(){
        return s/(N-1);
    }

    public double stddev(){
        return Math.sqrt(this.var());
    }

    public static void main(String[] args){
        // Validation here
        exercise_1_2_18 validation = new exercise_1_2_18();
        validation.addDataValue(2);
        validation.addDataValue(4);
        validation.addDataValue(5);

        StdOut.println("Mean: " + validation.mean() + " Expected: 3.666");
        StdOut.println("Variance: " + validation.var() + " Expected: 2.333");
        StdOut.println("Std. Dev.: " + validation.stddev() + " Expected: 1.52");
    }
}
