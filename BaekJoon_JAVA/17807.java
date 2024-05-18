import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;

    static int[] bros;
    static int answer;

    static BufferedReader br;
    static StringTokenizer st;

    static int gcd(int a, int b){
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        bros = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int newBro = Integer.parseInt(st.nextToken());
            bros[i] = Math.abs(newBro - S);
        }

        if(N == 1){
            System.out.println(bros[0]);
            return;
        }else if(N == 2){
            System.out.println(gcd(bros[0],bros[1]));
            return;
        }

        answer = gcd(bros[0], bros[1]);

        for(int i=2;i<N;i++){
            answer = gcd(answer, bros[i]);
        }

        System.out.println(answer);
    }
}
