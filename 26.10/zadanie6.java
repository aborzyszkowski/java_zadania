import java.util.Scanner;

public class zadanie6 {
    private static void wyliczSredniaProceduralnie(double liczba1, double liczba2) {
        double srednia = (liczba1 + liczba2) / 2;
        System.out.printf("Średnia to: %1$s \r\n", srednia);
    }

    private static double wyliczSredniaFunkcyjnie(double liczba1, double liczba2) {
            double srednia = (liczba1 + liczba2) / 2;
            return srednia;
    }     
    public static void main(String args[]) {
        int x, y;
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Podaj liczbę 1:");
        x = s.nextInt(); 

        System.out.print("Podaj liczbe 2:");
        y = s.nextInt();

        wyliczSredniaProceduralnie(x, y);

        double wynik = wyliczSredniaFunkcyjnie(x, y);
        System.out.printf("Średnia to: %1$s \r\n", wynik);
    }
}
