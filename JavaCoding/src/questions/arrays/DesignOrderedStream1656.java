package questions.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DesignOrderedStream1656 {
    public String stream[];
    public int ptr = 0;

    public DesignOrderedStream1656(int n) {
        stream = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey - 1] = value;
        List<String> chunk = new ArrayList<>();
        while (ptr < stream.length && stream[ptr] != null) {
            chunk.add(stream[ptr]);
            ptr++;
        }
        return chunk;
    }
}
