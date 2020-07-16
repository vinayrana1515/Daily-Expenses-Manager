package src.com.ncu.processors;
import  src.com.ncu.processors.*;
import java.util.*;
import java.io.*;
public class Display{
	Scanner sc=new Scanner(System.in);
		
	 void display()
		{ BufferedReader bufferedReader;
			File f=new File("C:\\Users\\Vinay\\Desktop\\UnguidedProject\\TextFile\\daily_expenses.txt"); //passed the path of original file
			try{bufferedReader=new BufferedReader(new FileReader(f)); //to read from the original file
	 	String line=null;
	 	System.out.print("CATEGORY"+" \t"+"EXPENDITURE (in RS)"+"\n");
	      while((line = bufferedReader.readLine()) != null)//reads from the original file
	      { 
	      	if(!line.equals(""))
	      {	String[] s=line.split("\\.");  //splits the string at every period
            System.out.print(s[0]+" \t\t\t"+s[1]+"\n");//prints the data to user
        }
	   	      }
	      bufferedReader.close();
	}catch(Exception e)
	{
	e.printStackTrace();	}
	}



	public void popupMenu()
	{int ch=0;;
		System.out.println("\n\nPlease choose from the following\n");
		do{
	    System.out.println("\t\t--------->1 for Adding Data");
		System.out.println("\t\t--------->2 for Deleting Data");
		System.out.println("\t\t--------->3 for Updating Data");
		System.out.println("\t\t--------->4 for Displaying Data");
		System.out.println("\t\t--------->5 for Calculating Expenses");
		//System.out.println("6 for Exit");
		int a=sc.nextInt();
		switch(a)
		{ case 1: { Scanner sc1=new Scanner(System.in);
			        Crud obj=new Crud();//created object of Crud class
			        System.out.println("\t\t\t**********ADD FUNCTION************\n");
                    System.out.println("PLease enter the CATEGORY");
                    String cat=sc1.nextLine(); //input from user
                    System.out.println("Please enter the EXPENDITURE");
                    String exp=sc1.nextLine();  //input from user
			      try{ obj.add(cat,exp); //called add method of Crud class and passed the arguements
			      System.out.println("\n\t\t***************DATA ADDED!!!*************");
			  }
			      catch(Exception e){
			      	e.printStackTrace();
			      }
			       
			       break;}
	     case 2: {Crud obj=new Crud(); //created object of Crud class
	     	            Scanner sc2=new Scanner(System.in);
	     	        System.out.println("\t\t\t***************DELETE FUNCTION***************\n");
	     	        System.out.println("Please enter the CATEGORY");
	     	        String cat=sc2.nextLine(); //input from user
	     	        int i=0;
	               try{ i=obj.delete(cat); //called delete method of Crud class and passed the arguement
	               if(i==1)
	                   System.out.println("\n\t\t****************DELETED!!!*************");
	               else
	               	 System.out.println("\n\t\t***************ERROR DATA NOT FOUND************");
	               }
	               catch(Exception e)
	               {
	               	e.printStackTrace();
	               }
	                 
	                break;}
	     case 3: {
	     	   Crud obj=new Crud(); //created object of Crud class
	     	   Scanner sc3=new Scanner(System.in);
	     	   System.out.println("\t\t\t***************UPDATE FUNCTION*******************");
	     	   System.out.println("Please enter the CATEGORY");
	     	   String cat=sc3.nextLine(); //input from the user
	     	   System.out.println("Please enter the EXPENDITURE");
	     	   String exp=sc3.nextLine(); //input from the user
	     	   try{int i=obj.update(cat,exp); //called update method of Crud class and passed the arguement
	     	    if(i==1)
	     	   System.out.println("\n\t\t*******************DATA UPDATED!!!*****************");
	     	   else
	     	   	System.out.println("\n\t\t************ERROR DATA NOT FOUND*************");
	     	  }
	     	   catch(Exception e)
	     	   {
	     	   	e.printStackTrace();
	     	   }
	     	  
	     	     break;
	     	     }
	     case 4:{
	     	try{display(); //display method
	     	}
	     	catch(Exception e)
	     	{
	     		e.printStackTrace();
	     	}
	          break;
	            }
	     case 5: {
	     	Crud obj=new Crud(); //created object of Crud class
	     	float ca;
	     	try{ca=obj.calculatetotalexpense();  //called calculatetotalexpense method 
	     		System.out.println("\n\t\t*************YOUR DAILY EXPENSE IS**************");
	     	System.out.println("\t\t----------------Rs "+ca+"-------------");
	     }
	     	catch(Exception e)
	     	{
	     		e.printStackTrace();
	     	}
	     
	        break;
	     }
         default :{
         	System.out.println("ERROR INVALID INPUT!!!!");
         	break;
         }

		}
		System.out.println("\nDO YOU WISH TO CONTINUE : (1/0)");
		ch=sc.nextInt();
	}while(ch!=0);
	}


}
//class DisplayRun
//{public static void main(String[] args) {
	

//	Display obj=new Display();
//	obj.display();
//}}