import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by kathan on 8/4/17.
 */

/*given an adjacent matrix :
     [
          [1, 2, 3],   0 -> 1, 2, 3
          [8, 6, 4],   1 -> 8, 6, 4
          [7, 8, 3],   2 ...
          [8, 1],      ...
          [6],
          [8, 7],
          [9, 4],
          [4, 6],
          [1],
          [1, 4]
         ]

         find the path from node 0 to node 9, with minimum cost

         ex.
         0 -> 1 -> 4 -> 6 -> 9

         0 -> 1 cost (1 - 0) ** 2 = 1
         1 -> 4 cost (4 - 1) ** 2 = 9
         4 -> 6 cost (6 - 4) ** 2 = 4
         6 -> 9 cost (9 - 6) ** 2 = 9

         total cost = 23
*/

public class minimumDistanceBetweenNode {
    public static int minCost = Integer.MAX_VALUE;
    public static ArrayList<Integer> pathList = new ArrayList<Integer>();

    public static int getCost(int node1, int node2){
        return (node1 - node2) * (node1 - node2);
    }

    public static void findPathAToB(int node, ArrayList<Integer> currentList, ArrayList<ArrayList<Integer>> matrix, int totalCost){
        if(node == 9 && totalCost < minCost){
            minCost = totalCost;
            pathList.clear();
            pathList.addAll(currentList);
            return;
        }

        for(int i = 0; i < matrix.get(node).size(); i++){
            int currentNode = matrix.get(node).get(i);

            for(int j = 0; j < currentList.size(); j++){
                if(currentNode == currentList.get(j)){
                    return;
                }
            }

            int currentCost = getCost(currentNode, node);

            if(totalCost + currentCost < minCost){
                currentList.add(currentNode);
                findPathAToB(currentNode, currentList, matrix, totalCost + currentCost);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> firstNodeNeighbors = new ArrayList<Integer>();
        firstNodeNeighbors.add(1);
        firstNodeNeighbors.add(2);
        firstNodeNeighbors.add(3);

        ArrayList<Integer> secondNodeNeighbors = new ArrayList<Integer>();
        secondNodeNeighbors.add(8);
        secondNodeNeighbors.add(6);
        secondNodeNeighbors.add(4);

        ArrayList<Integer> thirdNodeNeighbors = new ArrayList<Integer>();
        thirdNodeNeighbors.add(7);
        thirdNodeNeighbors.add(8);
        thirdNodeNeighbors.add(3);

        ArrayList<Integer> fourthNodeNeighbors = new ArrayList<Integer>();
        fourthNodeNeighbors.add(8);
        fourthNodeNeighbors.add(1);

        ArrayList<Integer> fifthNodeNeighbors = new ArrayList<Integer>();
        fifthNodeNeighbors.add(6);

        ArrayList<Integer> sixthNodeNeighbors = new ArrayList<Integer>();
        sixthNodeNeighbors.add(8);
        sixthNodeNeighbors.add(7);

        ArrayList<Integer> seventhNodeNeighbors = new ArrayList<Integer>();
        seventhNodeNeighbors.add(9);
        seventhNodeNeighbors.add(4);

        ArrayList<Integer> eigthNodeNeighbors = new ArrayList<Integer>();
        eigthNodeNeighbors.add(4);
        eigthNodeNeighbors.add(6);

        ArrayList<Integer> ninthNodeNeighbors = new ArrayList<Integer>();
        ninthNodeNeighbors.add(1);

        ArrayList<Integer> tenthNodeNeighbors = new ArrayList<Integer>();
        tenthNodeNeighbors.add(1);
        tenthNodeNeighbors.add(4);

        matrix.add(firstNodeNeighbors);
        matrix.add(secondNodeNeighbors);
        matrix.add(thirdNodeNeighbors);
        matrix.add(fourthNodeNeighbors);
        matrix.add(fifthNodeNeighbors);
        matrix.add(sixthNodeNeighbors);
        matrix.add(seventhNodeNeighbors);
        matrix.add(eigthNodeNeighbors);
        matrix.add(ninthNodeNeighbors);
        matrix.add(tenthNodeNeighbors);

        for(int i = 0; i < matrix.get(0).size(); i++){
            int currentNode = matrix.get(0).get(i);
            int currentCost = getCost(currentNode, 0);

            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(0);
            list.add(currentNode);
            findPathAToB(currentNode, list, matrix, currentCost);
            list.remove(list.size() - 1);
        }

        System.out.println(minCost);
        for(int i = 0 ; i < pathList.size(); i++){
            System.out.print(pathList.get(i));
            System.out.print(" ");
        }
    }
}
