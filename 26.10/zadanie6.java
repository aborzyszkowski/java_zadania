import java.util.Scanner;

public class zadanie6 {
    public static void main(String args[]) {
        System.out.println("Podaj liczbę 1:");
        int liczba1 = Integer.parseInt(new Scanner(System.in).nextLine());

        System.out.println("Podaj liczbe 2:");
        int liczba2 = Integer.parseInt(new Scanner(System.in).nextLine());

        private static void wyliczSredniaProceduralnie(double liczba1, double liczba2)
        {
            double srednia = (liczba1 + liczba2) / 2;
            System.out.printf("Średnia to: %1$s \r\n", srednia);
        }

        private static double wyliczSredniaFunkcyjnie(double liczba1, double liczba2)
        {
            double srednia = (liczba1 + liczba2) / 2;

            return srednia;
        }        

        wyliczSredniaProceduralnie(liczba1, liczba2);

        double wynik = wyliczSredniaFunkcyjnie(liczba1, liczba2);
        System.out.printf("Średnia to: %1$s \r\n", wynik);        
    }
}
