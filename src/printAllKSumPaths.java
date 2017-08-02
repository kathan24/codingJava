import java.util.ArrayList;
import java.util.List;

/**
 * Created by kathan on 7/20/17.
 */

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class printAllKSumPaths {
    public static void printAllSumPaths(Node n, ArrayList<Integer> currentList, ArrayList<ArrayList<Integer>> result, int totalSum, int remainingSum){
        if(n == null || remainingSum < 0){
            return;
        }

        ArrayList<Integer> list = new ArrayList<Integer>(currentList);
        list.add(n.value);
        remainingSum = remainingSum - n.value;

        if(remainingSum == 0){
            result.add(list);
        }

        printAllSumPaths(n.left, list, result, totalSum, remainingSum);
        printAllSumPaths(n.right, list, result, totalSum, remainingSum);

        currentList = new ArrayList<Integer>();
        remainingSum = totalSum;
        printAllSumPaths(n.left, currentList, result, totalSum, remainingSum);
        printAllSumPaths(n.right, currentList, result, totalSum, remainingSum);
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(-1);

        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        root.left.right.left = new Node(1);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right.right = new Node(6);

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        printAllSumPaths(root, new ArrayList<Integer>(), result, 5, 5);

        for(int i=0; i < result.size(); i++){
            ArrayList<Integer> list = result.get(i);
            for(int j=0; j < list.size(); j++){
                System.out.print(list.get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
