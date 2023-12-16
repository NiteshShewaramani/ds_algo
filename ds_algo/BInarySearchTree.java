package com.example.CoinGame;

import java.util.ArrayList;
import java.util.List;

public class BInarySearchTree {
    /**
     * what does a binary search tree have
     * insert , delete , smaller element to the left , larger element to the right
     * a node class to store the actual value
     * lets make it a string in java so that we can store both numbers and characters
     */
    private Node root;
    public class Node{
        public String value;
        public Node left;
        public Node right;
        public Node(String value)
        {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }
    public BInarySearchTree(String value)
    {
        root = new Node(value);

    }

    public void insert(String value)
    {
        root = insertV(value,root);
    }
    private Node insertV(String  value,Node t)
    {
        if(t == null)
            return new Node(value);

        int compare = value.compareTo(t.value);
        if (compare <= 0)
        {
            t.left = insertV(value,t.left);
        }
        else
        {
            t.right = insertV(value,t.right);
        }
        return t;
    }
    public void printTree()
    {
        dfs(root);
    }
    private void dfs(Node n)
    {
        if(n==null)
            return;

        if(n.left != null)
            dfs(n.left);
        System.out.println(n.value);
        if (n.right != null)
            dfs(n.right);
    }
    public Node delete(String value,Node n)
    {
        int compare = value.compareTo(n.value);
        if (compare < 0)
        {
            n.left = delete(value,n.left);
        }
        else if(compare >0)
        {
            n.right = delete(value,n.right);
        }
        else
        {
            if (n.left == null)
                return n.right;
            if (n.right == null)
                return n.left;
            //third case when both child tree are not null
            //we need to get minimum child from right sub tree
            List<Node> inorder =new ArrayList<>();
            minimum(n.right,inorder);
            //inorder traversal is sorted
            Node minimum = inorder.get(0);
            System.out.println("minimum is  " + minimum.value);
            System.out.println("node is  " + n.value);
            n.value=minimum.value;
            n.right = delete(minimum.value,n.right);
        }
        return n;
    }
    public void minimum(Node root, List<Node> inOrder)
    {
        if(root==null)
            return;
        if(root.left != null)
            minimum(root.left,inOrder);
        inOrder.add(root);
        if (root.right != null)
            minimum(root.right,inOrder);

    }

    public static void main(String[] args) {
        BInarySearchTree bst = new BInarySearchTree("I");
        bst.insert("A");
        bst.insert("C");
        bst.insert("B");
        bst.insert("E");
        bst.insert("D");
        bst.insert("H");
        bst.insert("F");
        bst.insert("X");
        bst.insert("Y");
        bst.printTree();
        System.out.println("after delete ");
        bst.delete("C", bst.root);
        bst.printTree();
    }
}
