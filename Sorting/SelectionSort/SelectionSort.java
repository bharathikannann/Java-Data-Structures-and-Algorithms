import java.util.Scanner;

public class SelectionSort {
    public static Scanner scanner=new Scanner(System.in);
    public static void main(String args[]) {
        System.out.println("Enter the number of inputs");
        int n=scanner.nextInt();
        int[] myIntegers=getIntegers(n);
        sort(myIntegers);
        for(int i=0;i<myIntegers.length;i++){
            System.out.println(myIntegers[i]);
        }
    }

    public static int[] getIntegers(int number){
        System.out.println("Enter the values");
        int[] values=new int[number];
        for(int i=0;i<number;i++){
            values[i]=scanner.nextInt();
        }
        return values;
    }
    public static void sort(int[] array){
        for(int i=0;i<array.length;i++){
            int min=i,temp=0;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[min]){
                   min=j;
                }
            }
            temp=array[i];
            array[i]=array[min];
            array[min]=temp;
        }
    }
}
