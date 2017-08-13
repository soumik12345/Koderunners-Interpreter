import java.io.*;

import java.util.*;
class Interpreter
{
    Scanner ob1=new Scanner(System.in);
    LinkedStack memory=new LinkedStack();
    FileHandler2 F=new FileHandler2();;
    ArrayList<String> lines;
    ArrayList<Integer> opCode;
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
//        for(String i: lines)
//        	System.out.println(i);
    }

    public int OpCodeInLine(String s)throws NullPointerException
    {
    	String t[]=s.split(" ");
    	int c=0;
        for(int i=0;i<t.length;i++)
        	if(t[i].equalsIgnoreCase("Koderunners"))
        		c++;
        return c;
    }

    public void getOpCode()
    {
        opCode=new ArrayList<Integer>(0);
        for(int i=0;i<lines.size();i++)
            opCode.add(OpCodeInLine(lines.get(i))+1);
//        for(int k: opCode)
//            System.out.println(k);
    }

    public void Interpret()throws Exception
    {
        for(int i: opCode)
        {
            
                if(i == 1)
                System.exit(0);
                

                else if(i == 2){
                if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                    memory.push(Integer.toString(Integer.parseInt(memory.first.item)+Integer.parseInt(memory.first.next.item)));
                else
                    memory.push(memory.first.item+memory.first.next.item);
                }

                else if(i == 3){
                if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                    memory.push(Integer.toString(Integer.parseInt(memory.first.item)-Integer.parseInt(memory.first.next.item)));
                else
                    System.out.print("Subtraction Not Possible!");
                }

                else if(i == 4){
                if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                    memory.push(Integer.toString(Integer.parseInt(memory.first.item)*Integer.parseInt(memory.first.next.item)));
                else
                    System.out.print("Multiplication Not Possible!");
                }

                else if(i == 5){
                if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                    memory.push(Integer.toString(Integer.parseInt(memory.first.item)/Integer.parseInt(memory.first.next.item)));
                else
                    System.out.print("Division Not Possible!");
                }

                else if(i == 6){
                	if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                        memory.push(Integer.toString(Integer.parseInt(memory.first.item)%Integer.parseInt(memory.first.next.item)));
                    else
                        System.out.print("Modulus Not Possible!");
                }
                
                else if(i == 7){
                	BufferedReader ob1=new BufferedReader(new InputStreamReader(System.in));
                	String inp=ob1.readLine();
                	memory.push(inp);
                }
                
                else if(i == 8)
                	System.out.print(memory.first.item);
                
                /*else if(i == 9)
                {
                	for(int k = 0; ; k++)
                		
                }*/
                
            
        }
    }
}
