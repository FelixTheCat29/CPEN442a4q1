
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;
class Crack {
   static String myhash = "579C97A62D51DACE97EAE558480D46EDAFCF9418".toLowerCase();
	static int N = 10;
 //  static String myhash = "B39D007EBF744741700C07118F9385C1F42D6364".toLowerCase();
 //  static String allchars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+-=";
   public static void main(String[] a) {
      try {
         MessageDigest md = MessageDigest.getInstance("SHA1");
     	
     	File file = new File("./out2.txt");
     	if(!file.exists()) {
     	    file.createNewFile();
     	}
         PrintWriter writer = new PrintWriter("./out2.txt", "UTF-8");
         
         int i, j, k, m, n, p;
         for (i = 0; i <N ; i++){
        	 for (j = 0; j< N; j++){
        		 for (k= 0; k < N; k++) {
        			 for (m=0; m< N; m++){
        				 for (n = 0; n < N; n++) {
        					 for (p = 0; p < N; p++) {
		        				 String input = "Na" + Integer.toString(i) + Integer.toString(j)+Integer.toString(k)+ Integer.toString(m);
        						 //String input = "Yf" + "hrGhMA";//new StringBuilder().append(allchars.charAt(i)).append(allchars.charAt(j)).append(allchars.charAt(k)).append(allchars.charAt(m)).append(allchars.charAt(n)).append(allchars.charAt(p)).toString();
		        				 
		        				 System.out.println("Input: "+ input);
		        				 writer.println("Input: " + input);
		        				 
		        		         md.update(input.getBytes()); 
		        		      	 byte[] output = md.digest();        		      	
		        		         String hexStr = Hex.encodeHexString( output );
		        		      	 System.out.println(hexStr);
		        		      	 writer.println(hexStr);
		        		      	 md.reset();
		        		      	
		        		      	 if (hexStr.equals(myhash)) {
		        		      		 System.out.println("Found");
		        		      		 writer.println("Found");
		        		      		 return;
		        		      	 }
        					 }
        				 }
        		         
        			 }
        		 }
        	 }
         }
         writer.close();
      } catch (Exception e) {
         System.out.println("Exception: "+e);
      }
   }
}