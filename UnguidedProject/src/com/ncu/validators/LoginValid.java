package src.com.ncu.validators;
import src.com.ncu.processors.*;
import src.com.ncu.exception.*;
import java.io.*;
import java.util.*;
public class LoginValid{
	public int login() throws NullUsernameException,NullPasswordException
	{ int flag=0;
		Properties prop=new Properties();
	Scanner sc=new Scanner(System.in);
	Properties prop2=new Properties(); // creating properties class object
	Properties prop3=new Properties();// creating properties class object
	FileInputStream input=null;  // declaring input stream
		FileInputStream input2=null; // declaring input stream
		FileInputStream input3=null; // declaring input stream
	try{
		input=new FileInputStream("C:\\Users\\Vinay\\Desktop\\UnguidedProject\\configs\\constants\\login.properties");  //opened filed in input format to read username and password from login properties file
		//input2=new FileInputStream("C:\\Users\\Vinay\\Desktop\\Java\\src\\password.properties");
		input3=new FileInputStream("C:\\Users\\Vinay\\Desktop\\UnguidedProject\\configs\\constants\\exceptions.properties"); //opened filed in input format to read username and password from exceptions properties file
		//prop2.load(input2);
		prop.load(input); //load method of properties class called
		prop3.load(input3);//load method of properties class called

int i=0;
String username;
String pass;
String u;

String p;
 u=prop.getProperty("username"); //called getProperty method of propeerties class to read specific key
p=prop.getProperty("password"); //called getProperty method of propeerties class to read specific key

		
		while(i<3)
		{
          System.out.println("ENTER USERANME");
          username=sc.nextLine();
           if(username.equals(null))
          {
         	throw new NullUsernameException("No USERNAME"); //user defined exception thrown
         }
        
         pass=PasswordField.readPassword("ENTER YOUR PASSWORD:"); //readPassword Method of PasswordField class called to read password and mask it
      if(pass.equals(null))
      {
      	throw new NullPasswordException("No Password"); //user defined exception thrown
      }
		if((u.equals(username))&&(p.equals(pass))) //checking conditon for correct credentials
		{
			//System.out.println("Username is :"+u);
			//System.out.println("Password is :"+p);
			System.out.println("\t\t\t\t*******************LOGIN SUCCESSFULL*********************");
			System.out.println("\n\n");
            flag=1;
			break;
		}

		else{
			System.out.println("\nERROR WRONG CREDENTIALS !!! TRY AGAIN !!!\n");
          }

		i++;
	}
	if(i==3)
	{
System.out.println("\n\t\t\t**************LIMIT EXHAUSTED**************");
	}
	return flag;
	}
	catch(NullUsernameException nue)
	{String s=prop3.getProperty("NullUsername"); //called getProperty method of propeerties class to read specific key
	System.out.println(s);
          	
	}
	catch(NullPasswordException npe)
	{
		String s=prop3.getProperty("NullPassword"); //called getProperty method of propeerties class to read specific key
		System.out.println(s);
	}
	catch(Exception e)
	{e.printStackTrace();

	}
	return flag;	
}
}

//class UnguidedLogin{
	
//	public static void main(String[] args) {
//		Login obj=new Login();
//		int i =obj.login();

//	}
//}