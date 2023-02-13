import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static void makeCombination(ArrayList<Character> list, int n, int start, int jaum, int moum) {
    	if(n==0) {
    		if(jaum >0 || moum>0) return;
    		
    		for(int i=0;i<list.size();i++) {
    			sb.append(list.get(i));
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	for(int i=start;i<arr.length;i++) {
    		if(arr[i] == 'a' || arr[i] == 'e' ||arr[i] == 'i' ||arr[i] == 'o' ||arr[i] == 'u') {
    			list.add(arr[i]);
    			makeCombination(list, n-1, i+1, jaum, moum-1);
    			list.remove(list.size()-1);    			
    		}else {
    			list.add(arr[i]);
    			makeCombination(list, n-1, i+1, jaum-1, moum);
    			list.remove(list.size()-1);  
    		}
    	}
    }
    
    static char[] arr;
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int L;
	static int C;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		StringBuilder str = new StringBuilder();
		for(int i=0;i<C;i++) {
			str.append(st.nextToken());
		}
		String myStr = str.toString();
		for(int i=0;i<C;i++) {
			arr[i] = myStr.charAt(i);
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		makeCombination(new ArrayList<Character>(), L,0,2,1);
		System.out.print(sb);
	}
}