import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    static BufferedReader br;
    static String str;
    static String line;
    static int L;
    static int[] K;
    static int tcase = 1;
    static boolean isAble(int[] k) {
        return (k[0]>=0 && k[1]>=0 && k[2]>=0 && k[3]>=0);
    }
     
    static void inputChar(char c) {
        switch(c) {
        case '(': K[0]++;break;
        case ')': K[0]--;break;
        case '[': K[1]++;break;
        case ']': K[1]--;break;
        case '{': K[2]++;break;
        case '}': K[2]--;break;
        case '<': K[3]++;break;
        case '>': K[3]--;break;
        }
    }
     
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        while(str != null) {
            boolean flag = true;
            K = new int[4];
            L = Integer.parseInt(str);
            line = br.readLine();
            for(int i=0;i<L;i++) {
                inputChar(line.charAt(i));
                if(!isAble(K)) {
                    flag = false;
                    break;  
                }
            }
            for(int i=0;i<4;i++) {
                flag = flag && (K[i]==0);
            }
            if(flag) {
                System.out.println("#"+tcase+" 1");
            }else {
                System.out.println("#"+tcase+" 0");
            }
            tcase++;
            str = br.readLine();
        }
    }
}