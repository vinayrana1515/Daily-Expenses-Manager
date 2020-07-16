package src.com.ncu.processors;
import java.io.*;
public class PasswordField {

   public static String readPassword (String prompt) {
      EraserThread et = new EraserThread(prompt);
      Thread mask = new Thread(et);
      mask.start(); //start the exwcution of the thread
     
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //inputs password from user using BufferedReader class
      String password = "";

      try {
          password = in.readLine();
      } catch (IOException ioe) {
          ioe.printStackTrace();
      }
      et.stopMasking(); 
      return password;
   }

}  

  class EraserThread implements Runnable {
   private boolean stop;

   public EraserThread(String prompt) {
       System.out.print(prompt);
   }

  // Begin masking...display asterisks (*)
    

   public void run () {
      while (!stop){
         System.out.print("\010*");
         try {
            Thread.currentThread().sleep(1);
         } catch(InterruptedException ie) {
            ie.printStackTrace();
         }
      }
   }
//Instruct the thread to stop masking
   public void stopMasking() {
      this.stop = true;
   }
}

