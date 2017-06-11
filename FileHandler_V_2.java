import java.util.*;
import java.io.*;
class FileHandler_V_2
{
    public ArrayList<String> createFile()throws Exception
    {
        Scanner ob=new Scanner(new File("bichi.kdr"));
        ArrayList<String> a=new ArrayList<String>();
        while(ob.hasNext())
        {
            String text=ob.useDelimiter(" ").next();
            //System.out.print(text);
            a.add(text);
        }
        for(int i=0;i<a.size();i++)
            System.out.print(a.get(i)+" ");
            return a;
    }
}