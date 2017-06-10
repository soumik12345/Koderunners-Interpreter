import java.util.*;
class LinkedStack
{
    private class Node
    {
        String item;
        Node next;
    }
    private Node first=null;
    public boolean isEmpty()
    {
        return first==null;
    }

    public void push(String item)
    {
        Node oldFirst=first;
        first=new Node();
        first.item=item;
        first.next=oldFirst;
    }

    public String pop()
    {
        String item=first.item;
        first=first.next;
        return item;
    }

    public void Print(Node head)
    {
        if(head!=null)
        {
            System.out.print(head.item+"->");
            Print(head.next);
        }
    }

    public int Length(Node head)
    {
        Node temp=head;
        int c=0;
        while(temp!=null)
        {
            c++;
            temp=temp.next;
        }
        return c;
    }

    public String Get(Node head, int idx)
    {
        Node current=head;
        int c=0;
        while(current!=null)
        {
            if(c==idx)
                return current.item;
            c++;
            current=current.next;
        }
        return "";
    }
}
