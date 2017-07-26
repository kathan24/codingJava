import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class numberToBooleanArray
{
    public static void main(String[] args) {

        int input = 252;

        boolean[] bits = new boolean[8];
        for (int i = 7; i >= 0; i--) {
            bits[i] = (input & (1 << i)) != 0;
        }

        System.out.println(input + " = " + Arrays.toString(bits));

    }
}