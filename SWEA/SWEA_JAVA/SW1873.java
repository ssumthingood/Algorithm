import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int T;
    static int R;
    static int C;
    static int N;
    static int nowR;
    static int nowC;
    static char[][] board;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static char[] tank = {'^','v','<','>'};
    static char[] order;
    static StringBuilder sb;
    private static void play(char c) {
        switch (c){
            case 'U' : goUp(); break;
            case 'D' : goDown(); break;
            case 'L' : goLeft(); break;
            case 'R' : goRight(); break;
            case 'S' : shoot(); break;
        }
    }
 
    static void goUp() {
        board[nowR][nowC] = tank[0];
        int newR = nowR+dir[0][0];
        int newC = nowC+dir[0][1];
        if(isIn(newR, newC) && noObstacle(newR, newC)){
            board[newR][newC] = board[nowR][nowC];
            board[nowR][nowC] = '.';
            nowR = newR;
            nowC = newC;
        }
    }
    static void goDown() {
        board[nowR][nowC] = tank[1];
        int newR = nowR+dir[1][0];
        int newC = nowC+dir[1][1];
        if(isIn(newR, newC) && noObstacle(newR, newC)){
            board[newR][newC] = board[nowR][nowC];
            board[nowR][nowC] = '.';
            nowR = newR;
            nowC = newC;
        }
    }
    static void goLeft() {
        board[nowR][nowC] = tank[2];
        int newR = nowR+dir[2][0];
        int newC = nowC+dir[2][1];
        if(isIn(newR, newC) && noObstacle(newR, newC)){
            board[newR][newC] = board[nowR][nowC];
            board[nowR][nowC] = '.';
            nowR = newR;
            nowC = newC;
        }
    }
    static void goRight() {
        board[nowR][nowC] = tank[3];
        int newR = nowR+dir[3][0];
        int newC = nowC+dir[3][1];
        if(isIn(newR, newC) && noObstacle(newR, newC)){
            board[newR][newC] = board[nowR][nowC];
            board[nowR][nowC] = '.';
            nowR = newR;
            nowC = newC;
        }
    }
    static void shoot() {
        int shootR = nowR;
        int shootC = nowC;
        if(board[nowR][nowC] == tank[0]){
            while(isIn(shootR, shootC)){
                if(board[shootR][shootC] == '#'){
                    break;
                }else if(board[shootR][shootC] == '*'){
                    board[shootR][shootC] = '.';
                    break;
                }
                shootR = shootR+dir[0][0];
                shootC = shootC+dir[0][1];
            }
        }else if(board[nowR][nowC] == tank[1]){
            while(isIn(shootR, shootC)){
                if(board[shootR][shootC] == '#'){
                    break;
                }else if(board[shootR][shootC] == '*'){
                    board[shootR][shootC] = '.';
                    break;
                }
                shootR = shootR+dir[1][0];
                shootC = shootC+dir[1][1];
            }
        }else if(board[nowR][nowC] == tank[2]){
            while(isIn(shootR, shootC)){
                if(board[shootR][shootC] == '#'){
                    break;
                }else if(board[shootR][shootC] == '*'){
                    board[shootR][shootC] = '.';
                    break;
                }
                shootR = shootR+dir[2][0];
                shootC = shootC+dir[2][1];
            }
        }else if(board[nowR][nowC] == tank[3]){
            while(isIn(shootR, shootC)){
                if(board[shootR][shootC] == '#'){
                    break;
                }else if(board[shootR][shootC] == '*'){
                    board[shootR][shootC] = '.';
                    break;
                }
                shootR = shootR+dir[3][0];
                shootC = shootC+dir[3][1];
            }
        }
 
    }
 
    private static boolean isIn(int r, int c){
        return (r>=0 && r<R && c>=0 && c<C);
    }
 
    private static boolean noObstacle(int r, int c){
        return (board[r][c] =='.');
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int t=1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            board = new char[R][C];
            for(int i=0;i<R;i++){
                String str = br.readLine();
                for(int j=0;j<C;j++){
                    board[i][j] = str.charAt(j);
                    if(board[i][j] == '^' || board[i][j]== 'v' || board[i][j]=='<' || board[i][j] == '>'){
                        nowR = i;
                        nowC = j;
                    }
                }
            }
            N = Integer.parseInt(br.readLine());
            String orders = br.readLine();
            order = new char[N];
            for(int i=0;i<N;i++){
                order[i] = orders.charAt(i);
            }
 
            for(int i=0;i<N;i++){
                play(order[i]);
            }
            sb.append("#").append(t).append(" ");
            for(int i=0;i<R;i++){
                for(int j=0;j<C;j++){
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
 
}