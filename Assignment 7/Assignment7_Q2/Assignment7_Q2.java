package Assignment7_Q2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment7_Q2 {
    public static void main (String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name where you want to write");
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        String encodedString = readFromStream(fis);
        String decodeString = decode(encodedString);
        File OutputFile = new File("output");
        FileOutputStream fos = new FileOutputStream(OutputFile);
        PrintStream ps = new PrintStream(fos);
        ps.println(decodeString);
        ps.close();
        fos.close();
    }


    private static String readFromStream(FileInputStream fis) throws IOException {
        String result = "";
        while (true) {
            int x = fis.read();
            if (x == -1)
                break;
            char c = (char) x;
            String s = String.valueOf(c);
            result = result + s;
        }
        fis.close();
        return result;
    }


    private static String decode(String String) {
        String result ="";
        String word = new String(  );
        int repeatNumber = 0;
        for(int i = 0; i < String.length(); i++ ){
            char ch = String.charAt( i );
            word = word + ch;
            if(ch ==  '['){
                repeatNumber = Integer.parseInt(word.substring(0,word.length()-1));
                word = "";
            }else if(ch ==  ']'){
                String code = word.substring(0,word.length()-1);
                result = result+ code.repeat(repeatNumber);
                word = "";
            }
        }
        return result;
    }
}
