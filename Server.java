
package odev_dagıtık;
import java.net.*;
import java.io.*;

public class Server extends Thread {
static int sayac=1;
static ServerSocket soket;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        try
        {
        ServerSocket soket=new ServerSocket(2020);
            System.out.println("Bağlantı Bekleniyor...");
            Socket baglanti=soket.accept();
            System.out.println("işlemci bağlandı");
            PrintWriter output=new PrintWriter (baglanti.getOutputStream(),true);
            String veri="dasdasfsadasas";
            output.println(veri);
            System.out.println("Mesaj iletildi. Sonuç beklenmekte...");
            BufferedReader in= new BufferedReader(new InputStreamReader(baglanti.getInputStream()));
            String input=in.readLine();
            if(Integer.parseInt(input )==-1)
            {
                System.out.println("Şifre bulunamadı");
            }
            else
                System.out.println("Şifre :"+input);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        soket=new ServerSocket(2020);
        Thread th1=new Server();
        Thread th2=new Server();
        th1.setName("th1");
        th2.setName("th2");
        th1.start();
        sayac++;
        th2.start();
    }int ThreadSayisi=2;
    @Override
    public void run()
    {
        try{
        System.out.println("aranıyor...."+super.getName()+"Thread sayısı:"+super.getName());
        Socket baglanti=soket.accept();
        System.out.println("Bağlandı."+super.getName());
        PrintWriter output = new PrintWriter(baglanti.getOutputStream(),true);
        MD5Hash md=new MD5Hash();
        String sifrelemis =md.getMd5(0);
        String veri="0-10000000" +sifrelemis+"-"+ (sayac++)+"-"+ThreadSayisi;
        output.println(veri);
        System.out.println("Mesaj iletildi. sonuç bekleniyor");
        BufferedReader in=new BufferedReader (new InputStreamReader(baglanti.getInputStream()));
        String input=in.readLine();
        if(Integer.parseInt(input)==-1)
        {
            System.out.println("Şifre bulunamadı."+super.getName());
        }
        else
            System.out.println("şifre :"+input+" Thread Name :"+super.getName());
   }
        catch(Exception e)
        {
            System.out.println(e);
        }
}
}
       
