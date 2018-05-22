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

    public static void findPathConstructor(){
        int[][] grid = new int[4][4];
        grid[1][1] = grid[1][3] = grid[3][2] = 1;
        findPath(0, 0, grid);
    }

    public static void findPath(int i, int j, int[][] grid) {
        if(j<3) {
            if(grid[i][j+1] == 0) {
                findPath(i, j+1, grid);
            }
        }
        if(i<3) {
            if(grid[i+1][j] == 0) {
                findPath(i+1, j, grid);
            }
        }
        if(i == 3 && j == 3) {
            System.out.println("Path found");
        }
    }

    public static int[] arrConstructor(int n) {
        int[] arr = new int[n];
        int min = -10;
        int max = n-1;
        Random rand = new Random();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt((max + 1 - min)) + min;
            min = arr[i];
        }
        return arr;
    }

    public static void magicIndex() {
        int[] arr = arrConstructor(8);
        System.out.println(Arrays.toString(arr));
        magicIndex(0, arr.length-1, arr);
    }

    public static void magicIndex(int start, int end, int[] arr) {
        if(end < start) return;
        if(start < 0 || end < 0) {
            return;
        }
        int midIndex = (start + end) / 2;
        if(arr[midIndex] == midIndex) {
            System.out.println(midIndex);
        }
        magicIndex(start, Math.min(midIndex-1, arr[midIndex]), arr);
        magicIndex(Math.max(midIndex+1, arr[midIndex]), end, arr);
    }

    public static void main (String[] args) {
//        fibMemoi(7);
//        System.out.println(countWays(5));
//        findPathConstructor();
//        magicIndex();
    }
}
