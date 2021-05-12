import java.util.ArrayList;
import java.util.Random;
public class SortingSim{
    static Random random = new Random();
    public  ArrayList<Double> simArrayList = new ArrayList<Double>();
    private int insertionSort(ArrayList<Double> x){
        int noOfComps=0;
        int i = 1;
        double temp;
        while (i<x.size()){
            temp = x.get(i);
            int j = i-1; 
            while(j>=0 && x.get(j)>temp){
                x.set(j+1,x.get(j));
                j--;
                noOfComps++;
            }
            x.set(j+1,temp);
            i++;
        }
        return noOfComps;
    }

    private int selectionSort(ArrayList<Double> x){
        int noOfComps=0;
        int n=x.size();
        int i,j;
        for(i=0;i<n-1;i++){
            int minPos=i;
            for(j=i+1;j<n;j++){
                if(x.get(j)<x.get(minPos)){
                    minPos = j;
                }
                noOfComps++;
            }
            if(minPos !=i){
                double temp = x.get(i);
                x.set(i,x.get(minPos));
                x.set(minPos,temp);
            }
        }
        return noOfComps;
    }

    private int bubbleSort(ArrayList<Double> x){
        int noOfComps=0;
        double temp;
        int n = x.size();
        for(int i=0;i<n;i++){
            for(int j=n-1;j>i;j--){
                if(x.get(j)<x.get(j-1)){
                    temp = x.get(j);
                    x.set(j,x.get(j-1));
                    x.set(j-1,temp);
                    noOfComps++;
                }
            }
        }
        return noOfComps;
    }

    public void simulationOne(){
        ArrayList<Integer> results1 = new ArrayList<Integer>();
        ArrayList<Integer> results2 = new ArrayList<Integer>();
        ArrayList<Integer> results3 = new ArrayList<Integer>();
        for(int i=5;i<501;i=i+5){
            for(int j=0;j<i;j++){
                simArrayList.add(random.nextDouble()*1000);
            }
            results1.add(insertionSort(simArrayList));
            simArrayList.clear();
            for(int j=0;j<i;j++){
                simArrayList.add(random.nextDouble()*1000);
            }
            results2.add(selectionSort(simArrayList));
            simArrayList.clear();
            for(int j=0;j<i;j++){
                simArrayList.add(random.nextDouble()*1000);
            }
            results3.add(bubbleSort(simArrayList));
            simArrayList.clear();
        }
        simArrayList.trimToSize();
        for(int i=0;i<100;i++){
            int oper=5 + (i/3)*5;
            System.out.println("The results for "+ oper +" are:");
            System.out.println(""+results1.get(i));
            System.out.println(""+results2.get(i));
            System.out.println(""+results3.get(i));
        }
    }
    public void simulationTwo(){
        ArrayList<Double> results1 = new ArrayList<Double>();
        ArrayList<Double> results2 = new ArrayList<Double>();
        ArrayList<Double> results3 = new ArrayList<Double>();
        double start,end,elapsedTime,temp;
        for(int i=5;i<501;i=i+5){
            temp = 0;
           for(int k=0;k<50;k++){
                for(int j=0;j<i;j++){
                simArrayList.add(random.nextDouble()*1000);
                }
                start = System.nanoTime();
                bubbleSort(simArrayList);
                end = System.nanoTime();
                temp += end-start;
                simArrayList.clear();
            }
            results1.add(temp/50);
            temp = 0;
           for(int k=0;k<50;k++){
                for(int j=0;j<i;j++){
                simArrayList.add(random.nextDouble()*1000);
                }
                start = System.nanoTime();
                bubbleSort(simArrayList);
                end = System.nanoTime();
                temp += end-start;
                simArrayList.clear();
            }
            results2.add(temp/50);
           temp = 0;
           for(int k=0;k<50;k++){
                for(int j=0;j<i;j++){
                simArrayList.add(random.nextDouble()*1000);
                }
                start = System.nanoTime();
                bubbleSort(simArrayList);
                end = System.nanoTime();
                temp += end-start;
                simArrayList.clear();
            }
            results3.add(temp/50);
        }
        simArrayList.trimToSize();
        for(int i=0;i<100;i++){
            int oper=5 + (i/3)*5;
            System.out.println("The results for "+ oper +" are:");
            System.out.println(""+results1.get(i));
            System.out.println(""+results2.get(i));
            System.out.println(""+results3.get(i));
        }
    
    }
}