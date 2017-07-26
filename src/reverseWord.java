/**
 * Created by xad on 7/21/17.
 */
public class reverseWord {
    public static void main(String[] args){
        String example = "example";

        StringBuilder str = new StringBuilder();
        for(int i = example.length() - 1; i >= 0; i--){
            str.append(example.charAt(i));
        }

        System.out.println(str.toString());
    }
}
