import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int M;
	static char[] words;
	static int answer = 0;
	static char out;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		words = new char[N];
		String str = br.readLine();
		for(int i=0;i<N;i++) {
			words[i] = str.charAt(i);
		}
		st = new StringTokenizer(br.readLine());

		int As = Integer.parseInt(st.nextToken());
		int Cs = Integer.parseInt(st.nextToken());
		int Gs = Integer.parseInt(st.nextToken());
		int Ts = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<M;i++) {
			if(words[i] == 'A') {
				As--;
			}else if(words[i]=='C'){
				Cs--;
			}else if(words[i]=='G'){
				Gs--;
			}else if(words[i]=='T'){
				Ts--;
			}
		}
		out = words[0];
		if(As<=0 && Cs<=0 && Gs<=0 && Ts<=0) {
			answer++;
		}
		
		for(int i=1;i<=N-M;i++) {
			switch(out){
			case 'A': As++; break;
			case 'C': Cs++; break;
			case 'G': Gs++; break;
			case 'T': Ts++; break;
			}
			out = words[i];
			switch(words[i+M-1]){
			case 'A': As--; break;
			case 'C': Cs--; break;
			case 'G': Gs--; break;
			case 'T': Ts--; break;
			}
			if(As<=0 && Cs<=0 && Gs<=0 && Ts<=0) {
				answer++;
			}
		}
		System.out.println(answer);		
	}
}
