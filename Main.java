import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        
        int liczba = 100;
        System.out.println(liczba);
        liczba = s.nextInt(); 
        System.out.println(liczba);

        s.close();
    }
}