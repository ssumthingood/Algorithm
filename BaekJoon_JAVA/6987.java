import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] matches = {
			{0,1},{0,2},{0,3},{0,4},{0,5},
			{1,2},{1,3},{1,4},{1,5},{2,3},
			{2,4},{2,5},{3,4},{3,5},{4,5}};
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] result;
	static int[][] myArr;
	static boolean resultFlag;

	static void dfs(int index) {
		if(index == 15) {
			boolean flag = true;
			for(int i=0;i<6;i++) {
				for(int j=0;j<3;j++) {
					if(myArr[i][j] != result[i][j]) {
						flag = false;
					}
				}
			}
			if(flag) {
				resultFlag = true;
			}
			return;
		}
		
		int[] versus = matches[index];
		
		win(versus[0],versus[1]);
		dfs(index+1);
		unWin(versus[0],versus[1]);
		
		lose(versus[0],versus[1]);
		dfs(index+1);
		unlose(versus[0],versus[1]);
		
		draw(versus[0],versus[1]);
		dfs(index+1);
		undraw(versus[0],versus[1]);
		
	}
	

	static void win(int i, int j) {
		myArr[i][0]++;
		myArr[j][2]++;
	}
	
	static void unWin(int i, int j) {
		myArr[i][0]--;
		myArr[j][2]--;
	}
	
	static void lose(int i, int j) {
		myArr[i][2]++;
		myArr[j][0]++;
	}
	
	static void unlose(int i, int j) {
		myArr[i][2]--;
		myArr[j][0]--;
	}
	
	static void draw(int i, int j) {
		myArr[i][1]++;
		myArr[j][1]++;
	}
	
	static void undraw(int i, int j) {
		myArr[i][1]--;
		myArr[j][1]--;
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for(int t=0;t<4;t++) {
			st = new StringTokenizer(br.readLine());
			result = new int[6][3];
			for(int i=0;i<6;i++) {
				for(int j=0;j<3;j++) {
					result[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			myArr = new int[6][3];
			dfs(0);
			if(!resultFlag) {
				sb.append("0 ");
			}else {
				sb.append("1 ");
			}
			resultFlag = false;
		}
		
		System.out.println(sb);
	}
}
