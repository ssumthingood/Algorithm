import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int T;
    static int[] gyu;
    static ArrayList<Integer> in;
    static StringBuilder sb;
    static int win = 0;
    static int lose = 0;
    static boolean[] visited;
 
    static void makePermutation(int[] per, int start) {
        if (start == 9) {
            int gyuSum = 0;
            int inSum = 0;
            for (int i = 0; i < 9; i++) {
                if (gyu[i] > per[i]) {
                    gyuSum += gyu[i] + per[i];
                } else {
                    inSum += gyu[i] + per[i];
                }
            }
            if (gyuSum > inSum) {
                win++;
            } else if (gyuSum < inSum) {
                lose++;
            }
 
        }
        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                per[start] = in.get(i);
                makePermutation(per, start+1);
                visited[i] = false;
            }
        }
    }
 
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            gyu = new int[9];
            in = new ArrayList<Integer>();
            visited = new boolean[9];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                gyu[i]= (Integer.parseInt(st.nextToken()));
            }
 
            for (int i = 1; i <= 18; i++) {
                boolean flag = true;
                for(int j=0;j<9;j++) {
                    if(i==gyu[j]) flag = false;
                }
                if(flag) in.add(i);
            }
 
            makePermutation(new int[9], 0);
 
            sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
            win = 0;
            lose = 0;
        }
        System.out.print(sb);
    }
}