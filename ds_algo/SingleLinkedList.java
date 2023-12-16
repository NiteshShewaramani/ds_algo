package com.springSecurityClient;

public class SingleLinkedList {
    Node head;
    private static class Node{
        int data;
        Node next;
        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    public void displayList()
    {
        Node current=head;
        while(current!=null)
        {
            System.out.print(current.data+"-->");
            current=current.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public int size()
    {
        Node current=head;
        int count=0;
        while(current!=null)
        {
            ++count;
            current=current.next;
        }
        return count;
    }

    public void addFirst(int data)
    {
        Node temp=new Node(data);
        temp.next=head;
        head=temp;
    }
    public void addLast(int data)
    {
        Node temp=new Node(data);
        Node current=head;
        while(current.next!=null)
        {
            current=current.next;
        }
        //current is last node
        current.next=temp;
    }
    public void addPosition(int pos,int data)
    {
        if(pos == 0){
            addFirst(data);
            return;
        }
        Node temp=new Node(data);
        Node current=head;
        Node prev = head;
        while(current.next!=null && --pos>0)
        {
            prev=current;
            current=current.next;
        }
        prev.next=temp;
        temp.next=current;

    }
    public void removeFirst()
    {
        if(head==null)
            return;
        head=head.next;
    }
    public void delete(int pos)
    {
        if(pos<=0)
            return;
        if(pos==1)
            removeFirst();

        Node current = head;
        Node prev=head;
        while(current.next != null && --pos>0)
        {
            prev=current;
            current=current.next;
        }
        if(current!=null)
        prev.next=current.next;
        else
            prev.next=null;

    }
    //remove last element from linkedlist
    public void removeLast()
    {
        if(head==null)
            return;
        if(head.next==null)
            head=null;

        Node current = head;
        Node prev=current;
        while(current.next !=null)
        {
            prev=current;
            current = current.next;
        }
        //last node is current
        prev.next = null;

    }
    public boolean exists(int data)
    {
        if(head==null)
            return false;
        Node current = head;
        while(current!=null)
        {
            if (current.data==data)
                return true;
            current=current.next;
        }

        return false;

    }
    public void reverse()
    {
        Node current=head;
        Node previous=null;
        while(current!=null)
        {
            Node next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        head=previous;
    }
    public void findMiddle()
    {
        if(head != null)
        {
            Node fast = head;
            Node slow = head;
            while(fast!=null && fast.next!=null)
            {
                slow=slow.next;
                fast=fast.next.next;
            }
            System.out.println("middle is " + slow.data);
        }
    }
    public void removeDupilicateFromSortedLinkedList()
    {
        if(head !=null)
        {
            Node current = head;
            while(current !=null && current.next!=null)
            {
                if(current.data == current.next.data)
                {
                    current=current.next.next;
                }
                else
                    current=current.next;
            }

        }
    }
    public void detectCycle()
    {
        boolean exists=false;
        Node fast=head;
        Node slow=head;
        while(fast.next!=null && fast!=null)
        {
            slow=slow.next;
            fast=fast.next;
            if(fast==slow)
            {
                exists=true;
                break;
            }

        }
    }
    public void findStartOfCycle(Node slow)
    {
        Node temp = head;

        while(temp!=null)
        {
            temp=temp.next;
            slow=slow.next;
            if(temp==slow)
            {
                //found it

            }
        }
    }

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode sorted = new ListNode(0,null);
//        ListNode head = sorted;
//        while(l1!=null || l2!=null)
//        {
//            if(l1==null && l2==null)
//                break;
//            if(l1==null)
//            {
//                head.next=l2;
//                l2=l2.next;
//                head=head.next;
//            }
//            else if(l2==null)
//            {
//                head.next=l1;
//                l1=l1.next;
//                head=head.next;
//            }
//            else if(l1.val>l2.val)
//            {
//                head.next=l2;
//                l2=l2.next;
//                head=head.next;
//
//            }
//            else
//            {
//                head.next=l1;
//                l1=l1.next;
//                head=head.next;
//            }
//
//        }
//        return sorted.next;
//    }



    public static void main(String[] args) {
        SingleLinkedList singleList = new SingleLinkedList();
        singleList.head = new Node(1);
        Node first = new Node(2);
        Node second = new Node(3);
        Node third = new Node(4);
        singleList.head.next=first;
        first.next=second;
        second.next=third;
        singleList.displayList();
        singleList.addFirst(0);
        singleList.displayList();
        singleList.removeLast();
        singleList.displayList();
        singleList.addLast(4);
        singleList.displayList();
        singleList.addPosition(0,-11);
        singleList.displayList();
        singleList.removeFirst();
        singleList.displayList();
        singleList.delete(2);
        singleList.displayList();
        singleList.addPosition(2,2);
        singleList.displayList();
        System.out.println(singleList.exists(5));
        System.out.println(singleList.exists(4));
        singleList.reverse();
        singleList.displayList();
        singleList.findMiddle();
        singleList.addFirst(5);
        singleList.displayList();
        singleList.findMiddle();
    }
}
