import java.util.*;

public class Recursion {

    public static void fibMemoi(int n) {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        System.out.println(fibMemoi(n, memo));
    }

    public static int fibMemoi(int n, HashMap<Integer, Integer> memo) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, fibMemoi(n-2, memo) + fibMemoi(n-1, memo));
        return memo.get(n);
    }

    public static int countWays(int n) {
        int count = 0;
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        count = countWays(n, memo);
        return count;
    }

    public static int countWays(int n, HashMap<Integer, Integer> memo) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, countWays(n-1,memo) + countWays(n-2,memo) + countWays(n-3,memo));
        return memo.get(n);
    }

    public static void main (String[] args) {
//        fibMemoi(7);
        System.out.println(countWays(5));
    }
}
