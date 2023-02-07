import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2805 {
	static BufferedReader br;
	static StringTokenizer st;
	static int T;
	static int N;
	static int[][] farm;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int i=1;i<=T;i++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			farm = new int[N][N];
			for(int j=0;j<N;j++) {
				String str = br.readLine();
				for(int k=0;k<N;k++) {
					farm[j][k] = str.charAt(k)-'0';
				}
			}
			
			if(N==1) {
				answer = farm[0][0];
				System.out.println("#"+i+" "+answer);
				continue;
			}else {
				for(int j=(N-1)/2-1;j>=0;j--) {
					for(int k=(N-1)/2-j;k<=N+j-(N+1)/2;k++) {
						System.out.println(j+","+k);
						answer+=farm[j][k];
					}
				}
				for(int j=0;j<N;j++) {
					System.out.println((N-1)/2+","+j);
					answer+=farm[(N-1)/2][j];
				}
				for(int j=(N-1)/2+1;j<N;j++) {
					for(int k=j-(N-1)/2;k<N-j+(N-1)/2;k++) {
						System.out.println(j+","+k);
						answer+=farm[j][k];
					}
				}	
			}
			System.out.println("#"+i+" "+answer);
		}
	}

}
