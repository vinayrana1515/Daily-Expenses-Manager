package src.com.ncu.main;
import java.util.*;
import src.com.ncu.exception.*;
import src.com.ncu.processors.*;
import src.com.ncu.validators.*;
public class Main{
public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);//object of scanner to take input from user 
		System.out.println("\n\t\t\t                     *************WELCOME*************");
		System.out.println("\n\tPLEASE LOGIN TO CONTINUE : ");
		LoginValid lo;
		int i;
		try{lo=new LoginValid(); //login class object defined
		i=lo.login();// login method in Login Class called
		if(i==1)
		{ 
                Display dis=new Display();//Display class object declared and defined
                dis.popupMenu(); // popumenu method of class Display called
                System.out.println("\n\t\t*************THANK YOU***********");
		}
		else{
			System.out.println("\n\t\tREMEBER YOUR LOGIN CEREDENTIALS AND COME AGAIN LATER ");
		}}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
		
	}	
}