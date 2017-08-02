/**
 * Created by kathan on 8/1/17.
 */
public class binaryPalindrome {
    public static boolean isBinaryPalindrome(int number){
        int value = number;

        int numberOfBits = 0;
        while(value > 0){
            numberOfBits++;
            value = value >> 1;
        }

        int left = 0;
        int right = numberOfBits - 1;

        while(left < right){
            if(isBitSet(number, left) != isBitSet(number, right)){
                return false;
            }
            right--;
            left++;
        }

        return true;
    }

    public static boolean isBitSet(int number, int index){
        return (number & (1 << index)) != 0;
    }

    public static void main(String[] args){
        System.out.println(isBinaryPalindrome(8));
    }
}
