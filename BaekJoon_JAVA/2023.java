import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static boolean isPrime(int target) {
		if(target==0||target==1) return false;
		if(target==2) return true;
		for(int i=2;i<=(int) Math.ceil(Math.sqrt(target));i++) {
			if(target%i ==0) return false;
		}
		return true;
	}

	static void backTrack(int n, int num) {
		if(n== N) {
			list.add(num);
			return;
		}else if(n==0) {
			for(int i=1;i<=9;i++) {
				if(isPrime(num*10+i)) backTrack(n+1,num*10+i);
			}
		}else {
			for(int i=0;i<=9;i++) {
				if(isPrime(num*10+i)) backTrack(n+1,num*10+i);
			}
		}
	}
	
	static BufferedReader br;
	static int N;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		backTrack(0,0);
		Collections.sort(list);
		for(int item:list) {
			sb.append(item).append("\n");
		}
		System.out.println(sb);
	}
}