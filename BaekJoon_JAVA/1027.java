import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static double[] b;
	static double[][] d;
	static int max = 0;

	public static void main(String[] args) throws Exception, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		b = new double[N];
		d = new double[N][N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			b[i] = Double.parseDouble(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			int answerL = 0;
			int answerR = 0;
			double comp = -1000000000;
			for(int j = i-1;j>=0;j--) {
//				System.out.println("기울기 : "+ comp + "/" +(b[j]-b[i])/(double)(i-j));
				if(comp<(b[j]-b[i])/(double)(i-j)) {
					answerL++;
					comp = (b[j]-b[i])/(double)(i-j);
				}
			}
//			System.out.println(i+"에서 왼쪽"+answerL);
			comp = -1000000000;
			for(int j=i+1;j<N;j++) {
//				System.out.println("기울기 : "+ comp + "/" +(b[j]-b[i])/(double)(j-i));
				if(comp<(b[j]-b[i])/(double)(j-i)) {
					answerR++;
					comp = (b[j]-b[i])/(double)(j-i);
				}
			}
//			System.out.println(i+"에서 오른쪽"+answerR);
			max = Math.max(max, answerL+answerR);
		}
		System.out.println(max);
	}
}