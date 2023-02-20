import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int M;
	static int start;
	static int end;
	static int[] arr;

	public static void main(String[] args) throws IOException {
	    br = new BufferedReader(new InputStreamReader(System.in));
	    st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    arr = new int[N];
	    st = new StringTokenizer(br.readLine());
	    int mysum = 0;
	    int max = 0;
	    for(int i=0;i<N;i++) {
	    	arr[i] = Integer.parseInt(st.nextToken());
	    	mysum +=arr[i];
	    	max = Math.max(arr[i], max);
	    }
	    
	    start = max;
	    end = mysum;
	    int mid = 0;
	    while(start <=end) {
	    	int sum = 0;
	    	int count = 0;
	    	mid = (start+end)/2;
	    	
	    	for(int i=0;i<N;i++) {
	    		if(sum+arr[i]>mid) {
					sum = 0;
					count++;
				}
				sum += arr[i];
	    	}
	    	
	    	if(sum>0) count++;
	    	
	    	if(count <=M) {
	    		end = mid-1;
	    	}else{
	    		start = mid+1;
	    	}
	    }
	    System.out.println(start);
	}
}