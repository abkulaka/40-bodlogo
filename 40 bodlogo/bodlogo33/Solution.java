import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        String firstLineText = null;
        String fourthLineText = null;

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            String[] parts = line.split(" ");
            if (parts.length == 2) {
                if (i == 1) firstLineText = parts[1];
                if (i == 4) fourthLineText = parts[1];
            }
        }

       
        System.out.println(firstLineText.charAt(firstLineText.length() - 1));
        
        System.out.println(fourthLineText.charAt(fourthLineText.length() - 1));
       
        System.out.println(firstLineText.charAt(0));
    }
}
