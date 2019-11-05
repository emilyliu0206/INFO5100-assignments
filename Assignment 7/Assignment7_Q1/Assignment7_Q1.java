package Assignment7_Q1;

import javafx.scene.control.skin.TooltipSkin;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment7_Q1 {
    public static void main (String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name where you want to write");
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        String dataBeforeReverse = readFromStream(fis);
        String dataAfterReverse = reverseStringByWord(dataBeforeReverse);
        File OutputFile = new File("output");
        FileOutputStream fos = new FileOutputStream(OutputFile);
        PrintStream ps = new PrintStream(fos);
        ps.println(dataAfterReverse);
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


    public static String reverseStringByWord(String string){
        ArrayList list = new ArrayList(  );
        String word = new String(  );
        Boolean hasFullStop = false;
        for ( int i = 0; i < string.length(); i++){
            char ch = string.charAt( i );
            if (Character.isWhitespace( ch )){
                list.add( word );
                word = "";
            } else if(ch == '.'){
                hasFullStop = true;
                continue;
            } else {
                word = word + ch;
            }
        }
        if (word != ""){
            list.add(word);
        }
        int n = list.size();
        String result = new String();

        for (int i = n-1; i >=0 ; i--) {
            String words = (String)list.get(i);

            if (i != 0){
                result = result + words + " ";
            }else {
                result = result + words;
            }
        }
        if(hasFullStop) {
            result = result + ".";
        }
        return result;
    }
}

