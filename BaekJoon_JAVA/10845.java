import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>(); 
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int size = queue.size();
			switch(st.nextToken()) {
			case "push":
				int front = Integer.parseInt(st.nextToken());
				queue.add(front);
				break;
			case "pop" :  if(size>0) {
				System.out.println(queue.poll());
				}else {
				System.out.println(-1);
				}break;
			case "size" : System.out.println(size);break;
			case "empty" : if(size>0) {
				System.out.println(0);
				}else {
				System.out.println(1);
				}break;
			case "front" : if(size>0) {
				System.out.println(queue.peek());
				}else {
				System.out.println(-1);
				}
				break;
			case "back" : if(size>0) {
				Object[] myarr = queue.toArray();
				System.out.println(myarr[myarr.length-1]);
				}else {
				System.out.println(-1);
				}
				break; 
			}
		}
	}

}