import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append("");
            
        for(int i=1; i<T+1;i++){
            for(int j=1;j<i+1;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}