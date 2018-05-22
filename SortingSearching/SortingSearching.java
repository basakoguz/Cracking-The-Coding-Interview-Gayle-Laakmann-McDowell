import java.util.*;

public class SortingSearching {

    public static void merge(int[] arr1, int[] arr2) {
        if(firstIsLarger(arr1, arr2)) {
            System.out.println("Before: " + Arrays.toString(arr1));
            int diff = arr1.length - arr2.length;
            int last1 = diff - 1;
            int last2 = arr2.length - 1;
            int curr = arr1.length - 1;
            while(last2 >= 0 && last1 >= 0) {
                if(arr1[last1] > arr2[last2]) {
                    arr1[curr] = arr1[last1];
                    curr--;
                    last1--;
                } else {
                    arr1[curr] = arr2[last2];
                    curr--;
                    last2--;
                }
            }
            System.out.println("After: " + Arrays.toString(arr1));
        } else {
            System.out.println("Before: " + Arrays.toString(arr2));
            int diff = arr2.length - arr1.length;
            int last2 = diff - 1;
            int last1 = arr1.length - 1;
            int curr = arr2.length - 1;
            while(last1 >= 0 && last2 >= 0) {
                if(arr2[last2] > arr1[last1]) {
                    arr2[curr] = arr2[last2];
                    curr--;
                    last2--;
                } else {
                    arr2[curr] = arr1[last1];
                    curr--;
                    last1--;
                }
            }
            System.out.println("After: " + Arrays.toString(arr2));
        }
    }

    public static boolean firstIsLarger(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) return true;
        return false;
    }

    public static void groupAnagrams(String[] arr) {
        HashMap <String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        String[] grouped = new String[arr.length];
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            String key = sortString(arr[i]);
            if(!hm.containsKey(key)) {
                ArrayList<String> values = new ArrayList<String>();
                values.add(arr[i]);
                hm.put(key, values);
            } else {
                hm.get(key).add(arr[i]);
            }
        }
        for(String key : hm.keySet()) {
            ArrayList<String> values = hm.get(key);
            for(String value: values) {
                grouped[index] = value;
                index++;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(grouped));
    }

    public static String sortString(String s) {
        char[] carr = s.toCharArray();
        Arrays.sort(carr);
        return new String(carr);
    }

    public static void main(String[] args) {
        int[] arr1 = {3,7,9,12,13,14,0,0,0,0};
        int[] arr2 = {4,5,10,13};
        String[] arr = {"basak", "cem", "cee", "aakbs", "baak", "mce"};
//        merge(arr1, arr2);
//        groupAnagrams(arr);
    }
}
