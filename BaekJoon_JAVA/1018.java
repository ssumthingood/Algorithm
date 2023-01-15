import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java1018 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] chess = new int[N][M];
        int min = 33;
        
        int[][] Bchess = {
        	{1,-1,1,-1,1,-1,1,-1},
        	{-1,1,-1,1,-1,1,-1,1},
        	{1,-1,1,-1,1,-1,1,-1},
        	{-1,1,-1,1,-1,1,-1,1},
        	{1,-1,1,-1,1,-1,1,-1},
        	{-1,1,-1,1,-1,1,-1,1},
        	{1,-1,1,-1,1,-1,1,-1},
        	{-1,1,-1,1,-1,1,-1,1}
        };
        
        int [][] Wchess = {
        		{-1,1,-1,1,-1,1,-1,1},
        		{1,-1,1,-1,1,-1,1,-1},
        		{-1,1,-1,1,-1,1,-1,1},
        		{1,-1,1,-1,1,-1,1,-1},
        		{-1,1,-1,1,-1,1,-1,1},
        		{1,-1,1,-1,1,-1,1,-1},
        		{-1,1,-1,1,-1,1,-1,1},
        		{1,-1,1,-1,1,-1,1,-1}
        };

        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	String line = st.nextToken();
        	String[] lineArr = line.split("");
        	for (int j=0;j<M;j++) {
        		switch(lineArr[j]) {
        		case "B": chess[i][j] = 1; break;
        		case "W": chess[i][j] = -1; break;
        		}
        	}
        }
        
        
        for(int i=0;i<N-7;i++) {
        	for(int j=0;j<M-7;j++) {
        		int count1 = 0;
        		int count2 = 0;
        		for(int k=0;k<8;k++) {
        			for(int l=0;l<8;l++) {
        				if(chess[i+k][j+l] != Bchess[k][l]) count1++;
        				if(chess[i+k][j+l] != Wchess[k][l]) count2++;
        			}
        		}
        		int myMin = Math.min(count1, count2);
                min = Math.min(min, myMin);
        	}
        }
        System.out.println(min);
	}

}
