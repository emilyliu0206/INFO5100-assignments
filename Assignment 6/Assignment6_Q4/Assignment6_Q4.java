package Assignment6_Q4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assignment6_Q4 {
    public boolean uniqueOccurrences(int[] arr) {
        List arrlist  = new ArrayList();
        for (int i : arr){
            arrlist.add(i);
        }
        List count = new ArrayList();
        for (int j =0; j<arrlist.size();j++){
            int n = 1;
            for (int i = j+1; i<arrlist.size();i++){
                if(arrlist.get(i) == arrlist.get(j)){
                    n=n+1;
                    arrlist.remove(i);
                    i=i-1;
                }
            }
            count.add(n);
            for(int m = 0; m<count.size()-1;m++){
                int k = Integer.parseInt(count.get(m).toString());
                if(n == k){
                    return false;
                }
            }
        }return true;
    }

}
