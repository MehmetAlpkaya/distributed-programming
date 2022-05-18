
package odev_dagıtık;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;


public class MD5Hash {
public static String getMd5(long sayi) throws Exception{
 String yourString = Long.toString(sayi);
 byte[] bytesOfMessage = yourString.getBytes("UTF-8");
 MessageDigest md = MessageDigest.getInstance("MD5");
 byte[] thedigest = md.digest(bytesOfMessage);
 BigInteger bigInt = new BigInteger(1,thedigest);
 String hashText = bigInt.toString(16);
 while(hashText.length() < 32 ){
 hashText = "0"+hashText;
 }
 return hashText;
}

    public static void main(String args[]) throws UnsupportedEncodingException, Exception {
        System.out.println(getMd5(9));
    }
}
