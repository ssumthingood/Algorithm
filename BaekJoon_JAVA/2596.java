import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		String A = "000000";
		String B = "001111";
		String C = "010011";
		String D = "011100";
		String E = "100110";
		String F = "101001";
		String G = "110101";
		String H = "111010";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		String problem = st.nextToken();
		String[] msg = new String[T];
		for(int n=0;n<T;n++) {
			String now = "";
			for(int i=0;i<6;i++) {
				now += problem.charAt(n*6+i);
			}
			msg[n]= now;
		}
		
		finish : for(int i=0;i<T;i++) {
				int different = 9;
				int[] diffs = new int[8];
				for(int j=0;j<6;j++) {
					if(msg[i].charAt(j) != A.charAt(j)) {diffs[0]++;}
					if(msg[i].charAt(j) != B.charAt(j)) {diffs[1]++;}
					if(msg[i].charAt(j) != C.charAt(j)) {diffs[2]++;}
					if(msg[i].charAt(j) != D.charAt(j)) {diffs[3]++;}
					if(msg[i].charAt(j) != E.charAt(j)) {diffs[4]++;}
					if(msg[i].charAt(j) != F.charAt(j)) {diffs[5]++;}
					if(msg[i].charAt(j) != G.charAt(j)) {diffs[6]++;}
					if(msg[i].charAt(j) != H.charAt(j)) {diffs[7]++;}
				}
				for(int j=0;j<8;j++) {
					different = Math.min(different, diffs[j]);
					if(diffs[j] == 0) {
						if(j==0) {sb.append("A"); break;}
						else if(j==1) {sb.append("B"); break;}
						else if(j==2) {sb.append("C"); break;}
						else if(j==3) {sb.append("D"); break;}
						else if(j==4) {sb.append("E"); break;}
						else if(j==5) {sb.append("F"); break;}
						else if(j==6) {sb.append("G"); break;}
						else if(j==7) {sb.append("H"); break;}
					}
				}
				if(different != 0) {
					int flag = 0;
					int flag2 = 0;
					for(int j=0;j<8;j++) {
						if(different == diffs[j]) {
							if(flag ==0) {
								flag++;
								flag2 = j;
							}else if(flag>0) {
								sb.delete(0, sb.length());
								sb.append(i+1);
								break finish;
							}
						}
					}
					if(flag2==0) {sb.append("A");}
					else if(flag2==1) {sb.append("B");}
					else if(flag2==2) {sb.append("C");}
					else if(flag2==3) {sb.append("D");}
					else if(flag2==4) {sb.append("E");}
					else if(flag2==5) {sb.append("F");}
					else if(flag2==6) {sb.append("G");}
					else if(flag2==7) {sb.append("H");}
				}
			}
			System.out.println(sb);

	}
	
}