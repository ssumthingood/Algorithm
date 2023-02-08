import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static void makeCombination(ArrayList<Integer> list, int n, int start) {
    	if(n==0) {
    		for(int i=0;i<list.size();i++) {
    			System.out.print(list.get(i)+" ");
    		}
    		System.out.println("");
    	}
    	
    	for(int i=start;i<arr.length;i++) {
    		// 조합은 순열과 달리 다음 재귀의 범위가 넣은 원소 뒤쪽으로 좁혀지므로
    		// 리스트가 해당 원소를 가지고 있는지 여부를 확인할 필요가 없다.
    		list.add(arr[i]);
    		makeCombination(list, n-1, i+1);
    		list.remove(list.size()-1);
    	}
    }
    
    static int[] arr;
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int M;
	
	// 순서가 정해진 순열은 조합과 다를게 없다
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N=  Integer.parseInt(st.nextToken());
		M=  Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = i+1;
		}
		
		makeCombination(new ArrayList<Integer>(), M,0);
	}

}
