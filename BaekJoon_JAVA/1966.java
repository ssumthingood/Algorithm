import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T=  Integer.parseInt(st.nextToken());
		
		for(int i=0;i<T;i++) {
			int answer=0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Doc> pq = new PriorityQueue<>();
			Queue<Doc> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				Doc doc = new Doc(j, Integer.parseInt(st.nextToken()));
				pq.add(doc);
				q.add(doc);
			}
			
			while(q.size()>0) {
				int qpri = q.peek().priority;
				int pqpri = pq.peek().priority;
				if(qpri == pqpri) {
					pq.poll();
					Doc out = q.poll();
					answer++;
					if(out.idx == num) {
						break;
					}
				}else {
					q.offer(q.poll());
				}
			}
			System.out.println(answer);
		}
	}

}

class Doc implements Comparable<Doc> {
	int idx;
	int priority;
	public Doc(int idx, int priority) {
		this.idx = idx;
		this.priority = priority;
	}
	@Override
	public int compareTo(Doc d) {
		// TODO Auto-generated method stub
		return d.priority - this.priority;
	}
	
}