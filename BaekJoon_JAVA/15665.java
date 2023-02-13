import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static void makePermutationDup(ArrayList<Integer> list, int n) {
    	if(n==0) {
    		for(int i=0;i<list.size();i++) {
    			sb.append(list.get(i)).append(" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	for(int i=0;i<arr.length;i++) {
    		if(i>0 && arr[i]==arr[i-1]) {
    			continue;
    		}
    		list.add(arr[i]);
    		makePermutationDup(list, n-1);
    		list.remove(list.size()-1);
    	}
    }
    
    static int[] arr;
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		makePermutationDup(new ArrayList<Integer>(), M);
		System.out.println(sb);
	}
}
