import java.io.*;
import java.util.*;
class Interpreter
{
    Statck memory=new Stack();
    ArrayList<String> a=new ArrayList<String>(0);
    ArrayList<Integer> opCode=new ArrayList<Integer>(0);
    int n=0;

    public static boolean isInteger(String s)
    {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

    void breakCode(String code)
    {
        String s="";
        for(int i=0;i<code.length();i++)
        {
            char ch=code.charAt(i);
            if(ch!='\n')
                s+=ch;
            else
            {
                a.add(s);
                s="";
            }
            if(i==code.length()-1)
            {
                a.add(s);
                s="";
            }
        }
    }

    void printArrayList()
    {
        for(int i=0;i<a.size();i++)
            System.out.println(a.get(i));
        System.out.println();
        for(int i=0;i<opCode.size();i++)
            System.out.println(opCode.get(i));
    }

    void ineterpret(int opCode)
    {
        switch(opCode)
        {
            case 0:
            System.exit(0);
            break;

            case 1:
            memory.push("Koderunners");
            break;

            case 2:
            n=memory.size();
            if(isInteger(memory.get(n-1)) && isInteger(memory.get(n-2)))
                memory.push(Integer.toString(Integer.parseInt(memory.get(n-1))+Integer.parseInt(memory.get(n-2))));
            else
                memory.push(memory.get(n-1)+memory.get(n-1));
            break;

            case 3:
            n=memory.size();
            if(isInteger(memory.get(n-1)) && isInteger(memory.get(n-2)))
                memory.push(Integer.toString(Integer.parseInt(memory.get(n-1))-Integer.parseInt(memory.get(n-2))));
            else
                System.out.print("Subraction not possible.");
            break;

            case 4:
            n=memory.size();
            if(isInteger(memory.get(n-1)) && isInteger(memory.get(n-2)))
                memory.push(Integer.toString(Integer.parseInt(memory.get(n-1))*Integer.parseInt(memory.get(n-2))));
            else
                System.out.print("Multiplication not possible.");
            break;

            case 5:
            if(memory.get(n-1).equals(memory.get(n-2)))
                memory.push("true");
            else
                memory.push("false");
            break;

        }
    }
}
