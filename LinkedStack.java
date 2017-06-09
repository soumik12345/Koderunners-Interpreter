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
}
