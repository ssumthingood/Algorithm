package org.opentutorials.javatutorials.eclipse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class java17143 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Shark> sharks = new ArrayList<>();
		int answer = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sharks.add(new Shark(r, c, s, d, z));
		}
		
		sharks.sort((a,b) -> b.z-a.z);
		int location =0;
		while(location<C) {
			location++;
			finish : for(int i=1; i<=R ;i++) {
				for(int j=0;j<sharks.size();j++) {
					if(sharks.get(j).c == location && sharks.get(j).r == i && sharks.get(j).z >0) {
						answer += sharks.get(j).z;
						sharks.get(j).z = 0;
						break finish;
					}
				}
			}
			int[][] board = new int[R+1][C+1];
			for(Shark sk : sharks) {
				move(sk, board, R, C);
			}
			sharks.sort((a,b) -> b.z-a.z);
		}
		
		System.out.println(answer);
	}
	
	static class Shark{
		int r, c, s, d, z;
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	static void move(Shark sk, int[][] board, int R, int C) {
		switch(sk.d) {
		case 1:
			sk.r = sk.r - sk.s;break;
		case 2: 
			sk.r = sk.r + sk.s;break;
		case 3 : 
			sk.c = sk.c + sk.s;break;
		case 4 : 
			sk.c = sk.c - sk.s;break;
		}
		
		while(sk.r <1 || sk.r >R || sk.c <1 || sk.c >C) {
			if(sk.r<1) {
				sk.d = 2;
				sk.r = 2-sk.r;
			}else if(sk.r >R) {
				sk.d = 1;
				sk.r = 2*R-sk.r;
			}else if(sk.c <1) {
				sk.d = 3;
				sk.c = 2-sk.c;
			}else if(sk.c >C) {
				sk.d = 4;
				sk.c = 2*C-sk.c;
			}
		}
		
		if(board[sk.r][sk.c] < sk.z) {
			board[sk.r][sk.c] = sk.z;
		}else {
			sk.z =0;
		}	
	}
}
