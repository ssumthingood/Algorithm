import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int value = Integer.parseInt(st.nextToken());
			if(value !=0) {
				stack.add(value);
				answer +=value;
			}else {
				int minus = stack.pop();
				answer -= minus;
			}
		}
		System.out.println(answer);
	}
}
