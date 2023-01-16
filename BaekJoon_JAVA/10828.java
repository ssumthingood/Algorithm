import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>(); 
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int size = stack.size();
			switch(st.nextToken()) {
			case "push":
				int front = Integer.parseInt(st.nextToken());
				stack.push(front);
				break;
			case "pop" :  if(size>0) {
				System.out.println(stack.pop());
				}else {
				System.out.println(-1);
				}break;
			case "size" : System.out.println(size);break;
			case "empty" : if(stack.empty()==false) {
				System.out.println(0);
			} else {
				System.out.println(1);
				};
			break;
			case "top" : if(size>0) {
				System.out.println(stack.peek());
				}else {
				System.out.println(-1);
				}
				break;
			}
		}
	}

}