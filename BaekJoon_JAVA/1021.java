import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		Queue<Integer> target=  new LinkedList<>();
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			list.add(i);
		}
		for(int i=0;i<M;i++) {
			target.add(Integer.parseInt(st.nextToken())-1);
		}
		
		while(target.size()>0) {
			int T = target.peek();
			int where = list.indexOf(T);
//			System.out.println(T+"찾기");
			if(where == 0) {
				list.remove(0);
				target.poll();
			}
			else if(where < list.size()-where) {
				Collections.rotate(list, -1*where);
//				System.out.println(where+"만큼 왼쪽 돌리기");
				list.remove(0);
				answer +=where;
				target.poll();
			}else if(where >= list.size()-where){
				Collections.rotate(list, (list.size()-where));
//				System.out.println((list.size()-where)+"만큼 오른쪽 돌리기");
				answer +=(list.size()-where);
				list.remove(0);
				target.poll();
			}
		}
		System.out.println(answer);
	}

}