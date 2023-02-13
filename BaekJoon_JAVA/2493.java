import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static Stack<Integer> stack;
	static List<Integer> list;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		stack = new Stack<Integer>();
		list = new ArrayList<Integer>();
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++){
			if(stack.isEmpty()) {
				list.add(0);
				stack.push(i);
			}else {
				if(arr[stack.peek()] >arr[i]) {
					list.add(stack.peek());
					stack.add(i);
				}else {
					stack.pop();
					i--;
				}
			}
		}

		sb = new StringBuilder();
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}
}
