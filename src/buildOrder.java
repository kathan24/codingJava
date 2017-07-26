import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by xad on 7/19/17.
 */
public class buildOrder {
    static HashMap<Integer, ArrayList> relationship = new HashMap<Integer, ArrayList>();

    public static void main(String[] args){
        relationship.put(1, new ArrayList(Arrays.asList(2, 3, 5)));
        relationship.put(2, new ArrayList(Arrays.asList(6, 7, 8)));
        relationship.put(3, new ArrayList(Arrays.asList(4)));
        relationship.put(4, new ArrayList());
        relationship.put(5, new ArrayList(Arrays.asList(6, 7, 8)));
        relationship.put(6, new ArrayList());
        relationship.put(7, new ArrayList());
        relationship.put(8, new ArrayList());

        System.out.println(buildOrder(1));
    }

    public static ArrayList buildOrder(int project_id){
        ArrayList dependency = relationship.get(project_id);

        ArrayList result = new ArrayList();
        for(int i = 0; i < dependency.size(); i++){
            result.addAll(buildOrder(Integer.parseInt(dependency.get(i).toString())));
        }

        result.add(project_id);
        return result;
    }

}

/*
1 -> 2 3 5
2 -> 6 7 8
3 -> 4
4
5 -> 6 7 8
6
7
8

6 7 8 2 4 3 6 7 8 5 1
*/
