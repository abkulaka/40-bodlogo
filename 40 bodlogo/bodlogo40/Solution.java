import java.io.*;
import java.util.*;

class Result {

    public static int shortPalindrome(String s) {
        int mod = 1000000007;
        int n = s.length();

        int[] leftCount = new int[26];
        int[] rightCount = new int[26];
        int[][] pairLeft = new int[26][26];

        // Count all characters initially in rightCount
        for (int i = 0; i < n; i++) {
            rightCount[s.charAt(i) - 'a']++;
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            rightCount[c]--;

            // Add palindromes formed by pairs crossing this character
            for (int j = 0; j < 26; j++) {
                result = (result + (long) pairLeft[j][c] * rightCount[j]) % mod;
            }

            // Update pairLeft counts with pairs ending at this character
            for (int j = 0; j < 26; j++) {
                pairLeft[j][c] += leftCount[j];
            }

            leftCount[c]++;
        }

        return (int) result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        int result = Result.shortPalindrome(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
