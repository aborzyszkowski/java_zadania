import java.util.Scanner;

public class zadanie4 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int wiersze, kolumny;
        System.out.print("Podaj liczbę wierszy: ");
        wiersze = s.nextInt(); 
        System.out.print("Podaj liczbę kolumn: ");
        kolumny = s.nextInt(); 

        System.out.println("\n======================================\n");
        
        for (int j=1; j <= wiersze; j++) {
            for(int i =1; i<= kolumny; i++) {
                System.out.print(i*j + "\t");
            }
            System.out.println();
        }
        
        s.close(); 
    }
}