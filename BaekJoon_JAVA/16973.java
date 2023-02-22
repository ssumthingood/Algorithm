import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int R;
    static int C;
    static int H;
    static int W;
    static int startR;
    static int startC;
    static int endR;
    static int endC;
    static int[][] board;
    static boolean[][] visited;
    static List<int[]> list;
    static int answer = -1;
    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static Queue<int[]> q;

    static boolean isIn(int r, int c) {
        return (r > 0 && r <= R && c > 0 && c <= C && r + H - 1 <= R && c + W - 1 <= C);
    }

    static boolean canGo(int r, int c) {
        for(int i=0;i<list.size();i++){
            int[] block = list.get(i);
            int br = block[0];
            int bc = block[1];
            if(br >= r && br <= r+H-1 && bc >= c && bc <= c+W-1) {
                return false;
            }
        }
        return true;
    }

    static boolean canVisit(int r, int c) {
        boolean can = visited[r][c];
        return !can;
    }

    static void bfs(int r, int c) {
        q.add(new int[] { r, c, 0 });
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] loc = q.poll();
            if (loc[0] == endR && loc[1] == endC) {
                answer = loc[2];
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nextR = loc[0] + dir[i][0];
                int nextC = loc[1] + dir[i][1];

                if (isIn(nextR, nextC) && canGo(nextR, nextC) && canVisit(nextR, nextC)) {
                    visited[nextR][nextC] = true;
                    q.add(new int[] { nextR, nextC, loc[2] + 1 });
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        board = new int[R + 1][C + 1];
        visited = new boolean[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] ==1 ){
                    list.add(new int[]{i,j});
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        startR = Integer.parseInt(st.nextToken());
        startC = Integer.parseInt(st.nextToken());
        endR = Integer.parseInt(st.nextToken());
        endC = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        if(!canGo(endR, endC)) {
            System.out.println(answer);
            return;
        }else {
            bfs(startR, startC);
            System.out.println(answer);
        }
    }
}