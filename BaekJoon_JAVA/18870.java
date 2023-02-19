import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[] arr;
	static Map<Integer,Integer> map;
	public static void main(String[] args) throws IOException {
		br=  new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sortArr = arr.clone();
		Arrays.sort(sortArr);
		map = new HashMap<>();
		int rank = 0;
		for(int i=0;i<N;i++) {
			if(!map.containsKey(sortArr[i])) {
				map.put(sortArr[i], rank);
				rank++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.println(sb);
	}
}