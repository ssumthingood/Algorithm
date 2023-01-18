import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class java11866 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');

		while(q.size() > 1) {
			
			for(int i = 0; i < K - 1; i++) {
				q.offer(q.poll());
			}
			
			sb.append(q.poll()).append(", ");
		}
 
		// 마지막 원소 출력한 뒤 > 도 붙여준다.
		sb.append(q.poll()).append('>');
		System.out.println(sb);
	}
	//난이도에 비해 너무 어렵게 생각ㅠㅠ
}