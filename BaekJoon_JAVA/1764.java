import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=  Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
//		String[] notSeen = new String[N];
//		for(int i=0;i<N;i++) {
//			st = new StringTokenizer(br.readLine());
//			notSeen[i] = st.nextToken();
//		}
//		
//		Queue<String> notSeenHeard = new LinkedList<>();
//		for(int i=0;i<M;i++) {
//			st = new StringTokenizer(br.readLine());
//			String name = st.nextToken();
//			for(int j=0;j<N;j++) {
//				if(name.equals(notSeen[j])) {
//					notSeenHeard.add(name);
//					answer++;
//					break;
//				}
//			}
//		}
//		System.out.println(answer);
//		while(notSeenHeard.size()>0) {
//			System.out.println(notSeenHeard.poll());
//		}//시간초과
		PriorityQueue<String> list = new PriorityQueue<>();
		PriorityQueue<String> answerList = new PriorityQueue<>();
		
		for(int i=0;i<N+M;i++) {
		st = new StringTokenizer(br.readLine());
		list.add(st.nextToken());
		}
		String top = list.poll();
		while(list.size()>0) {
			String now = list.poll();
			if(now.equals(top)) {
				answer++;
				answerList.add(now);
			}
			top = now;
		}
		
		System.out.println(answer);
		while(answerList.size()>0) {
			System.out.println(answerList.poll());
		}
	}

}