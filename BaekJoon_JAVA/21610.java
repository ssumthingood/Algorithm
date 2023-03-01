import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK_21610 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int M;
    static int answer = 0;
    static int[][] board;
    static int[][] dir = {{0, 0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static List<int[]> clouds;
    static List<int[]> newCloud;
    static boolean isIn(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < N);
    }

    static void move(int d, int s) {
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < clouds.size(); i++) {
            int r = clouds.get(i)[0];
            int c = clouds.get(i)[1];
            for (int j = 0; j < s; j++) {
                if (r == N - 1 && r + dir[d][0] == N) {
                    r = 0;
                } else if (r == 0 && r + dir[d][0] == -1) {
                    r = N - 1;
                } else {
                    r = r + dir[d][0];
                }

                if (c == N - 1 && c + dir[d][1] == N) {
                    c = 0;
                } else if (c == 0 && c + dir[d][1] == -1) {
                    c = N - 1;
                } else {
                    c = c + dir[d][1];
                }
            }
            clouds.get(i)[0] = r;
            clouds.get(i)[1] = c;
            board[r][c]++;
            visited[r][c] = true;
        }

        for (int i = 0; i < clouds.size(); i++) {
            int around = 0;
            int r = clouds.get(i)[0];
            int c = clouds.get(i)[1];
            for(int j=2;j<=8; j = j+2){
                if(isIn(r+dir[j][0], c+dir[j][1]) && board[r+dir[j][0]][c+dir[j][1]]>0){
                    around++;
                }
            }
            board[r][c] +=around;
        }

        newCloud = new ArrayList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]>=2 && !visited[i][j]){
                    newCloud.add(new int[]{i,j});
                    board[i][j] -=2;
                }
            }
        }

        clouds = newCloud;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clouds = new ArrayList<>();
        clouds.add(new int[]{N - 1, 0});
        clouds.add(new int[]{N - 1, 1});
        clouds.add(new int[]{N - 2, 0});
        clouds.add(new int[]{N - 2, 1});
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            move(d, s);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += board[i][j];
            }
        }

        System.out.println(answer);
    }

}
