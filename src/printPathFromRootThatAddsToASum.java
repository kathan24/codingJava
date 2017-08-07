import java.util.ArrayList;

/**
 * Created by xad on 8/7/17.
 */

class TreeNode{
    public TreeNode left;
    public TreeNode right;
    public int value;

    TreeNode(int value){
        this.value = value;
    }
}
public class printPathFromRootThatAddsToASum {
    public static void printPaths(TreeNode node, int remainingSum, ArrayList<Integer> currentList){
        if(remainingSum == 0){
            for(int i = 0; i < currentList.size(); i++){
                System.out.print(currentList.get(i));
                System.out.print(" ");
            }
            System.out.println(" ");
        }

        if(node.left != null){remainingSum = remainingSum + node.left.value;
            currentList.add(node.left.value);
            remainingSum = remainingSum - node.left.value;
            printPaths(node.left, remainingSum, currentList);

            // if node has right, then for the right node we need to keep the sum as is
            remainingSum = remainingSum + node.left.value;
        }

        if(node.right != null){
            currentList.add(node.right.value);
            remainingSum = remainingSum - node.right.value;
            printPaths(node.right, remainingSum, currentList);
        }

        currentList.remove(currentList.size() - 1);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(28);
        root.right = new TreeNode(13);

        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);

        root.right.left.left = new TreeNode(21);
        root.right.left.right = new TreeNode(22);
        root.right.right.left = new TreeNode(23);
        root.right.right.right = new TreeNode(24);

        int sum = 38;

        ArrayList<Integer> nodeList = new ArrayList<Integer>();

        nodeList.add(root.value);
        printPaths(root, sum - root.value, nodeList);
    }
}
