import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[][] board;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int answer = 0;
    static boolean isIn(int r, int c) {
        return (r>=0 && r<N && c<N && c>=0);

    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                board[i][j]=  Integer.parseInt(st.nextToken());
            }
        }

        dfs(board,0);
        System.out.println(answer);
    }

    static void dfs(int[][] board, int index) {
        if(index == 5) {
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    answer = Math.max(answer, board[i][j]);
                }
            }

//            for(int i=0;i<N;i++){
//                for(int j=0;j<N;j++){
//                    System.out.print(board[i][j]);
//                    System.out.print(" ");
//                }
//                System.out.println();
//            }

            return;
        }

        int[][] temp = new int[N][N];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                temp[i][j] = board[i][j];
            }
        }

        int[][] temp1 = up(temp);
        dfs(temp1, index+1);

        int[][] temp2 = down(temp);
        dfs(temp2, index+1);

        int[][] temp3 = left(temp);
        dfs(temp3, index+1);

        int temp4[][] = right(temp);
        dfs(temp4, index+1);
    }

    static int[][] up(int[][] board) {
//        System.out.println("up");
        int[][] temp = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                temp[i][j] = board[i][j];
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(temp[i][j] >0 ) {
                    int r=i;
                    int c=j;
                    while(isIn(r+dir[0][0],c+dir[0][1])) {
                        if(temp[r+dir[0][0]][c+dir[0][1]]>0) break;
                        r = r + dir[0][0];
                        c = c + dir[0][1];
                    }

                    if(r != i){
                        temp[r][c] = temp[i][j];
                        temp[i][j] = 0;
                    }

                    if(isIn(r+dir[0][0],c+dir[0][1]) && !visited[r+dir[0][0]][c+dir[0][1]] &&temp[r+dir[0][0]][c+dir[0][1]] == temp[r][c] ){
                        temp[r+dir[0][0]][c+dir[0][1]] *=2;
                        temp[r][c] =0;
                        visited[r+dir[0][0]][c+dir[0][1]]= true;
                    }
                }
            }
        }
        return temp;
    }

    static int[][] down(int[][] board) {
//        System.out.println("down");
        int[][] temp = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for(int i=N-1;i>=0;i--) {
            for(int j=0;j<N;j++) {
                temp[i][j] = board[i][j];
            }
        }

        for(int i=N-1;i>=0;i--) {
            for(int j=0;j<N;j++) {
                if(temp[i][j] >0 ) {
                    int r=i;
                    int c=j;
                    while(isIn(r+dir[1][0],c+dir[1][1])) {
                        if(temp[r+dir[1][0]][c+dir[1][1]]>0) break;
                        r = r + dir[1][0];
                        c = c + dir[1][1];
                    }

                    if(r !=i) {
                        temp[r][c] = temp[i][j];
                        temp[i][j] = 0;
                    }
                    if(isIn(r+dir[1][0],c+dir[1][1]) && !visited[r+dir[1][0]][c+dir[1][1]] &&temp[r+dir[1][0]][c+dir[1][1]] == temp[r][c] ){
                        temp[r+dir[1][0]][c+dir[1][1]] *=2;
                        temp[r][c] =0;
                        visited[r+dir[1][0]][c+dir[1][1]]= true;
                    }
                }
            }
        }
        return temp;
    }

    static int[][] left(int[][] board) {
//        System.out.println("left");

        int[][] temp = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                temp[i][j] = board[i][j];
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(temp[j][i] >0 ) {
                    int r=j;
                    int c=i;
                    while(isIn(r+dir[2][0],c+dir[2][1])) {
                        if(temp[r+dir[2][0]][c+dir[2][1]]>0) break;
                        r = r + dir[2][0];
                        c = c + dir[2][1];
                    }

                    if(c !=i){
                        temp[r][c] = temp[j][i];
                        temp[j][i] = 0;
                    }
                    if(isIn(r+dir[2][0],c+dir[2][1]) && !visited[r+dir[2][0]][c+dir[2][1]] &&temp[r+dir[2][0]][c+dir[2][1]] == temp[r][c] ){
                        temp[r+dir[2][0]][c+dir[2][1]] *=2;
                        temp[r][c] =0;
                        visited[r+dir[2][0]][c+dir[2][1]]= true;
                    }
                }
            }
        }
        return temp;
    }

    static int[][] right(int[][] board) {
//        System.out.println("right");

        int[][] temp = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                temp[i][j] = board[i][j];
            }
        }

        for(int i=N-1;i>=0;i--) {
            for(int j=0;j<N;j++) {
                if(temp[j][i] >0 ) {
                    int r=j;
                    int c=i;
                    while(isIn(r+dir[3][0],c+dir[3][1])) {
                        if(temp[r+dir[3][0]][c+dir[3][1]]>0) break;
                        r = r + dir[3][0];
                        c = c + dir[3][1];
                    }
                    if(c !=i){
                        temp[r][c] = temp[j][i];
                        temp[j][i] = 0;
                    }
                    if(isIn(r+dir[3][0],c+dir[3][1]) && !visited[r+dir[3][0]][c+dir[3][1]] &&temp[r+dir[3][0]][c+dir[3][1]] == temp[r][c] ){
                        temp[r+dir[3][0]][c+dir[3][1]] *=2;
                        temp[r][c] =0;
                        visited[r+dir[3][0]][c+dir[3][1]]= true;
                    }
                }
            }
        }
        return temp;
    }

}