package com.example.CoinGame;

public class QuickUnionWeighted {
    int arr[];
    int size[];

    public QuickUnionWeighted(int n)
    {
        arr = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=i;
            size[i]=1;
        }

    }
    public int root(int p)
    {
        //searching for the top root element here
        while(p != arr[p])
        {
            p=arr[p];

        }
        return p;

    }
    public boolean isConnected(int p,int q)
    {
        return root(p) == root(q);
    }

    /**
     * union(4,5)
     * the root of element 4 will now point to root of 5 , it will create a tree structure
     * this way all the elements connected to 4 will now be connected to tree of element 5th
     * @param p
     * @param q
     */
    public void union(int p,int q){
        //change the root
        int i = root(p);
        int j = root(q);
        if(i == j)
            return;
        // due to size array we will always
        //point the lower tree under root of bigger tree
        if(size[i] > size[j])
        {
            arr[j] = i;
            size[i] =  size[i] + size[j];
        }
        else
        {
            arr[i]=j;
            size[j] = size[j] + size[i];
        }
        arr[i]=j;
    }
}
