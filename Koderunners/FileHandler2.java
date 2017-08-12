import java.util.*;
import java.io.*;
class FileHandler2
{
    public ArrayList<String> getEachLine()throws Exception
    {
        Scanner ob=new Scanner(new File("C:\\Users\\nEW u\\workspace\\bichi.kdr"));
        ArrayList<String> a=new ArrayList<String>();
        while(ob.hasNext())
        {
            String text=ob.useDelimiter("\n").next();
            a.add(text);
        }
        return a;
    }
}