package questions.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity1436 {


    /*

    Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
    Output: "Sao Paulo"
     */
    public String destCity(List<List<String>> paths) {
        Map<String, String> route = new HashMap<>();
        for (List<String> path : paths) {
            route.put(path.get(0), path.get(1));
        }
        for (List<String> path : paths) {
            String place = route.get(path.get(1));
            if (place == null) {
                return path.get(1);
            }
        }
        return null;
    }
}
