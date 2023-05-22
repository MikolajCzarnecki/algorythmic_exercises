import java.util.Scanner;
class zapalanie {
    public static int[] ileBitow(int a){
        int n = 1;
        int currPot = 0;
        while(2 * n <= a) {
            n *= 2;
            currPot++;
        }
        int[] bityiPotega = new int[2];
        bityiPotega[0] = currPot + 1;
        bityiPotega[1] = n;
        return bityiPotega;
    }
    public static int zapalone(int liczba){
        int[] bityiPotega = new int[2];
        bityiPotega = ileBitow(liczba);
        int zapalone = 0;
        /*dodanie zapalonych z liczb mniejszych od najwiekszej potegi dwojki mniejszej od liczby*/
        zapalone += (bityiPotega[0] - 1) * (bityiPotega[1] / 2);
        /*zapalone w najwiekszej potedze dwojki mniejszej od liczby*/
        zapalone++;
        int dystans = liczba - bityiPotega[1];
        /*zapalone w liczbach wiekszych od potegi*/
        for (int i = 2; i <= bityiPotega[1]; i *= 2){
            zapalone += (dystans / i) * dystans / 2 + Math.max((dystans % i) - (i / 2) + 1, 0);
        }
        zapalone += dystans; //zapalone w najwiekszych bitach
        return zapalone;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int liczba = s.nextInt();
        int zapalone = zapalone(liczba);
        System.out.println(zapalone);

    }
}
