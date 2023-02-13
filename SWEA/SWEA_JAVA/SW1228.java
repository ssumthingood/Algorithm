import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int M;
    static int X;
    static int Y;
    static List<Integer> list;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        for(int T=1;T<=10;T++) {
            N = Integer.parseInt(br.readLine());
            list=  new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++) {
                st.nextToken();
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                for(int j=0;j<Y;j++) {
                    list.add(X++, Integer.parseInt(st.nextToken()));
                }
            }
            sb = new StringBuilder();
            sb.append("#").append(T).append(" ");
            for(int i=0;i<10;i++) {
                sb.append(list.get(i)).append(" ");
            }
            System.out.println(sb);
        }
    }
}
