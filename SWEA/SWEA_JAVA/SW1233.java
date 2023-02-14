import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int flag;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        // 식 성립 조건 1 : 노드의 개수는 무조건 홀수
        // 식 성립 조건 2 : 노드가 N개일 때, 1부터(N/2)번 노드는 문자, (N/2+1)번부터 N번 노드는 수
        for(int T=1;T<=10;T++) {
            flag = 1;
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            for(int i=1;i<=N;i++) {
                st = new StringTokenizer(br.readLine());
                int k = Integer.parseInt(st.nextToken());
                String v = st.nextToken();
                if(v.equals("+") || v.equals("/") || v.equals("-") || v.equals("*")) {
                    arr[k] = 0;
                }else {
                    arr[k] = Integer.parseInt(v);
                }
            }
             
            if(N%2==0) {
                sb.append("#").append(T).append(" 0");
                System.out.println(sb);
                sb.delete(0, sb.length());
                continue;
            }
             
            for(int i=1;i<=N/2;i++) {
                if(arr[i] !=0) {
                    flag = 0;
                }
            }
            for(int i=N/2+1;i<=N;i++) {
                if(arr[i] == 0) {
                    flag = 0;
                }
            }
            sb = new StringBuilder();
            sb.append("#").append(T).append(" ").append(flag);
            System.out.println(sb);
            sb.delete(0, sb.length());
        }
    }
 
}