/**
 * Created by kathan on 7/21/17.
 */


// 1 2 3 4
// 1 1 2 6
// 24  12  4 1
public class multiplyEveryElementExceptAtIndex {
    public static int[] multiplyEveryElementExceptAtThatIndex(int[] arr){
        int[] leftToRight = new int[arr.length];
        leftToRight[0] = 1;

        for(int i = 1; i < arr.length; i++){
            leftToRight[i] = leftToRight[i - 1] * arr[i - 1];
        }

        int[] rightToLeft = new int[arr.length];
        rightToLeft[arr.length - 1] = 1;

        for(int i = arr.length - 2; i >= 0; i--){
            rightToLeft[i] = rightToLeft[i + 1] * arr[i + 1];
        }

        for(int i=0; i < arr.length; i++){
            leftToRight[i] = leftToRight[i] * rightToLeft[i];
        }

        return leftToRight;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4};
        arr = multiplyEveryElementExceptAtThatIndex(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
