package com.springSecurityClient;

public class DoublyLinkedList {
    Node head,tail;
    public DoublyLinkedList()
    {

    }
    private static class Node
    {
        int data;
        Node next,previous;
        public Node(int data)
        {
            this.data=data;
        }

    }
    public void insertAtBegining(int data)
    {
        Node node =new Node(data);
        if(head==null)
        {
            //no node exists
            head=node;
            tail=node;
        }
        else{
            node.next=head;
            head.previous=node;
            head=node;
        }
    }
    public void display()
    {
        Node current=head;
        while(current !=null)
        {
            System.out.print(current.data+"-->");
            current=current.next;
        }
        System.out.print(current);
    }
    public void reverse()
    {
        Node current=tail;
        while(current !=null)
        {
            System.out.print(current.data+"-->");
            current=current.previous;
        }
        System.out.print(current);

    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtBegining(3);
        doublyLinkedList.insertAtBegining(2);
        doublyLinkedList.insertAtBegining(1);
        doublyLinkedList.display();
        doublyLinkedList.insertAtBegining(0);
        doublyLinkedList.display();
        doublyLinkedList.reverse();


    }
}
