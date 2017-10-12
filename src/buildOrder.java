import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by kathan on 7/19/17.
 */
public class buildOrder {
    static HashMap<Integer, ArrayList> relationship = new HashMap<Integer, ArrayList>();

    public static void main(String[] args){
        ArrayList<Integer> firstList = new ArrayList<Integer>();
        firstList.add(2);
        firstList.add(3);
        firstList.add(5);

        ArrayList<Integer> secondList = new ArrayList<Integer>();
        secondList.add(6);
        secondList.add(7);
        secondList.add(8);

        ArrayList<Integer> thirdList = new ArrayList<Integer>();
        thirdList.add(4);

        ArrayList<Integer> fifthList = new ArrayList<Integer>();
        fifthList.add(6);
        fifthList.add(7);
        fifthList.add(8);

        relationship.put(1, firstList);
        relationship.put(2, secondList);
        relationship.put(3, thirdList);
        relationship.put(4, new ArrayList());
        relationship.put(5, fifthList);
        relationship.put(6, new ArrayList());
        relationship.put(7, new ArrayList());
        relationship.put(8, new ArrayList());

        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < relationship.get(1).size(); i++){
            ArrayList<Integer> currentList = new ArrayList<Integer>();
            currentList.add(1);
            try{
                buildOrderFromProjectId(Integer.parseInt(relationship.get(1).get(i).toString()), currentList, result);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println(result);
    }

    public static void buildOrderFromProjectId(int project_id, ArrayList<Integer> currentList, ArrayList<Integer> result) throws Exception{
        for(int i = 0; i < currentList.size(); i++){
            if(project_id == currentList.get(i)){
                throw new Exception("Project dependency loop found.");
            }
        }

        currentList.add(project_id);

        if(relationship.get(project_id).size() > 0){
            for(int i = 0; i < relationship.get(project_id).size(); i++){
                buildOrderFromProjectId(Integer.parseInt(relationship.get(project_id).get(i).toString()), currentList, result);
            }
        }

        result.add(project_id);
        currentList.remove(currentList.size() - 1);
    }

}

/*
NOTE: Here 1 is dependent on 2 3 5 so use recursion method.
Another case https://github.com/kathan24/codingPython/blob/master/letterRelationship.py
where dependency is reverse to use Topological sort

1 -> 2 3 5
2 -> 6 7 8
3 -> 4
4
5 -> 6 7 8
6
7
8

6 7 8 2 4 3 6 7 8 5
*/
