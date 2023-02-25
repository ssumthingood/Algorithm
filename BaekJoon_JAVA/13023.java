import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static boolean[] visited;
	static List<List<Integer>> personList;
	static int N;
	static int M;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		personList = new ArrayList<List<Integer>>();
		for(int i=0;i<N;i++) {
			personList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			personList.get(r).add(c);
			personList.get(c).add(r);
		}
//		
//		for (int i = 0; i < N; i++) {
//			System.out.print(i+"의 인접 리스트");
//			for(int j=0;j<personList.get(i).size();j++) {
//				System.out.print(personList.get(i).get(j)+" ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			if(dfs(1, i))
				break;
			visited[i] = false;
		}

		if (flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static boolean dfs(int depth, int now) {
		if (depth == 5) {
			flag = true;
			return true;
		}
		
//		Iterator<Integer> iter = personList.get(now).iterator();
//		
//		while(iter.hasNext()) {
//			int next = iter.next();
//			if(!visited[next]) {
//				visited[next] = true;
//				dfs(depth + 1, next);
//				visited[next] = false;
//			}
//		}
		
		for (int i = 0; i < personList.get(now).size(); i++) {
			if (!visited[personList.get(now).get(i)]) {
				visited[personList.get(now).get(i)] = true;
				if(dfs(depth + 1, personList.get(now).get(i)))
					return true;
				visited[personList.get(now).get(i)] = false;
			}
		}
		return false;
	}

}
