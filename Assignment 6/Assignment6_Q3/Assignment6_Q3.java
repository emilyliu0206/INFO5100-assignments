package Assignment6_Q3;

public class Assignment6_Q3 {
    public boolean isAnagram(String s, String t) {
        boolean result = false;
        if(t.length() == s.length()){
                for (int j = 0; j < s.length(); j++) {
                    if (t.charAt(0) == s.charAt(j)) {
                        s = s.substring(0, j) + s.substring(j + 1);
                        t = t.substring(1);
                        j = 0;
                        result = true;
                    }
                }
        }
        return result;
    }
}
