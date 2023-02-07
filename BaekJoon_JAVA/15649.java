import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class java15649 {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int M;
	static int[] arr;
	static List<ArrayList<Integer>> answer = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		br = new BufferedReader(new InputStreamReader(System.in));
		st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = i+1;
		}
		
		permutation(new ArrayList<Integer>(), M);
		// System.out.println(answer.size());
		// 왜 answer리스트는 size()는 제대로 나오는데 출력하면 비어있을까?
	}
	
	public static  void permutation(ArrayList<Integer> mylist, int num) {
		if(num == 0) {
			answer.add(mylist);
			for(int i=0;i<mylist.size();i++) {
				System.out.print(mylist.get(i)+" ");
			}
			System.out.println("");
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(mylist.contains(arr[i])) {
				continue;
			}
			
			mylist.add(arr[i]);
			permutation(mylist,num-1);
			mylist.remove(mylist.size()-1);
		}
	}
}
