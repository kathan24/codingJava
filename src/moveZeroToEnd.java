/**
 * Created by kathan on 7/21/17.
 */
public class moveZeroToEnd {

    public static void moveZeroes(int[] arr){
        int count = 0;
        for(int i =0; i < arr.length; i++){
            if(arr[i] != 0){
                arr[count++] = arr[i];
            }
        }

        while(count < arr.length){
            arr[count++] = 0;
        }
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        moveZeroes(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
}
