import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long answer = 0;

    static int[] rope;

    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        rope = new int[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            rope[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(rope);

        for(int i=0;i<N;i++){
            long result = rope[i] * (N-i);
            if(result >answer){
                answer = result;
            }
        }

        System.out.println(answer);
    }
}
