import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        double liczba = 6.6;
        String inna = "Inny tekst";
        String zmienna = "Wartosc tekstowa";
        String tekst = "wartosc" + " " + inna + zmienna + 6.6;
        System.out.println(tekst);
        double srednia = 33.67;
        int wynik = (int) srednia;
        if (wynik == 33) {
            System.out.println("weszlismy do warunku.");
        } else {
            System.out.println("nie weszlismy do warunku.");
        }

        int n, c;
        System.out.print("Ile iteracji: ");
        n = s.nextInt(); 
        c = 1;
        for (int i=1; i<=n; i++) {
            System.out.println(c);
            c = c*10+1;
        }

        s.close(); 
    }
}