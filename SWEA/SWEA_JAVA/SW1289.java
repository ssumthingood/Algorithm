import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1289 {
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int j=1;j<=T;j++) {
			String s = br.readLine();
			int answer = 0;
			for(int i=0; i<s.length(); i++) {
				if(i==0) {
					if(s.charAt(i) == '1') answer++;
				} else {
					if(s.charAt(i) != s.charAt(i-1)) answer++;
				}
			}
			
			System.out.println("#" + j + " " + answer);
			answer = 0;
		}
	}

}
