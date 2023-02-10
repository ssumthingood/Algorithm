import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static String str;
    static int[] password;
    static int T;
    static Deque<Integer> q;
    static StringBuilder sb;
 
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        for (int P = 1; P <= 10; P++) {
            str = br.readLine();
            T = Integer.parseInt(str);
            st = new StringTokenizer(br.readLine());
            q = new LinkedList<Integer>();
            int flag = 1;
            for (int i = 0; i < 8; i++) {
                q.add(Integer.parseInt(st.nextToken()));
            }
 
            while (q.getLast() > 0) {
                q.add(q.poll() - flag);
                flag++;
                if (flag == 6)
                    flag = 1;
            }
            sb = new StringBuilder();
            sb.append("#").append(T);
            for (int i = 0; i < 7; i++) {
                sb.append(" ").append(q.poll());
            }
            sb.append(" 0");
            System.out.println(sb);
        }
    }
}