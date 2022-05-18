
package odev_dagıtık;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;
import static odev_dagıtık.client.bul;


public class client1 {

  
    public static void main(String args[]) {
          try{
        Socket Soket= new Socket("192.168.10.10",2020);
      BufferedReader in= new BufferedReader(new InputStreamReader(Soket.getInputStream()));
      String input=in.readLine();
            System.out.println(input);
      String sifre=bul(input);
      if(sifre !="")
      {
       PrintWriter output=new PrintWriter(Soket.getOutputStream(),true);
       output.println(sifre);
      }
      else
      {
        PrintWriter output=new PrintWriter(Soket.getOutputStream(),true);
        output.println("-1");
          
      }}
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
          
    }
    public static String bul(String input) throws Exception
    {
        String []parcalar=input.split("-");
        int threadNumber=Integer.parseInt(parcalar[3])-1;
        int sumThread=Integer.parseInt(parcalar[4]);
        int baslangic=(Integer.parseInt(parcalar[1])/sumThread)*(threadNumber-1);
        int bitis =(Integer.parseInt(parcalar[1])/sumThread)*threadNumber;
        System.out.println(threadNumber+" "+baslangic+" "+bitis);
        for(int i=0;i<parcalar.length;i++)
        {
            System.out.println(parcalar[i]);
        }
        MessageDigest md = MessageDigest.getInstance("MD5");
        for(int i=baslangic;i<bitis;i++)
        {
           byte[]bytesOfMessage =Integer.toString(i).getBytes("UTF-8");
           byte[]theDigest=md.digest(bytesOfMessage);
           BigInteger bigInt=new BigInteger(1, theDigest);
           String hashText=bigInt.toString(16);
           while(hashText.length()<32)
           {
                hashText="hashText"+hashText;
           }
           if(parcalar[2].equals(hashText))
           {
               return Integer.toString(i);
           }
        }
               return "";

 
    }

}
