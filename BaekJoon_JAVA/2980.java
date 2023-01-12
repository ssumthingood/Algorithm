//https://www.acmicpc.net/problem/2980

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        int nowD = 0;
        int time = 0;
        
        for(int i=0;i<N;i++){
            String DRG = br.readLine();
            st = new StringTokenizer(DRG);
            int D = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            
            while(nowD < D ){
                nowD++;
                time++;
            }
            int flag = time%(R+G);
            if(flag < R) time +=R-flag;
        }
        
        time +=L-nowD;
        System.out.println(time);
    }
}