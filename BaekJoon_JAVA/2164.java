import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class java2164 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<N;i++) {
			queue.add(i+1);
		}
		
		while(queue.size() > 1) {
			queue.poll();
			queue.add(queue.poll());
		}
		
		System.out.println(queue.poll());
	}

}
