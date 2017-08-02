/**
 * Created by kathan on 7/18/17.
 */
public class permutationOfAString {
    public static void main(String[] args){
        printAllPermutation("", "abc");
    }

    public static void printAllPermutation(String result, String remainingString){
        if(remainingString.length() > 1){
            char[] remainingCharArray = remainingString.toCharArray();

            for(int i = 0; i < remainingCharArray.length; i++){
                StringBuilder tempBuilder = new StringBuilder(remainingString);
                tempBuilder.deleteCharAt(i);
                printAllPermutation(result + remainingCharArray[i], tempBuilder.toString());
            }
        }else{
            System.out.println(result + remainingString);
        }
    }
}


/*
abc
acb
bac
bca
cab
cba
*/
