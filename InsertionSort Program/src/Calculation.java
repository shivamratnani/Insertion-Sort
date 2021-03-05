import java.util.*;
public class Calculation {
    static int[] sorted;
    static int[] finalNumbers;
    double mean;
    public int[] insertionSort(int[] unsorted){
        for (int j = 1; j < unsorted.length; j++) {
            int key = unsorted[j];
            int i = j-1;
            while ( (i > -1) && ( unsorted [i] > key ) ) {
                unsorted [i+1] = unsorted [i];
                i--;
            }
            unsorted[i+1] = key;
        }
        sorted = unsorted;
        return sorted;
    }
    public void print(){
        for (int i = 0; i < sorted.length; i++ ){
            System.out.print(sorted[i]);
            if (i != sorted.length - 1) System.out.print(", ");
        }
        System.out.println("");
    }
    public double mean(){
        double total = 0;
        for(int i = 0; i < sorted.length; i++){
            total = total + sorted[i];
        }
        mean = total/sorted.length;
        System.out.println("The mean is: " + mean);
        return mean;
    }
    public void mode(){
        List<Integer> mode = new ArrayList<Integer>();
        int maxCount=0;
        for (int i = 0; i < sorted.length; ++i){
            int count = 0;
            for (int j = 0; j < sorted.length; ++j){
                if (sorted[j] == sorted[i]) ++count;
            }
            if (count > maxCount){
                maxCount = count;
                mode.clear();
                mode.add(sorted[i]);
            } else if ( count == maxCount ){
                mode.add( sorted[i] );
            }
        }
        System.out.println("Mode: " + mode + " and they occur " + maxCount + " times.");
    }
    public void median(){
        double median = 0;
        if (sorted.length % 2 != 0) median = sorted[sorted.length / 2];
        else{
            int middle = sorted.length/2;
            double preMedian = sorted [middle] + sorted [(middle - 1)];
            median = preMedian/2;
        }
        System.out.println("The median is: " + median);
    }
    public int[] addNumbers(int arraySize, int newArraySize, int [] newNumbers){
        finalNumbers = new int[arraySize + newArraySize];
        for (int i = 0; i < arraySize; i++) {
            finalNumbers[i] = sorted[i];
        }
        int value = 0;
        for(int i = arraySize; i < (arraySize + newArraySize); i++) {
            if (value < newNumbers.length) {
                finalNumbers[i] = newNumbers[value];
                value++;
            }
        }
        return finalNumbers;
    }
    public void StandardDeviation(){
        double sum=0;
        for(int i=0;i<sorted.length;i++) {
            sum += Math.pow((sorted[i]-mean), 2);
        }
        mean = sum/sorted.length;
        double std =Math.sqrt(mean);
        System.out.println("The Population Standard Deviation of the data is " + std);
    }
}
