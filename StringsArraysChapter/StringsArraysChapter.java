import java.util.*;

public class StringsArraysChapter {

    public static void main (String[] args) {
        String str1 = "abcdE";
        String str2 = "bkncdae";
        String str3 = "Mr John Smith    ";
        int n = 13;
        String str4 = "pale";
        String str5 = "ple";
        String str6 = "bale";
        String str7 = "bake";
        String str8 = "pales";
        String str9 = "Tact Coa";
//        System.out.println(isUnique(str1));
//        System.out.println(isPermutation(str1, str2));
//        System.out.println(URLify(str3, n));
//        System.out.println(str4 + " "+ str5 + " " + oneAway(str4, str5));
//        System.out.println(str4 + " "+ str6 + " " + oneAway(str4, str6));
//        System.out.println(str4 + " "+ str7 + " " + oneAway(str4, str7));
//        System.out.println(isPalindromePermutation(str9));
    }

    public static boolean isUnique(String str) {
        HashMap<Character, Integer> h1 = new HashMap<Character, Integer>();
        for(int i=0; i<str.length(); i++) {
            if (h1.containsKey(str.charAt(i))) {
                return false;
            } else {
                h1.put(str.charAt(i), 1);
            }
        }
        return true;
    }

    public static boolean isPermutation(String str1, String str2) {
        if(str1.length()>str2.length()) {return false;}
        HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();
        for(int i=0; i<str1.length(); i++) {
            if(hm1.containsKey(str1.charAt(i))) {
                hm1.put(str1.charAt(i), hm1.get(str1.charAt(i)) + 1);
            } else {
                hm1.put(str1.charAt(i), 1);
            }
        }
        for(int j=0; j<str2.length(); j++) {
            if(hm2.containsKey(str2.charAt(j))) {
                hm2.put(str2.charAt(j), hm2.get(str2.charAt(j)) + 1);
            } else {
                hm2.put(str2.charAt(j), 1);
            }
        }
        Iterator iterator = hm1.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry me = (Map.Entry) iterator.next();
            if(hm2.containsKey(me.getKey()) && (me.getValue()==hm2.get(me.getKey()))) {

            } else {
                return false;
            }
        } return true;
    }

    public static char[] URLify (String str, int n) {
        char[] ch = new char[str.length()];
        int shift = 0;
        for(int i = 0; i<n; i++) {
            if(str.charAt(i) == ' ') {
                ch[i+shift] = '%';
                ch[i+shift+1] = '2';
                ch[i+shift+2] = '0';
                shift+=2;
            } else {
                ch[i+shift] = str.charAt(i);
            }
        }
        return ch;
    }

    public static boolean oneAway(String str1, String str2) {
        if(Math.abs(str1.length()-str2.length())>1) {
            return false;
        }
        if(str1.length()==str2.length()) {
            int differCount = 0;
            for(int i = 0; i<str1.length();i++) {
                if(str1.charAt(i) != str2.charAt(i)) {
                    if(differCount<1) {
                        differCount++;
                    } else {
                        return false;
                    }
                }
            }
        }
        if(str1.length()<str2.length()) {
            int differCount = 0;
            for(int i=0; i<str1.length();i++) {
                if(str1.charAt(i) != str2.charAt(i)) {
                    if(differCount<1) {
                        differCount++;
                        str1 = str1.substring(0,i) + "%" + str1.substring(i);
                    } else {
                        return false;
                    }
                }
            }
        }
        if(str2.length()<str1.length()) {
            int differCount = 0;
            for(int i=0; i<str2.length();i++) {
                if(str1.charAt(i) != str2.charAt(i)) {
                    if(differCount<1) {
                        differCount++;
                        str2 = str2.substring(0,i) + "%" + str2.substring(i);
                    } else {
                        return false;
                    }
                }
            }
        } return true;
    }

    public static boolean isPalindromePermutation(String str) {
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for(int i = 0; i<str.length(); i++) {
            if(str.charAt(i) != ' ') {
                if(hm.containsKey(Character.toLowerCase(str.charAt(i)))) {
                    hm.put(Character.toLowerCase(str.charAt(i)), hm.get(Character.toLowerCase(str.charAt(i)))+1);
                } else {
                    hm.put(Character.toLowerCase(str.charAt(i)),1);
                }
            }
        }
        return oddCountOk(hm);
    }
    public static boolean oddCountOk(HashMap<Character,Integer> hm) {
        int oddCount = 0;
        for(Map.Entry <Character,Integer> entry : hm.entrySet()) {
            if(entry.getValue() % 2 == 1) {
                oddCount++;
            }
            if(oddCount>1){
                return false;
            }
        }
        return true;
    }
}
