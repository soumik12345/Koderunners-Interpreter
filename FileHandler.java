import java.io.*;
class FileHandler
{
    public static void createFile(String fName)
    {
        FileInputStream in = null;
        FileOutputStream out = null;
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fName+".kdr"), "utf-8")))
        {
            writer.write("Delete this text and enter your code");
        }
        catch(IOException e)
        {
            System.out.println("WTF!!! Failed to create the file!");
        }
    }
}