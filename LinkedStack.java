import java.util.*;
class LinkedStack
{
    public class Node
    {
        String item;
        Node next;
    }
    public Node first=null;
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
            System.out.println(head.item);
            Print(head.next);
        }
    }

    public int Length()
    {
        Node temp=first;
        int c=0;
        while(temp!=null)
        {
            c++;
            temp=temp.next;
        }
        return c;
    }

    public String Get(int idx)
    {
        Node current=first;
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
