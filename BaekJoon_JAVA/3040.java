import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br;
	static int[] arr;
	static void makeCombination(int nthChoice, int[] myArr, int start) {
		if(nthChoice==7) {
			int sum = 0;
			for(int i=0;i<7;i++) {
				sum +=myArr[i];
			}
			if(sum==100) {
				for(int i=0;i<7;i++) {
					System.out.println(myArr[i]);
				}
			}else return;
		}else {
			
			for(int i=start;i<9;i++) {
				myArr[nthChoice] = arr[i];
				makeCombination(nthChoice+1, myArr, i+1);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		makeCombination(0,new int[7], 0);
	}
}