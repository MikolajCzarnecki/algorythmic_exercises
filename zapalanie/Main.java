import java.util.Scanner;
public class Main {
    public static int rozwiazanie(int [] tablica) {
        int n = tablica.length;
        int najwyzszyPunkt = tablica[0];
        int najwyzszyPunktIndex = 0;
        for (int i = 1; i < n; i++) {
            if (tablica[i] >= najwyzszyPunkt) {
                najwyzszyPunktIndex = i;
                najwyzszyPunkt = tablica[i];
            }
        }

        int iloscwody = 0;

        /*zliczamy wodę z lewej strony*/
        int temphighest = tablica[0];
        for (int i = 1; i < najwyzszyPunktIndex; i++) {
            if (tablica[i] > temphighest) temphighest = tablica[i];
            else iloscwody += temphighest - tablica[i];
        }

        /*zliczamy wodę z prawej strony*/
        temphighest = tablica[n-1];
        for (int i = n-1; i > najwyzszyPunktIndex; i--) {
            if (tablica[i] > temphighest) temphighest = tablica[i];
            else iloscwody += temphighest - tablica[i];
        }

        return iloscwody;
    }
    public static void main(String[] args) {
        int dlugosc;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ile elementów w tablicy:");
        dlugosc = sc.nextInt();
        int [] dane = new int[dlugosc];
        System.out.println("Tablica:");
        for (int i = 0; i < dlugosc; i++) {
            dane[i] = sc.nextInt();
        }
        int woda = rozwiazanie(dane);
        System.out.println("Wody jest " + woda);
    }
}