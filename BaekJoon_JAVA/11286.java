import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br;
	static StringBuilder sb;
	static int N;
	static int target;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			if(Math.abs(o1) == Math.abs(o2)) {
				return Integer.compare(o1, o2);
			}
			else return Integer.compare(Math.abs(o1), Math.abs(o2));
		}
	});
	public static void main(String[] args) throws Exception, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			target = Integer.parseInt(br.readLine());
			if(target ==0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				}else {
					sb.append(pq.poll()).append("\n");
				}
			}else {
				pq.add(target);
			}
		}
		System.out.print(sb);
	}
}
