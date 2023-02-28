import java.io.*;
import java.util.*;

public class Main {
    static class Fish implements Comparable<Fish> {
        int row,col,time;
        public Fish(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        @Override
        public int compareTo(Fish o) {
            if(o.time == this.time) {
                if(o.row == this.row)
                    return this.col - o.col;
                else
                    return this.row - o.row;
            }
            return this.time - o.time;
        }
    }

    static int N, totalFish=0, eatenFish = 0;
    static boolean[][] visited;
    static int[][] map;

    static Fish shark;
    static int sharkSize = 2;

    static ArrayList<Fish> feedList = new ArrayList<>();
    static Queue<Fish> queue = new LinkedList<>();
    static int answer;

    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean isIn(int nr, int nc){
        return(nr>=0 && nr<N && nc >=0 && nc<N);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9) {  // 상어 위치
                    shark = new Fish(i, j, 0);
                    map[i][j] = 0;
                }
                else if(map[i][j] >= 1)
                    totalFish++;
            }
        }

        queue.add(shark);
        visited[shark.row][shark.col] = true;

        while(true) {
            bfs();

            if(!feedList.isEmpty()) {
                eat();
                feedList.clear();
                queue.clear();
                visited = new boolean[N][N];

                queue.add(shark);
                visited[shark.row][shark.col] = true;
            } else {
                break;
            }
        }
        System.out.println(answer);
    }

    public static void bfs() {
        while(!queue.isEmpty()) {
            Fish now = queue.poll();
            int time = now.time;

            for(int i=0; i<4; i++) {
                int nr = now.row + dir[i][0];
                int nc = now.col + dir[i][1];

                if(!isIn(nr,nc) || visited[nr][nc])
                    continue;

                Fish fish = new Fish(nr, nc, time+1);

                if(map[nr][nc]>0 && map[nr][nc]<sharkSize) {
                    queue.add(fish);
                    visited[nr][nc] = true;
                    feedList.add(fish);
                }

                if(map[nr][nc] == 0 || map[nr][nc] == sharkSize) {
                    queue.add(fish);
                    visited[nr][nc] = true;
                }
            }
        }
    }

    public static void eat() {
        Collections.sort(feedList);
        Fish now = feedList.get(0);

        eatenFish++;
        if(eatenFish == sharkSize) {
            sharkSize++;
            eatenFish = 0;
        }
        map[now.row][now.col] = 0;

        shark.row = now.row;
        shark.col = now.col;
        answer += now.time;
    }
}