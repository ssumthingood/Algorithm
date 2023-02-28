import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static boolean[][] board;
	// 사방 탐색 변수와 메소드
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean isIn(int r, int c) {
		return (r>=0 && r<100 && c>=0 && c<100);
	}
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 손수건의 상태를 나타낼 2차원 boolean 배열 -> 흰색 false / 검은색 true
		board = new boolean[100][100];
		int answer = 0;
		// 입력을 통해 검은색 면적 초기화(스카프 크기 10 고려하여 검은색인 경우 ture로 바꿈)
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			for(int j=r;j<r+10;j++) {
				for(int k=c;k<c+10;k++) {
					board[j][k] = true;
				}
			}
		}
		
		// 모든 영억을 탐색하면서 탐색한 요소가 true(검은색)일 경우 둘레 구하기 시작
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				// 4방 탐색을 통한 둘레 증가
				if(board[i][j]) {
					for(int k=0;k<4;k++) {
						int nr = i+dir[k][0];
						int nc = j+dir[k][1];
						// 4방향 중 isIn이 false인 경우(흰 천의 끝부분) 둘레 증가
						if(!isIn(nr,nc)) {
							answer++;
						}else {
							// isIn이 true일 경우 해당 방향의 요소가 false(흰색)일 경우 둘레 증가
							if(!board[nr][nc]) {
								answer++;
							}
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

}