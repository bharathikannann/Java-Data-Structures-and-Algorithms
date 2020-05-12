import java.math.BigInteger;

public class BitTricks {
    public static void main (String[] args) {
        System.out.println(("Hello World"));
        System.out.println(BigInteger.valueOf(7).isProbablePrime(1));
        char a='a';
        System.out.printf("Lower to upper case %c\n",a&='_');
        char aa='a';
        System.out.printf("Lower to Upper case %c\n",aa-32);
        char b='B';
        System.out.printf("Upper to Lower case %c\n",b|=' ');
        int c=2,d=20;
        System.out.print("Multiplying by 2 ");
        System.out.println(c <<= 1);
        System.out.print("Dividing by 2 ");
        System.out.println(d >>= 1);
        int s1=10;
        int s2=20;
        // A quick way to swap a and b
        s1 ^= s2;
        s2 ^= s1;
        s1 ^= s2;
        System.out.println("Swapping using XOR");
        System.out.println(s1);
        System.out.println(s2);
        int evencheck=10;
        System.out.println("To Check even using and gate ");
        System.out.println((evencheck&1)==0?"EVEN":"ODD");
    }
}
