package src.com.ncu.processors;
import src.com.ncu.exception.*;
import java.io.*;
import java.util.*;
public class Crud{
 	FileReader input=null; //FileReader class object declared
	FileWriter writer=null;	//FileWriter class object declared
 		float expense;String line;
 	
		

		public void add(String category,String amt)
		{   try   {              
		         FileWriter fr=new FileWriter("C:\\Users\\Vinay\\Desktop\\UnguidedProject\\TextFile\\daily_expenses.txt",true); //oppend file in filewriter and append mode to write data 
		            BufferedWriter br = new BufferedWriter(fr);//bufferedwriter to write a string in the file
		            br.newLine(); //shifts the pointer to next line in file
                    br.write(category+"."+amt); //writing in the file through write mehtod
                   br.close();
                   fr.close();
                
                 }
                 catch(Exception e)
                {e.printStackTrace();}
                  
	         	}
 
 public int delete(String lineToRemove) {
File inFile=null; //declared file object
File file=null; //declared file object 
FileInputStream fis=null; //declared file object
boolean a;
int flag=0;
Properties prop=new Properties(); //created object of propertyy file

            try { 

                         fis=new FileInputStream("C:\\Users\\Vinay\\Desktop\\UnguidedProject\\configs\\constants\\exceptions.properties"); //for reading from property file
                   inFile = new File("C:\\Users\\Vinay\\Desktop\\UnguidedProject\\TextFile\\daily_expenses.txt"); //passed original file path  
                   file=new File("C:\\Users\\Vinay\\Desktop\\UnguidedProject\\TextFile\\temp.txt"); //constructed new temporary file
                   prop.load(fis);
                      BufferedReader br = new BufferedReader(new FileReader(inFile));//for reading from the original file
                      PrintWriter pw = new PrintWriter(new FileWriter(file));//for writing in the temporary file
                      String line = null;
                      if(inFile.length()==0) //checks for empty file exception
                      {
                        throw new EmptyFileException("EMPTY FILE");
                      }
                        
                     while ((line = br.readLine()) != null) //reads the data from original file
                     {
                      String[] s=line.split("\\."); // splits the string at every period occurr
                     if (!s[0].equals(lineToRemove)) //checking whether the data matches in file or not
                     {
                     pw.println(line);//writing in the temp file unless the data matches 
                         pw.flush();//flushes any stream of data present
                      }
                      

                    if(s[0].equals(lineToRemove))
                      //not writing in the temp file when data matches
                       {                  
                        flag=1;
                       }
                      }
                       pw.close();
                  br.close();
                            //Delete the original file
                         inFile.delete();
                        
                         //Rename the new file to the filename the original file had.
                           file.renameTo(inFile);
                           return flag;
                       }
                     
                          catch (EmptyFileException efe)
                          {String z=prop.getProperty("EmptyFile");
                          System.out.println(z);

                          }
                       catch (IOException ex) {
                    ex.printStackTrace();
                         }
                         return flag;
                    }

public int update(String cat,String value)

		{File inFile=null; //declared file object 
File file=null;//declared file object 
FileInputStream fi=null; //declared file object
boolean a;
int flag=0;
Properties prop=new Properties(); //created object of propertyy file

            try {  

                  fi=new FileInputStream("C:\\Users\\Vinay\\Desktop\\UnguidedProject\\configs\\constants\\exceptions.properties"); //for reading from property file

                   inFile = new File("C:\\Users\\Vinay\\Desktop\\UnguidedProject\\TextFile\\daily_expenses.txt"); //passed original file path 
                   file=new File("C:\\Users\\Vinay\\Desktop\\UnguidedProject\\TextFile\\temp.txt"); //constructed new temporary file 
                      prop.load(fi);
                     BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Vinay\\Desktop\\UnguidedProject\\TextFile\\daily_expenses.txt")); //for reading from the original file
                      PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Vinay\\Desktop\\UnguidedProject\\TextFile\\temp.txt")); //for writing in the temporary file
                       String line = null;
                     if(inFile.length()==0) //checks for empty file exception
                      {
                        throw new EmptyFileException("EMPTY FILE");
                      }

                         
                       
                     while ((line = br.readLine()) != null) {
                     	 String[] line1=line.split("\\."); // splits the string at every period occurr

                     if (line1[0].equals(cat)) {                         //Read from the original file and write to the new temp file
                     pw.println(cat+"."+value);                             //unless content matches data to be updated               
                         pw.flush();                                         
                         flag=1;
                      }
                      else
                      pw.println(line);
                    pw.flush();                
                       
                      }
                    pw.close();
                  br.close();
                            //Delete the original file
                          inFile.delete();
                         file.renameTo(inFile);
                return flag;
                }
                          catch (EmptyFileException efe) {
                             String z=prop.getProperty("EmptyFile");
                             System.out.println(z);
                                  }
                       catch (IOException ex) {
                    ex.printStackTrace();
                         }
                         return flag;
                    }
 

  public float calculatetotalexpense()
		{int sum=0;
		try{	input= new FileReader("C:\\Users\\Vinay\\Desktop\\UnguidedProject\\TextFile\\daily_expenses.txt");//for reading from the original file
			BufferedReader bufferedReader = new BufferedReader(input);//for reading from the original file
			        while((line = bufferedReader.readLine()) != null) //reads the data from the file
        {
         if(!line.equals(""))
          {  String[] s=line.split("\\.");  //splits the string at period occur
             sum=sum+Integer.parseInt(s[1]); //converted string into int and adding up all
           }
        }

        bufferedReader.close();
			float expense=sum;
			return expense;
		}
		catch(Exception e)
		{ e.printStackTrace();}

		return 0;

		}
	}




//class CrudRun{
	//public static void main(String[] args) {
		//Crud obj=new Crud();
	//System.out.println(obj.calculatetotalexpense());
	//	System.out.println(obj.calculatetotalexpense());
		//obj.update("BUTTER","25");
	//		String cat="hello";
//obj.update("BUUTER","27");
	
//}
//}