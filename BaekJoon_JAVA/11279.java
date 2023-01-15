import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class java11279 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		Queue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			if(order ==0) {
				if(pQueue.size()>0) {
					System.out.println(pQueue.poll());
				}else {
					System.out.println(0);
				}
			}else {
				pQueue.add(order);
			}
		}
	}

}

//Priority Queue 역순 입력 - Collections.ReverseOrder()