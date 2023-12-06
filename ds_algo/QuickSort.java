package com.example.CoinGame;

public class QuickSort {
    public static void main(String[] args) {
        int array[] = new int[]{7,81,32,5,12,100,6,4,6,2,4,9,11,55,22};
        Sort(array);
        for(int value : arraySort){
            System.out.println(" sorted values  "+ value);
        }

    }

    public static int arraySort[];
    //this is a quick sort with dijktras and uses 3 way
    public static void Sort(int arr[]){
        arraySort = new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            arraySort[i]=arr[i];
        }
        sort(0,arr.length-1);
    }

    public static  void sort(int low,int high){
        if(high<=low)
            return;
        int v = arraySort[low];
        int lt = low;
        int gt = high;
        int i=low;

        //this while loop has partioning logic
        while(i<=gt)
        {
            if(arraySort[i]<v)
            {
                //swap
                int swap = arraySort[lt];
                arraySort[lt] = arraySort[i];
                arraySort[i] = swap;
                ++i;
                ++lt;
            }
            else if(arraySort[i]>v)
            {
                int swap = arraySort[gt];
                arraySort[gt] = arraySort[i];
                arraySort[i] = swap;
                --gt;
            }
            else
                ++i;

        }
        sort(low,lt-1);
        sort(gt+1,high);

    }


}
