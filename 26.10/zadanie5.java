public class zadanie5 {
    public static void main(String args[]) {
        String[] imiona = {"Piotr", "Anna", "Jan", "Leszek"};
        for (int i = 1; i <= imiona.length; i++) {
            System.out.println(i + ". " + imiona[i-1]);
        }
    }
}
