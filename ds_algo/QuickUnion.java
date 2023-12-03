package com.example.CoinGame;

public class QuickUnion {
    int arr[];

    public QuickUnion(int n)
    {
        arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=i;
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
        arr[i]=j;
    }
}
