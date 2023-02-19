import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] board;
	static int filled = 9;
	int answer = 0;
	static int whoIsMe;

	static boolean winCheck(int whosTurn) { //whosTurn플레이어가 이겼을경우 true
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == whosTurn && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
				return true;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (board[0][i] == whosTurn && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}

		if (board[0][0] == whosTurn && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true;
		}

		if (board[0][2] == whosTurn && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true;
		}
		return false;
	}

	static int play(int whosTurn) { // whosTurn번 플레이어의 최적의 결과. 반환값은 이기면 1, 비기면 0, 지면 -1

		int enemy = Integer.MAX_VALUE;
		// 다음 재귀에서 돌을 놓을 상대의 최적의 승패 상태 나타내는 변수
		// 1: 승 / -1 : 패 / 나머지 : 무

		// 돌 놓기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {
					board[i][j] = whosTurn;
					//whosTurn 플레이어가 돌을 놓아서 이겼을 경우
					if (winCheck(whosTurn)) { // 내가 이기니까 쟨 진다
						enemy = -1;
					}
					// 상대편 차례의 반환값이 작을수록 나의 최적해에 가깝다
					enemy = Math.min(play(whosTurn % 2 + 1),enemy);
					board[i][j] = 0;
				}
			}
		}

		if (enemy == -1) { // 쟤가 지면 내가 이긴다
			return 1;
		} else if(enemy ==1) { // 쟤가 이기면 내가 진다
			return -1;
		}else {
			return 0; //비김
		}

	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[3][3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] > 0)
					filled--;
			}
		}
		whoIsMe = (filled + 1) % 2 + 1;
		if (play(whoIsMe) == 1) {
			System.out.println("W");
		} else if (play(whoIsMe) == -1) {
			System.out.println("L");
		} else {
			System.out.println("D");
		}
	}

}