package Assignment7_Q3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Assignment7_Q3 {
    public static void main(String[] args) throws Exception {
        PrintWriter count_results = new PrintWriter("D:\\IntelliJ IDEA 2019.2.4\\jbr\\src\\Assignment7_Q3\\count_results", StandardCharsets.UTF_8);
        for(int i = 0; i < args.length; i++){
            try {
                File file = new File("D:\\IntelliJ IDEA 2019.2.4\\jbr\\src\\Assignment7_Q3\\" + args[i]);
                BufferedReader bf = new BufferedReader(new FileReader(file));
                int count = 0;
                while (bf.readLine() != null) {
                    count++;
                }
                count_results.println(args[i] + ": this file has " + count + " lines");
            }catch (IOException e){
                count_results.println(args[i] + ": this file doesn't exist");
            }
        }
        count_results.close();
    }
}
