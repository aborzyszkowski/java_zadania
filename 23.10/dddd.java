import java.util.Scanner;

public class dddd {
    public static void main(String args[]) {
        int liczba = 1;
        float fLiczba = 7.1f;
        double dLiczba = 5.2;

        boolean bZmienna = true;

        String tekst = "Jakiś tekst";
        String tekstO = new String("Inny tekst");

        System.out.println("Tu mamy " + tekst + ", a tu jest " + tekstO );
        System.out.println(bZmienna);

        if(args.length == 2) {
        System.out.println(args[0]);
        System.out.println(args[1]);
        }
    }
}