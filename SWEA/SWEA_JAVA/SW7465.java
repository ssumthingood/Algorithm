import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;
    static int M;
    static int T;
    static int[] repres;
    static int answer =0;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            makeSet();
            M = Integer.parseInt(st.nextToken());
            for(int m=0;m<M;m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b); // 친구들 결합
            }
             
            for(int n=1;n<=N;n++) {
                if(findSet(n)==n) {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
            answer = 0;
        }
        System.out.println(sb);
    }
    static void makeSet() {
        repres = new int[N+1];
        for (int n = 1; n <= N; n++) {
            repres[n] = n; // 자기 자신이 대표자다
        }
    }
     
    // findSet : 각 요소가 속한 그룹의 대표자를 반환한다
    static int findSet(int a) {
        if(repres[a] == a) { // 스스로가 대표자인 경우
            return a;
        }else {
            // path compression : a의 대표자를 a가 속한 그룹의 대표자로 변경하기
            return repres [a] = findSet(repres[a]);
        }
    }
     
    // union : 두 조직의 대표자를 합하기
    // 반환값 : 합하기 성공 여부
    static boolean union(int a, int b) {
        // a, b가 속한 그룹의 대표자를 데려오기
        a = findSet(a);
        b = findSet(b);
        //대표자가 이미 같다!
        if(a==b) {
            return false;
        }else {
            repres[a] = b;
            return true;
        }
    }
}