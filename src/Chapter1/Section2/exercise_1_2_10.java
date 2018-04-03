package Chapter1.Section2;

import edu.princeton.cs.algs4.*;
import java.util.*;

public class exercise_1_2_10 {

    // Inititate instance variables
    private final int n;
    private final int max;

    private int total = 0;
    private int counter = 0;

    // Initiate constructor
    public exercise_1_2_10(int n, int max){
        this.n = n;
        this.max = Math.abs(max);

        StdDraw.setCanvasSize(1024,512);
        StdDraw.setPenRadius(0.015);
        StdDraw.setXscale(-n, n);
        StdDraw.setYscale(-max, max);
    }

    // the increment method called increase
    public void increse(){
        if(total < n && counter < max){
            total++;
            counter++;

            plotPoint(total, counter);
        }
    }

    // the decrement method called decrease
    public void decrease(){
        if(total < n && Math.abs(counter) < max){
            total--;
            counter--;

            plotPoint(total, counter);
        }
    }

    // the plot method
    public void plotPoint(int total, int counter){
        StdDraw.point(total, counter);
    }

    // the tally method
    public int Visdaltally(){
        return counter;
    }

    // client main class to test
    public static void main(String[] args){
        exercise_1_2_10 visualCounter = new exercise_1_2_10(800, 40);

        for(int i = 0; i < 100; i++){
            if(StdRandom.bernoulli(0.5)){
                visualCounter.increse();
                StdOut.println(visualCounter.Visdaltally());
            }else{
                visualCounter.decrease();
                StdOut.println(visualCounter.Visdaltally());
            }
        }
    }
}
