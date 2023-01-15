import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java9012 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			String[] myLine = line.split("");
			 int flag = 0;
			for(int j=0;j<myLine.length;j++) {
				if(myLine[j].equals("(")){
					 flag++;
				}else if(myLine[j].equals(")")) {
					flag--;
					if(flag <0) break;
				}
			}
			String answer = "";
			if(flag == 0) {
				answer = "YES";
			}else answer = "NO";
			System.out.println(answer);
		}
	}

}
