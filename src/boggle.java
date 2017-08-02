/**
 * Created by kathan on 7/19/17.
 */
public class boggle {
    final static String[] dictionary = {"GEEKS", "QUIZ", "FOR", "GO"};
    final static int longestWordLength = 5;

    public static boolean findWord(String word){
        boolean wordFound = false;

        if(word == null){
            return wordFound;
        }

        for(int i = 0; i < dictionary.length; i++){
            if(word.equals(dictionary[i])){
                return true;
            }
        }

        return wordFound;
    }

    public static void findWordFromBoggle(String result, int row, int col, char[][] boggle){
        if(row == boggle[0].length || col == boggle.length || row < 0 || col < 0 || result.length() > longestWordLength){
            return;
        }
        if(findWord(result)){
            System.out.println(result);
        }

        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                try {
                    result += boggle[row + j][col + i];
                }catch(ArrayIndexOutOfBoundsException e){
                    continue;
                }
                findWordFromBoggle(result, row + j, col + i, boggle);
                result = result.substring(0, result.length() - 1);
            }
        }
    }


    public static void main(String args[]){
        char[][] boggle = {{'G', 'I', 'Z'},
                            {'U', 'E', 'K'},
                            {'Q', 'S', 'E'}};

        for(int col = 0; col < boggle.length; col++){
           for(int row = 0; row < boggle[col].length; row++){
               findWordFromBoggle(String.valueOf(boggle[row][col]), row, col, boggle);
           }
       }
    }
}

/*
G U Q
I E S
Z K E
*/