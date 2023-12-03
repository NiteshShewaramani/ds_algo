package com.example.CoinGame;

public class QuickFind {
    int arr[];
    //initializing all element with there index
    public QuickFind(int n)
    {
        arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=i;
        }
    }

    public boolean isConnected(int p,int q)
    {
        return arr[p] == arr[q];
    }


    public void union(int p,int q)
    {
        //getting id of both the element to connect
        //then changing the ids of p elements to id of q element
        int pid = arr[p];
        int qid = arr[q];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] == pid)
            {
                arr[i] = qid;
            }
        }

    }

}
