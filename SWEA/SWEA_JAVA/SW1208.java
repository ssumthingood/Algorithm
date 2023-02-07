import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1208 {
	static BufferedReader br;
	static StringTokenizer st;
	static int cases = 1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while(str != null) {
			int answer = 0;
			st = new StringTokenizer(str);
			int K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[101];
			while(st.hasMoreTokens()) {
				arr[Integer.parseInt(st.nextToken())] += 1;
			}
			int start =1;
			int end =100;
			for(int i=1;i<=50;i++) {
				if(arr[i] != 0) {start = i; break;}
			}
			
			for(int j=100;j>50;j--) {
				if(arr[j] != 0) {end = j; break;}
			}
			
			for(int i=0;i<K;i++) {
				if(start == end) break;
				
				arr[start] -=1;
				arr[start+1] +=1;
				arr[end] -=1;
				arr[end-1] +=1;
				
				
				if(arr[start] ==0) {
					start++;
				}
				if(arr[end] ==0) {
					end--;
				}
			}
			
			answer = end-start;
			
			System.out.println("#"+cases+" "+answer);
			cases++;
			str = br.readLine();
		}
	}

}
