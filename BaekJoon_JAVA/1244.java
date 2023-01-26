import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static void move(int[] arr, int gen, int num) {
		int start = num;
		int end = num;
		switch(gen) {
		case 1: 
			for(int i=1;i<=arr.length-1;i++) {
				if(i%num ==0) {
					if(arr[i]==0) {
						arr[i]=1;
					}else arr[i]=0;
				}
			}
			break;
		case 2 :
			while(start>1 && end <arr.length-1) {
				if(arr[start-1] == arr[end+1]) {
					start--;
					end++;
				}else break;
			}
			for(int i=start;i<=end;i++) {
				if(arr[i] ==1) {
					arr[i] = 0;
				}else {
					arr[i] = 1;
				}
			}
			break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N=  Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int gen = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			move(arr, gen, num);
		}
		for(int i=1; i<=N;i++) {
			System.out.print(arr[i]+" ");
			if(i%20 ==0) {
				System.out.println("");
			}
		}

	}

}