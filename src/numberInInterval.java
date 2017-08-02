import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by kathan on 7/21/17.
 */
public class numberInInterval {
    public static void correctInterval(ArrayList<ArrayList<Integer>> arr){
        Collections.sort(arr, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        int lastOfLast = arr.get(0).get(1);

        for(int i = 1; i < arr.size(); i++){
            int currentFirst = arr.get(i).get(0);
            int currentLast = arr.get(i).get(1);

            if(currentFirst < lastOfLast){
                if(currentLast < lastOfLast){
                    arr.remove(i);
                }else{
                    arr.get(i-1).set(1, currentLast);
                    arr.remove(i);
                }
            }else{
                lastOfLast = currentLast;
            }
        }
    }

    public static boolean checkIfNumberInterval(ArrayList<ArrayList<Integer>> arr, int value){
        boolean isPresent = false;

        if(arr == null){
            return isPresent;
        }

        int start = 0;
        int end = arr.size();

        while(start < end){
            int mid = (start + end)/2;

            if(arr.get(mid).get(0) < value && value < arr.get(mid).get(1)){
                isPresent = true;
                break;
            }else if(value > arr.get(mid).get(0)){
                start = mid + 1;
            }else{
                end = mid - 1;
            }

        }

        return isPresent;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> subArr = new ArrayList<Integer>();
        subArr.add(1);
        subArr.add(4);
        arr.add(subArr);

        subArr = new ArrayList<Integer>();
        subArr.add(8);
        subArr.add(26);
        arr.add(subArr);

        subArr = new ArrayList<Integer>();
        subArr.add(16);
        subArr.add(21);
        arr.add(subArr);

        subArr = new ArrayList<Integer>();
        subArr.add(28);
        subArr.add(42);
        arr.add(subArr);

        correctInterval(arr);
        System.out.println(checkIfNumberInterval(arr, 25));
        System.out.println(checkIfNumberInterval(arr, 5));
        System.out.println(checkIfNumberInterval(arr, 0));
        System.out.println(checkIfNumberInterval(arr, 32));
    }
}
