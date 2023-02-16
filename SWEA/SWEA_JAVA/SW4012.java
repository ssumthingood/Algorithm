import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static int T;
    static int N;
    static int[] list;
    static int[][] board;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++) {
            N = Integer.parseInt(br.readLine());
            list=  new int[N];
            board = new int[N][N];
            for(int i=0;i<N;i++) {
                list[i] = i;
            }
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            makeCombination(new ArrayList<Integer>(), N/2, 0);
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(answer);
            System.out.println(sb);
            answer = Integer.MAX_VALUE;
        }
    }
     
    private static void makeCombination(ArrayList<Integer> a, int quan, int start) {
        if(quan ==0) {
            ArrayList<Integer> b = new ArrayList<>();
             
            for(int i=0;i<N;i++) {
                if(!a.contains(list[i])) b.add(list[i]);
            }
 
            int sumA = getSum(a);
            int sumB = getSum(b);
             
            answer = Math.min(answer, Math.abs(sumA-sumB));
        }
         
        for(int i=start;i<N;i++) {
            a.add(list[i]);
            makeCombination(a,quan-1,i+1);
            a.remove(a.size()-1);
        }
    }
 
    static int getSum(ArrayList<Integer> a) {
        int sum = 0;
        for(int i=0;i<a.size();i++) {
            for(int j=0;j<a.size();j++) {
                sum += board[a.get(i)][a.get(j)];
            }
        }
        return sum;
    }
}