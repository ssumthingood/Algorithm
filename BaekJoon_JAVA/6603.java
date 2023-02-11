import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static String str;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		while(!str.equals("0")) {
			st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken());
			numbers = new int[N];
			for(int i=0;i<N;i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			makeCombination(numbers, 6, 0, new ArrayList<Integer>());
			System.out.println("");
			str = br.readLine();
		}
	}
	
	static void makeCombination(int[] numbers, int need, int idx, ArrayList<Integer> list) {
		if(need==0) {
			StringBuilder sb = new StringBuilder();
			for(int k:list) {
				sb.append(k).append(" ");
			}
			sb.append("\n");
			System.out.print(sb);
			return;
		}
		
		for(int i=idx;i<N;i++) {
			list.add(numbers[i]);
			makeCombination(numbers, need-1, i+1, list);
			list.remove(list.size()-1);
		}
	}
}