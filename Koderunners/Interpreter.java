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
    	int c=0;
    	if(s.charAt(0)=='x' || s.charAt(0)=='X')
    		c=100;
    	String t[]=s.split(" ");
        for(int i=0;i<t.length;i++) {
        	if(t[i].equalsIgnoreCase("Koderunners"))
        		c++;
        	else if(t[i].equalsIgnoreCase("X"))
        		c++;
        }
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
        //for(int i: opCode)
    	for(int j=0;j<opCode.size();j++)
        {
            	int i=opCode.get(j);
                if(i == 1)
                	System.exit(0);

                else if(i == 2)
                {
                	if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                		memory.push(Integer.toString(Integer.parseInt(memory.first.item)+Integer.parseInt(memory.first.next.item)));
                	else
                		memory.push(memory.first.item+memory.first.next.item);
                }

                else if(i == 3)
                {
                	if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                		memory.push(Integer.toString(Integer.parseInt(memory.first.item)-Integer.parseInt(memory.first.next.item)));
                	else
                		System.out.print("Subtraction Not Possible!");
                }

                else if(i == 4)
                {
                	if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                		memory.push(Integer.toString(Integer.parseInt(memory.first.item)*Integer.parseInt(memory.first.next.item)));
                	else
                		System.out.print("Multiplication Not Possible!");
                }

                else if(i == 5)
                {
                	if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                		memory.push(Integer.toString(Integer.parseInt(memory.first.item)/Integer.parseInt(memory.first.next.item)));
                	else
                		System.out.print("Division Not Possible!");
                }

                else if(i == 6)
                {
                	if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                        memory.push(Integer.toString(Integer.parseInt(memory.first.item)%Integer.parseInt(memory.first.next.item)));
                    else
                        System.out.print("Modulus Not Possible!");
                }
                
                else if(i == 7)
                {
                	BufferedReader ob1=new BufferedReader(new InputStreamReader(System.in));
                	String inp=ob1.readLine();
                	memory.push(inp);
                }
                
                else if(i == 8)
                	System.out.print(memory.first.item);
                
                else if(i == 9)
                {
                	if(memory.first.item.equals(memory.first.next.item))
                		memory.push("1");
                	else
                		memory.push("0");
                }
                
                else if(i == 10)
                {
                	if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                	{
                		if(Integer.parseInt(memory.first.item) < Integer.parseInt(memory.first.next.item))
                			memory.push("1");
                	}
                	else
                		memory.push("0");
                }
                
                else if(i == 11)
                {
                	if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                	{
                		if(Integer.parseInt(memory.first.item) > Integer.parseInt(memory.first.next.item))
                			memory.push("1");
                	}
                	else
                		memory.push("0");
                }
                
                else if(i == 12)
                {
                	if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                		memory.push(Integer.toString(Integer.parseInt(memory.first.item) & Integer.parseInt(memory.first.next.item)));
                	else
                		System.out.print("Comparison Not Possible!");
                }
                
                else if(i == 13)
                {
                	if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                		memory.push(Integer.toString(Integer.parseInt(memory.first.item) | Integer.parseInt(memory.first.next.item)));
                	else
                		System.out.print("Comparison Not Possible!");
                }
                
                else if(i == 14)
                {
                	if(isInteger(memory.first.item))
                	{
                		if(Integer.parseInt(memory.first.item)==1)
                			memory.push("0");
                		else
                			memory.push("1");
                			
                	}
                	else
                		System.out.print("Operation Not Possible!");
                }
                
                else if(i == 15)
                {
                	if(isInteger(memory.first.item) && isInteger(memory.first.next.item))
                		memory.push(Integer.toString(Integer.parseInt(memory.first.item) ^ Integer.parseInt(memory.first.next.item)));
                	else
                		System.out.print("Comparison Not Possible!");
                }
                
                else if(i == 16)
                {
                	j++;
                	i=opCode.get(j);
                	while(i!=16) {
                		if(i>=101 && i<=110)
                			System.out.print(i-101+'0');
                		else if(i<=136)
                			System.out.print(i-111+'A');
                		else if(i<141) {
                			switch(i) {
                			case 137:
                				System.out.print(" ");
                				break;
                			case 138:
                				System.out.print("\n");
                				break;
                			case 139:
                				System.out.print(",");
                				break;
                			case 140:
                				System.out.print(".");
                				break;
                			}
                		}
                		else if(i<=166)
                			System.out.print(i-141+'a');
                	}
                }
        }
    }
}
