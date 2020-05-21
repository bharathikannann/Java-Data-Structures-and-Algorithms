class QSort{
    public int partition(int[] array,int l,int h){
        int i=l;
        int pivot=array[h];
        for(int j=l;j<h;j++){
            if(array[j]<=pivot){
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                i++;
            }
        }
        int temp=array[i];
        array[i]=array[h];
        array[h]=temp;
        return i;
    }
    public void sort(int[] array,int l,int h){
        if(l<h){
            int p=partition(array,l,h);
            sort(array,l,p-1);
            sort(array,p+1,h);
        }
    }
}
public class QuickSort {
    public static void main (String[] args) {
    int[] array={10, 7, 8, 9, 1, 5,6,34,521,6,31,35216,621,62,2136,4126,62};
    int n=array.length;
    QSort qs=new QSort();
    qs.sort(array,0,n-1);
    for(int i=0;i<n;i++){
        System.out.println(array[i]);
    }
    }
}
