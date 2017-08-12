import java.util.*;
import java.io.*;

class Main
{
    static FileHandler f=new FileHandler();
    static Scanner sc=new Scanner(System.in);
    static String fileName="",s="";
    static int c;
    public static void main(String args[])throws Exception
    {
        System.out.println("Enter the number corresponding to the menu:");
        System.out.println("1. To create a new file.");
        System.out.println("2. To show the contents of the file.");
        System.out.println("3. To Interpret a file and give the output.");
        int inp=sc.nextInt();
        switch(inp)
        {
            case 1:
            System.out.print("Enter the filename: ");
            fileName=sc.next();
            f.createFile(fileName);
            break;

            case 2:
            System.out.print("Enter the name of the file: ");
            fileName=sc.next();
            FileInputStream in=new FileInputStream(fileName+".kdr");
            while((c=in.read())!=-1)
            {
                s+=((char)c);
            }
            System.out.println(s);
            break;
            
            case 3:
//            System.out.print("Enter the name of the file: ");
//            fileName=sc.next();
//            FileInputStream in1=new FileInputStream(fileName+".kdr");
//            while((c=in1.read())!=-1)
//            {
//                s+=((char)c);
//            }
            	Interpreter I=new Interpreter();
            	I.getLines();
            	I.getOpCode();
            	I.Interpret();
            break;
        }
    }
}