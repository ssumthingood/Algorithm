import java.io.*;
import java.util.*;

public class java2072 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = -1;
        int count = 0;
        int[][] baduk = new int[21][21];
        for(int i=0;i<21;i++) {
        	for(int j=0;j<21;j++) {
        		baduk[i][j] = 0;
        	}
        }
        int T = Integer.parseInt(st.nextToken());
        int isBlack = 1;

        finish : while(count<T) {
        	st = new StringTokenizer(br.readLine());
        	int X = Integer.parseInt(st.nextToken());
        	int Y = Integer.parseInt(st.nextToken());
        	baduk[Y][X] = isBlack;
        	isBlack = isBlack*(-1);//검은돌 1, 흰돌 -1, 빈곳 0
        	count++;
        	for (int i=1;i<20;i++) {
        		for(int j=1;j<20;j++) {
        			if(baduk[i][j] !=0) {
        				if( i<=15 && j>=5) {
        					if((baduk[i-1][j+1] != baduk[i][j]) && (baduk[i][j] == baduk[i+1][j-1]) && (baduk[i+1][j-1] == baduk[i+2][j-2]) && (baduk[i+2][j-2] == baduk[i+3][j-3]) && (baduk[i+3][j-3] == baduk[i+4][j-4]) && (baduk[i+4][j-4] != baduk[i+5][j-5])) {
        					answer = count;
        					break finish;
        					}
        				}
        				
        				if (i<=15 && j<=15) {
        					if((baduk[i-1][j-1] != baduk[i][j]) &&(baduk[i][j] == baduk[i+1][j+1]) && (baduk[i+1][j+1] == baduk[i+2][j+2]) && (baduk[i+2][j+2] == baduk[i+3][j+3]) && (baduk[i+3][j+3] == baduk[i+4][j+4]) && (baduk[i+4][j+4] != baduk[i+5][j+5])) {
        						answer = count;
        						break finish;
        					}
        				}
        				
        				if(j<=15) {
        					if((baduk[i][j] != baduk[i][j-1]) && (baduk[i][j] == baduk[i][j+1]) && (baduk[i][j+1] == baduk[i][j+2]) && (baduk[i][j+2] == baduk[i][j+3]) && (baduk[i][j+3] == baduk[i][j+4]) && (baduk[i][j+4] != baduk[i][j+5])) {
        						answer = count;
        						break finish;
        					}
        				}
        				
        				if(i<=15) {
        					if((baduk[i-1][j] != baduk[i][j]) &&(baduk[i][j] == baduk[i+1][j]) && (baduk[i+1][j] == baduk[i+2][j]) && (baduk[i+2][j] == baduk[i+3][j]) && (baduk[i+3][j] == baduk[i+4][j]) && (baduk[i+4][j] != baduk[i+5][j])) {
        						answer = count;
        						break finish;
        					}
        			}
        		}else continue;
        	}
        }
        }
        System.out.println(answer);
	}
}