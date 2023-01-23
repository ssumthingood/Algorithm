package org.opentutorials.javatutorials.eclipse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class java17144 {
	//확산 가능 여부(맵을 벗어나지 않는지)를 판단할 방향벡터 배열과 함수 
	static int[][] direc = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean inBoard(int targetY, int targetX, int R, int C) {
		if((targetY >=1 && targetY <=R) && (targetX >=1 && targetX <=C)) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] board = new int[R+2][C+2];
		//먼지의 이동 작업 시 사용할 2칸의 공기청정기 위치 저장 
		int cleanerUp = 0;
		int cleanerDown = 0;
		for(int i=1;i<=R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=C;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == -1 && cleanerUp ==0) {
					cleanerUp = i;
					}else if(board[i][j] == -1 && cleanerUp !=0) {
						cleanerDown = i;
					}
			}
		}
		
		for(int t = 0;t<T;t++) {
			//확산 - 기존 보드에 확산 적용 시 동시에 확산되는 작업을 수행하기 힘드므로 확산 후에 보드에 더해질 먼지의 정도를 저장하는 배열을 추가
			int[][] plusboard = new int[R+2][C+2];
			for(int i=1;i<=R;i++) {
				for(int j=1;j<=C;j++) {
					if(board[i][j] >0) {
						Queue<int[]> canGo = new LinkedList<>();
						for(int p=0;p<4;p++) {
							int newY = i+direc[p][0];
							int newX = j+direc[p][1];
							
							if(inBoard(newY,newX,R,C)) {
								if(board[newY][newX] != -1) {
									int[] go = {newY,newX};
									canGo.add(go);
								}
							}
						}
						int size = canGo.size();
						while(canGo.size()>0) {
							int[] loca= canGo.poll();
							plusboard[loca[0]][loca[1]] += board[i][j]/5;
						}
						board[i][j] = board[i][j] - size*(int)(board[i][j]/5);
						//형변환 안해주니까 확산이 묘하게 어긋남
					}
				}
			}
			
			//기존 보드 배열에 확산되는 정도를 더해주어 확산 후의 배열로 만듬 
			for(int i=1;i<=R;i++) {
				for(int j=1;j<=C;j++) {
					board[i][j] = board[i][j] + plusboard[i][j];
				}
			}
			
			//옮기기 - 확산 후의 배열의 값을 그대로 가진 next배열을 생성하여 그 위에서 옮기기 작업 수행 후 기존 보드에 덮어씌움 
			int[][] next = new int[R+2][C+2];
			for(int i=1;i<=R;i++) {
				for(int j=1;j<=C;j++) {
					next[i][j] = board[i][j];
				}
			}
			
			//개노가다 - 공기청정기의 위치에 주의하여 board배열의 값을 next배열의 옮겨진 위치에 덮어씌움 
			for(int i=1;i<cleanerUp-1;i++) {
				next[i+1][1] = board[i][1];
			}
			for(int j=2;j<C;j++) {
				next[cleanerUp][j+1] = board[cleanerUp][j];
			}
			for(int i=cleanerUp;i>1;i--) {
				next[i-1][C] = board[i][C];
			}
			for(int j=C;j>1;j--) {
				next[1][j-1] = board[1][j];
			}
			
			for(int i=R;i>cleanerDown+1;i--) {
				next[i-1][1] = board[i][1];
			}
			for(int j=2;j<C;j++) {
				next[cleanerDown][j+1] = board[cleanerDown][j];
			}
			for(int i=cleanerDown;i<R;i++) {
				next[i+1][C] = board[i][C];
			}
			for(int j=C;j>1;j--) {
				next[R][j-1] = board[R][j];
			}
			
			//공청기에서 처음 바람이 나가는 칸은 먼지가 0임 
			next[cleanerUp][2] = 0;
			next[cleanerDown][2] = 0;
			
			//board를 next로 바꿔서 확산 후 이동 1회 완료 
			board = next;
		}
		
		//모든 수 더하기
		int answer = 0;
		for(int i=1;i<=R;i++) {
			for(int j=1;j<=C;j++) {
				if(board[i][j]>0) answer+=board[i][j];
			}
		}
		
		System.out.println(answer);
	}
}