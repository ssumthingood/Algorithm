import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1238 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int answer;
    static int N;
    static int Start;
    static boolean[][] board;
    static boolean[] visited;
    static void bfs(int Start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{Start, 0});
        visited[Start] = true;
        int depth = 0;
        while(!q.isEmpty()){
            int[] target = q.poll();
            if(depth < target[1]){
                depth = target[1];
                answer = target[0];
            }else if(depth == target[1]){
                answer = Math.max(answer, target[0]);
            }
            for(int i=1;i<=100;i++){
                if(board[target[0]][i] == true && !visited[i]){
                    visited[i] = true;
                    q.add(new int[]{i, target[1]+1});
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        for(int t=1;t<=10;t++){
            board = new boolean[101][101];
            visited = new boolean[101];
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            Start = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i = i+2){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                board[from][to] = true;
            }
            bfs(Start);
            sb.append(answer).append("\n");
            answer = 0;
        }
        System.out.print(sb);
    }

}
