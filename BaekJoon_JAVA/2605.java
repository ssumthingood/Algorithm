import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class java2605 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int[] number = new int[N+1];
		for(int i=1;i<=N;i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++) {
			if(i == 1) {
				list.add(i);
			}else {
				int size = list.size();
				list.add(size-number[i], i);
			}
		}
		
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");  
		}
	}

}
