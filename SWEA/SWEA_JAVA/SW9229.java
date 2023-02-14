import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int M;
    static int T;
    static int answer = -1;
    static int[] cookies;
     
    static void makeCombination(ArrayList<Integer> list, int n, int start) {
        if(n==0) {
            int sum = 0;
            for(int i=0;i<list.size();i++) {
                sum +=list.get(i);
            }
            if(sum <=M) {
                answer = Math.max(answer, sum);
            }
        }
         
        for(int i=start;i<cookies.length;i++) {
            list.add(cookies[i]);
            makeCombination(list, n-1, i+1);
            list.remove(list.size()-1);
        }
    }
     
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            cookies = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                cookies[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(cookies);
            for(int i=N-1;i>0;i--) {
                for(int j=i-1;j>=0;j--) {
                    if(cookies[i]+cookies[j]<=M) {
                        answer = Math.max(answer, cookies[i]+cookies[j]);
                    }else { 
                        continue;
                    }
                }
            }
            System.out.println("#"+t+" "+answer);
            answer = -1;
        }
    }
}