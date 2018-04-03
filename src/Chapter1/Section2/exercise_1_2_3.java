package Chapter1.Section2;

import edu.princeton.cs.algs4.*;
import java.util.*;

public class exercise_1_2_3 {
    // Write an Interval2D client that takes command-line argument
    // N, min, and max and generate N random 2D intervals whose width
    // and height are uniformly distributed between min and max in the
    // unit square. Draw them on StdDraw and print the number of pairs
    // of intervals that intersect and the number of intervals that are
    // contained in one another

    // Since Interval2D takes Interval1D as arguments, we have to generate
    // Interval1D first, then we will be able to generate Interval2D

    public static void main(String[] args){
        StdOut.print("Please enter the number N: ");
        int n = StdIn.readInt();
        StdOut.print("Please enter the max: ");
        double max = StdIn.readInt();
        StdOut.print("Please enter the min: ");
        double min = StdIn.readInt();

        Interval2D[] int2Ds = new Interval2D[n];
        Interval1D[][] int1Ds = new Interval1D[n][2];

        generateInt1D(int1Ds,n,min,max);
        generateInt2D(n,int2Ds,int1Ds);
        drawInt2D(int2Ds,max);
        int result1 = (int)numOfIntersect(int2Ds);
        StdOut.print("The number of intersect is: " + result1);
        StdOut.println();
        int result2 = (int)numOfContain(int1Ds,n);
        StdOut.print("The number of contain is: " + result2);
    }

    // generate a Interval1D[][]
    private static void generateInt1D(Interval1D[][] int1, int n, double a, double b){
        for(int i = 0; i < n; i++){
            double min1 = StdRandom.uniform(a, b);
            double max1 = StdRandom.uniform(min1, b);
            double min2 = StdRandom.uniform(a, b);
            double max2 = StdRandom.uniform(min2, b);

            int1[i][0] = new Interval1D(min1, max1);
            int1[i][1] = new Interval1D(min2, max2);
        }
    }

    // Generate the Interval2D based on n, Interval2D[] a, and Interval1D[][] b
    private static void generateInt2D(int n, Interval2D[] a, Interval1D[][] b){
        for(int i = 0; i < n; i++){
            Interval2D interval2 = new Interval2D(b[i][0], b[i][1]);
            a[i] = interval2;
        }
    }

    // Now we can write the method that draw the Interval 2D
    private static void drawInt2D(Interval2D[] a, double max){
        StdDraw.setCanvasSize((int)max,(int)max);
        StdDraw.setPenRadius(0.02);
        StdDraw.setYscale(-1, max+1);
        StdDraw.setXscale(-1, max+1);
        for(int i = 0; i < a.length; i ++){
            a[i].draw();
        }
    }

    private static double numOfIntersect(Interval2D[] a){
        int count = 0;
        for(int i = 1; i < a.length; i++){
            if(a[i].intersects(a[i-1])){
                count++;
            }
        }
        return count;
    }

    private static double numOfContain(Interval1D[][] a, int n){
        int containCount = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(a[i][0].min() < a[j][0].min() && a[i][0].max() > a[j][0].max() && a[i][1].min() < a[j][1].min() &&
                        a[i][1].max() > a[j][1].max()){
                    containCount++;
                }
            }
        }
        return containCount;
    }
}
