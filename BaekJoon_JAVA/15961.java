import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int D;
    static int K;
    static int C;
    static int[] sushi;
    static int[] eat;
    static int answer;
    public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    sushi = new int[N];
    eat = new int[D+1];
    for(int i=0;i<N;i++){
        st = new StringTokenizer(br.readLine());
        sushi[i] = Integer.parseInt(st.nextToken());
    }
    int first = 0;
    for(int i=0;i<(K+N)%N;i++) {
    	eat[sushi[i]]++;
    	if(eat[sushi[i]] ==1) {
    		first++;
    	}
    }
    if(eat[C] ==0) {
    	first++;
    }
    answer = first;
    
    for(int i=0;i<N-1;i++) {
    	int formerC = eat[C];
    	eat[sushi[i]]--;
    	if(eat[sushi[i]] ==0) {
    		first--;
    	}
    	
    	int end = (i+K)%N;
    	eat[sushi[end]]++;
    	if(eat[sushi[end]] ==1) {
    		first++;
    	}
    	if(formerC > eat[C] && eat[C]==0) {
    		first++;
    	}else if(formerC == 0 && formerC<eat[C]) {
    		first--;
    	}
    	
    	answer = Math.max(answer, first);
    }
    System.out.println(answer);
    }
}
