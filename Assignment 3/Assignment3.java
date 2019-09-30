import java.lang.module.FindException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Assignment3 {

//    Q5.
//    The count-and-say sequence is a sequence of integers with the first five terms as following:
//            1.     1
//            2.     11
//            3.     21
//            4.     1211
//            5.     111221
//
//            1 is read off as "one 1" or 11.
//            11 is read off as "two 1s" or 21.
//            21 is read off as "one 2, then one 1" or 1211.
//    Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
//    Note: Each term of the sequence of integers will be represented as a string.
//
//            Example 1:
//    Input: 1
//    Output: "1"
//
//    Example 2:
//    Input: 4
//    Output: "1211"

    public String countAndSay(int n) {
        String[] result = new String[n];
        result[0] = "1";
        if ( n != 1) {
            for (int i = 1; i < n; i++) {
                result[i] = helper(result[i- 1]);
            }
        }
        return result[n-1];
    }

    public String helper(String s){
        char preChar = s.charAt(0);
        int currentCharCount = 0;
        String outputString = new String();
        for (int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if (currentChar == preChar){
                currentCharCount++;
            }else{
                outputString = outputString + currentCharCount + preChar;
                preChar = currentChar;
                currentCharCount = 1;
            }
        }if (currentCharCount != 0){
            outputString = outputString + currentCharCount + preChar;
        }
        return outputString;
    }


//    Q6. Given an input string , reverse the string word by word.
//            Example:
//    Input : “the sky is blue”
//    Output : “blue is sky the”

    public String reverseStringByWord(String string){
        ArrayList list = new ArrayList(  );
        String word = new String(  );
        for ( int i = 0; i < string.length(); i++){
            char ch = string.charAt( i );
            if (Character.isWhitespace( ch )){
                list.add( word );
                word = "";
            }else {
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
        return result;
    }


//    Q7.
//    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//    Example 1:
//    Input:
//            [
//            [ 1, 2, 3 ],
//            [ 4, 5, 6 ],
//            [ 7, 8, 9 ]
//            ]
//    Output: [1,2,3,6,9,8,7,4,5]

    public int[] spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList();
        if (matrix.length == 0)
            return ans.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
        int row1 = 0, row2 = matrix.length - 1;
        int column1 = 0, column2 = matrix[0].length - 1;
        while (row1 <= row2 && column1 <= column2) {
            for (int c = column1; c <= column2; c++) ans.add(matrix[row1][c]);
            for (int r = row1 + 1; r <= row2; r++) ans.add(matrix[r][column2]);
            if (row1 < row2 && column1 < column2) {
                for (int c = column2 - 1; c > column1; c--) ans.add(matrix[row2][c]);
                for (int r = row2; r > row1; r--) ans.add(matrix[r][column1]);
            }
            row1++;
            row2--;
            column1++;
            column2--;
        }
        return ans.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
    }


//    Q8.
//    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this
//    P   A   H   N
//    A P L S I I G
//    Y   I   R
//    And then read line by line: "PAHNAPLSIIGYIR"
//    Write the code that will take a string and make this conversion given a number of rows:
//    String convert(string s, int numRows);
//    Example 1:
//    Input: s = "PAYPALISHIRING", numRows = 3
//    Output: "PAHNAPLSIIGYIR"

    public String convert(String s, int numRows){
        String[] list= new String[numRows];
        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows; i++) {
                if (index >= s.length()){
                    break;
                }
                if (list[i] == null){
                    list[i] = Character.toString(s.charAt( index ));
                }
                else{
                    list[i] = list[i] + s.charAt(index);
                }
                index++;

            }

            for (int j = numRows - 2; j > 0; j--) {
                if (index >= s.length()){
                    break;
                }
                list[j] = list[j] + s.charAt(index);
                index++;
            }
        }
        return list[0] + list[1] + list[2];
    }


//    Q9. Explain Encapsulation with an example. (Write at least 30-40 words).

//    Encapsulation means combining all data and code to form a single unit, hiding internal details and data to
//    protect the data from outside world.
//    For example, a cat can be a class as an unit, and in this class, cat has its own features and behaviors, you
//    can edit it in the class. But when you use this class, you can only get it by getter or set it by setter in a
//    particular way, and you have no idea about the inner implementation of the class.
//
//
//    Q10. What is the difference between Encapsulation and Abstraction
//
//    Abstraction refers to extracting common and essential features from a large number of transactions as a
//    whole in the design level. It focus on what an object does.
//    Encapsulation is all about implementation focusing on how an object does, and hiding the internal details.





}