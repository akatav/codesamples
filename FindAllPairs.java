import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Problem1 {
    
    private static int[] num;

    public static void main(String[] args) {
        int n = 0, k = 0;
        String line = "";
        int lineNum = 0;
        int i = 0;
        try {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int tokenNum = 0;
            while(st.hasMoreTokens()) {
                String token = st.nextToken();
                if(lineNum == 0) {
                    if(tokenNum == 0) {
                        n = Integer.parseInt(token);
                        num = new int[n];
                    }
                    if(tokenNum == 1)
                        k = Integer.parseInt(token);
                    tokenNum++;
                }
                else {
                    num[i] = Integer.parseInt(token);
                    i++;
                }
            }
        
            lineNum++;
        }
        int pairs = findAllPairs(num, k);
        System.out.println("Number of pairs: " + pairs);
        }
        
        catch(IOException ex) {
            System.out.println(ex);
        }
    }


    private static int findAllPairs(int[] num, int k) {
        
        // Sort
        Arrays.sort(num);
        int len = num.length;
        int low = 0, high = len-1;
        int pairs = 0;
        for(int i = 0; i < len; i++) {
            
            int target = num[i] + k;
            low = i;
            while(low != high) {
            
                int mid = (low + high)/2;
                if(target < num[mid]) {
                    high = mid - 1;
                }
                else if(target == num[mid]) {
                    pairs++;
                    break;
                }
                else
                    low = mid + 1;
           }
            
           if(low == high)
               if(target == num[low])
                   pairs++;
        }
        return pairs;
   }
}
