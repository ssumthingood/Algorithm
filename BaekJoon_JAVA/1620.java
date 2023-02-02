import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		sb=  new StringBuilder("");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer, String> pokeDex = new HashMap<>();
		Map<String, Integer> pokeDex2 = new HashMap<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String pokeMon = st.nextToken();
			pokeDex.put(i+1, pokeMon);
			pokeDex2.put(pokeMon, i+1);
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			String item = st.nextToken();
			int num = 0;
			if(item.matches("[+-]?\\d*(\\.\\d+)?")){
				num = Integer.parseInt(item);
				sb.append(pokeDex.get(num)+"\n");
			}else {
				sb.append(pokeDex2.get(item)+"\n");
			}
		}
		System.out.println(sb);
	}
}