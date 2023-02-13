import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static void makeCombination(ArrayList<Integer> list, int n, int start) {
    	if(n==0) {
    		StringBuilder str = new StringBuilder();
    		for(int i=0;i<list.size();i++) {
    			str.append(list.get(i)).append(" ");
    		}
    		if(!mainList.contains(str.toString())) {
        		mainList.add(str.toString());	
    		}
    	}
    	
    	for(int i=start;i<arr.length;i++) {
    		list.add(arr[i]);
    		makeCombination(list, n-1, i+1);
    		list.remove(list.size()-1);
    	}
    }
    
    static int[] arr;
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N;
	static int M;
	static List<String> mainList;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		mainList = new ArrayList<String>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		makeCombination(new ArrayList<Integer>(), M,0);
		sb = new StringBuilder();
		for(int i=0;i<mainList.size();i++) {
			sb.append(mainList.get(i));
			sb.append("\n");			
		}
		System.out.println(sb);
	}
}