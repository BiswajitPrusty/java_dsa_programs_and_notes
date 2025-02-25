package dsa.topkelements;

import java.util.*;

public class FindKPairsSmallest373 {

    public List<List<Integer>> kSmallestPairs(int[] A, int[] B, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        Set<Pair> visited = new HashSet<>();
        q.add(new int[]{A[0]+ B[0], 0, 0});
        int i, j;
        Pair pair;
        while (!q.isEmpty() && k-- > 0) {
            int[] min = q.remove();
            i = min[1];
            j = min[2];
            ans.add(List.of(A[i], B[j]));
            pair = new Pair(i, j + 1);
            if (j + 1 < B.length && !visited.contains(pair)) {
                q.add(new int[]{A[i] + B[j + 1], i, j + 1});
                visited.add(pair);
            }
            pair = new Pair(i + 1, j);
            if (i + 1 < A.length && !visited.contains(pair)) {
                q.add(new int[]{A[i + 1] + B[j], i + 1, j});
                visited.add(pair);
            }
        }
        return ans;
    }
    record Pair(int i, int j) {
    }

    public static void main(String[] args) {
        FindKPairsSmallest373 f = new FindKPairsSmallest373();
        System.out.println(f.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }
}
