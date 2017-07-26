/**
 * Created by xad on 7/19/17.
 */
public class firstNonRepeatingChar {
    public static char count[] = new char[256];

    static void findFirstNonRepeatingChar(String str){
        for(int i = 0; i < str.length(); i++){
            count[str.charAt(i)]++;
        }

        for(int i = 0; i < str.length(); i++){
            if(count[str.charAt(i)] == 1){
                System.out.println(str.charAt(i));
                break;
            }
        }
    }

    public static void main(String[] args){
        findFirstNonRepeatingChar("geeksforgeeks");
    }

}
