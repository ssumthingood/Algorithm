import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		int tallest = 0;
		int answer =0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			stack.add(K);
		}
		
		while(!stack.isEmpty()) {
			int out = stack.pop();
			if(out >tallest) {
				tallest = out;
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}