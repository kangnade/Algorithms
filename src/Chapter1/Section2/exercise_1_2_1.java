package Chapter1.Section2;

import edu.princeton.cs.algs4.*;
import java.util.*;

public class exercise_1_2_1 {

    /**
     * Written by Nade Kang
     */

    public static void main(String[] args){
        // Allow user to enter a number N
        // Based on the entered value, we generate a empty 2D array from Std Lib
        // We want to generate N random 2D points
        // Then we plot the generated N random 2D points
        // After than, we compute and show the distance of the closest pair of points

        StdOut.print("input N: ");
        int n = StdIn.readInt();
        Point2D[] pointsSet = new Point2D[n];
        genrateRandom(pointsSet);
        drawRandomPoints(pointsSet);
        StdOut.printf("The shortest distance is: %5.3f", shortestDistance(pointsSet));
        // So far we haven't assigned values to newPoints, and we write the three functions
        // in this client class: generateRandom(Point2D [] a), drawRandomPoints(Point2D [] a), and
        // shortestDistance(Point2D [] a)
    }

    private static void genrateRandom(Point2D[] a){
        for(int i = 0; i < a.length; i++){
            double pX = StdRandom.uniform();
            double pY = StdRandom.uniform();

            Point2D p = new Point2D(pX, pY);
            a[i] = p;
        }
    }

    private static void drawRandomPoints(Point2D[] a){
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setPenRadius(0.02);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        for(int i = 0; i < a.length; i++){
            StdDraw.point(a[i].x(),a[i].y());
        }
    }

    private static double shortestDistance(Point2D[] a){
        double distance;
        double shortestDistance = Double.MAX_VALUE;

        // Using both Arrays Class and the Stdlib's Point2D Class
        // we can sort the random points 2D array by their distance
        // to the first element in the array.
        Arrays.sort(a, a[0].distanceToOrder());

        // the distanceTo() method is built in the Point 2D class in Stdlib
        for(int i = 1; i < a.length; i++){
            distance = a[i].distanceTo(a[i-1]);
            if(distance < shortestDistance){
                shortestDistance = distance;
            }
        }
        return shortestDistance;
    }
}
