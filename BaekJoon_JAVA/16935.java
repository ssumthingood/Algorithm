import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int R;
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] arr;
	static void updown() {
		int r = arr.length;
		int c = arr[0].length;
		int[][] temp = new int[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				temp[i][j] = arr[r-1-i][j];
			}
		}
		arr =  temp;
	}
	
	static void rightleft() {
		int r = arr.length;
		int c = arr[0].length;
		int[][] temp = new int[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				temp[i][j] = arr[i][c-1-j];
			}
		}
		arr = temp;
	}
	
	static void rotateR() {
		int r = arr.length;
		int c = arr[0].length;
		int[][] temp = new int[c][r];
		for(int i=0;i<c;i++) {
			for(int j=0;j<r;j++) {
				temp[i][j] = arr[r-1-j][i];
			}
		}
		arr = temp;
	}
	static void rotateL() {
		int r = arr.length;
		int c = arr[0].length;
		int[][] temp = new int[c][r];
		for(int i=0;i<c;i++) {
			for(int j=0;j<r;j++) {
				temp[i][j] = arr[j][c-1-i];
			}
		}
		arr = temp;
	}
	static void five() {
		int r = arr.length;
		int c = arr[0].length;
		int nr = r/2;
		int nc = c/2;
		int[][] temp = new int[r][c];
		for(int i=0;i<nr;i++) {
			for(int j=0;j<nc;j++) {
				temp[i][j+nc] = arr[i][j];
			}
		}
		for(int i=0;i<nr;i++) {
			for(int j=0;j<nc;j++) {
				temp[i+nr][j+nc] = arr[i][j+nc];
			}
		}
		for(int i=0;i<nr;i++) {
			for(int j=0;j<nc;j++) {
				temp[i+nr][j] = arr[i+nr][j+nc];
			}
		}
		for(int i=0;i<nr;i++) {
			for(int j=0;j<nc;j++) {
				temp[i][j] = arr[i+nr][j];
			}
		}
		arr = temp;
	}
	static void six() {
		int r = arr.length;
		int c = arr[0].length;
		int nr = r/2;
		int nc = c/2;
		int[][] temp = new int[r][c];

		for(int i=0;i<nr;i++) {
			for(int j=0;j<nc;j++) {
				temp[i][j] = arr[i][j+nc];
			}
		}
		for(int i=0;i<nr;i++) {
			for(int j=0;j<nc;j++) {
				temp[i][j+nc] = arr[i+nr][j+nc];
			}
		}
		for(int i=0;i<nr;i++) {
			for(int j=0;j<nc;j++) {
				temp[i+nr][j+nc] = arr[i+nr][j];

			}
		}
		for(int i=0;i<nr;i++) {
			for(int j=0;j<nc;j++) {
				temp[i+nr][j] = arr[i][j];
			}
		}
		arr = temp;
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<R;i++) {
			int order = Integer.parseInt(st.nextToken());
			switch(order) {
			case 1: updown(); break;
			case 2: rightleft();break;
			case 3: rotateR();break;
			case 4: rotateL();break;
			case 5: five();break;
			case 6: six(); break;
			}
		}
		sb = new StringBuilder();
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}