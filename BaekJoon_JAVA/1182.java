import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class java1182 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int S;
	static int[] numbers;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		numbers = new int[N];
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			makeCombination(numbers,i, 0 ,new ArrayList<Integer>());
		}
		
		System.out.println(answer);
	}
	
	static void makeCombination(int[] numbers, int need, int idx, ArrayList<Integer> list) {
		if(need==0) {
			StringBuilder sb = new StringBuilder();
			int temp = 0;
			for(int k:list) {
				temp +=k;
			}
			if(temp==S) answer++;
			return;
		}
		
		for(int i=idx;i<N;i++) {
			list.add(numbers[i]);
			makeCombination(numbers, need-1, i+1, list);
			list.remove(list.size()-1);
		}
	}
}
