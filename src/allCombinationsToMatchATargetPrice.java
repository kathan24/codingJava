import java.util.ArrayList;

/**
 * Created by kathan on 8/6/17.
 */

/*
Given a list of menu items and prices. Print all combinations that match a target price.
Eg: target = $3, Menu( A:$1 , B:$2)

Print
A,A,A
A,B

But no B,A
* */

class allCombinationsToMatchATargetPrice {
    public static void printCombinations(int[] items, int target, ArrayList<Integer> currentItems){
        int total = 0;
        for(int i = 0; i < currentItems.size(); i++){
            total += currentItems.get(i);
        }

        if(total > target){
            return;
        }else if(total == target){
            for(int i = 0; i < currentItems.size(); i++){
                System.out.print(currentItems.get(i));
                System.out.print(" ");
            }
            System.out.println(" ");
            return;
        }

        for(int j = 0; j < items.length; j++){
            currentItems.add(items[j]);
            printCombinations(items, target, currentItems);
            currentItems.remove(currentItems.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] items = {3,9,8,4,5,7,10};
        printCombinations(items, 15, new ArrayList<Integer>());
    }
}
