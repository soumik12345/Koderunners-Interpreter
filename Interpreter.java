import java.io.*;
import java.util.*;
class Interpreter
{
    LinkedStack memory=new LinkedStack();
    FileHandler2 F=new FileHandler2();
    ArrayList<String> lines;
    ArrayList<Integer> opCode=new ArrayList<Integer>(0);
    int n=0;

    public boolean isInteger(String s)
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

    public void getLines()throws Exception
    {
        lines=F.getEachLine();
    }

    public int OpCodeInLine(String s)
    {
        Scanner sc=new Scanner(new String(s));
        int c=0;
        while(sc.hasNext())
        {
            String t=sc.useDelimiter(" ").next();
            if(t.equalsIgnoreCase("Koderunners"))
                c++;
        }
        return c;
    }
}
