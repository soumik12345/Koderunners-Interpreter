import java.io.*;
import java.util.*;
class Interpreter
{
    ArrayList<String> a=new ArrayList<String>(0);
    ArrayList<Integer> opCode=new ArrayList<Integer>(0);
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

    void createOperation(String code)
    {
        for(int i=0;i<a.size();i++)
        {
            String t=a.get(i),s="";
            for(int j=0;j<t.length();j++)
            {
                char ch=code.charAt(j);
                if(ch!='\n')
                    s+=ch;
                else
                {
                    if(s.equalsIgnoreCase("koderunners"))
                        opCode.add(t.length());
                    s="";
                }
                if(j==code.length()-1)
                {
                    if(s.equalsIgnoreCase("koderunners"))
                        opCode.add(t.length());
                    s="";
                }
            }
        }
    }
}