//PriorityQueue

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class java1715 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		Queue<Integer> queue=  new PriorityQueue<>();
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			queue.add(Integer.parseInt(st.nextToken()));
		}
				
		int answer = 0;
		while(queue.size() >1) {
			int A = queue.poll();
			int B = queue.poll();
			answer +=(A+B);
			queue.add(A+B);
		}
		System.out.println(answer);
	}

}
