import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		Deque<Integer> dq = new ArrayDeque<>(); 
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int size = dq.size();
			switch(st.nextToken()) {
			case "push_front":
				int front = Integer.parseInt(st.nextToken());
				dq.addFirst(front);
				break;
			case "push_back" : 
				int back = Integer.parseInt(st.nextToken());
				dq.addLast(back);
				break;
			case "pop_front" :  if(size>0) {
				System.out.println(dq.pollFirst());
				}else {
				System.out.println(-1);
				}break;
			case "pop_back" : if(size>0) {
				System.out.println(dq.pollLast());
				}else {
				System.out.println(-1);
				} break;
			case "size" : System.out.println(size);break;
			case "empty" : if(size>0) {
				System.out.println(0);
				}else {
				System.out.println(1);
				}break;
			case "front" : if(size>0) {
				System.out.println(dq.getFirst());
				}else {
				System.out.println(-1);
				}
				break;
			case "back" : if(size>0) {
				System.out.println(dq.getLast());
				}else {
				System.out.println(-1);
				}
				break; 
			}
		}
	}

}