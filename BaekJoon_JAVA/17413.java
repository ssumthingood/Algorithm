import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static StringBuilder tempsb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		String k = br.readLine().toString();
		char[] mychar = k.toCharArray();
		boolean reverse = true;
		sb= new StringBuilder("");
		tempsb = new StringBuilder("");
		
		for(char i : mychar) {
			if(i ==' ') {
				if(reverse == true) {
					sb.append(tempsb.reverse().toString());
					tempsb.delete(0, tempsb.length());
					sb.append(i);
				}else if(reverse == false){
					sb.append(tempsb.toString());
					tempsb.delete(0, tempsb.length());
					sb.append(i);
				}
			}else if(i == '<') {
				sb.append(tempsb.reverse().toString());
				tempsb.delete(0, tempsb.length());
				sb.append(i);
				reverse = false;
			}else if(i == '>') {
				sb.append(tempsb.toString());
				sb.append(i);
				tempsb.delete(0, tempsb.length());
				reverse = true;
			}else {
				tempsb.append(i);
			}
		}
		if(reverse == true) {
			sb.append(tempsb.reverse().toString());
		}else if(reverse == false){
			sb.append(tempsb.toString());
		}
		
		System.out.println(sb.toString());
	}

}
