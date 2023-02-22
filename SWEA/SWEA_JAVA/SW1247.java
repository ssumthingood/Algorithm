import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int T;
    static int N;
    static int[] company;
    static int[] home;
    static int[][] gogek;
    static boolean[] visited;
    static int answer;
    static StringBuilder sb;
    static int getMan(int r, int c, int tr, int tc) {
        return Math.abs(r-tr)+Math.abs(c-tc);
    }
     
    static void makePermutation(int[][] permutation, int depth) {
        if(depth ==N) {
            int sum = 0;
            int r = company[0];
            int c = company[1];
            for(int i=0;i<N;i++) {
                sum +=getMan(r,c,permutation[i][0],permutation[i][1]);
                r = permutation[i][0];
                c = permutation[i][1];
            }
            sum +=getMan(r,c,home[0],home[1]);
             
            answer = Math.min(sum, answer);
        }
         
        for(int i=0;i<N;i++) {
            if(!visited[i]) {
                permutation[depth][0] = gogek[i][0];
                permutation[depth][1] = gogek[i][1];
                visited[i] = true;
                makePermutation(permutation, depth+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int t=1;t<=T;t++) {
            answer = Integer.MAX_VALUE;
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            company = new int[2];
            home = new int[2];
            gogek = new int[N][2];
            visited = new boolean[N];
            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            for(int i=0;i<N;i++) {
                gogek[i][0] = Integer.parseInt(st.nextToken());
                gogek[i][1] = Integer.parseInt(st.nextToken());
            }
             
            makePermutation(new int[N][2], 0);
             
            sb.append(answer).append("\n");
            answer =0;
        }
        System.out.print(sb);
    }
 
}