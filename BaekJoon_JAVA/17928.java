import java.io.*;
import java.util.*;

public class java17928 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");

        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i<N; i++){
            while(!s.isEmpty() && data[s.peek()] < data[i]){
                int idx = s.pop();
                data[idx] = data[i];
            }
            s.add(i);
        }

        while(!s.isEmpty()){
            data[s.pop()] = -1;
        }

        for(int i = 0; i<N; i++){
           sb.append(data[i]+" ");
        }
        System.out.println(sb);
        // StringBuilder 사용해 print 횟수를 줄인다 
    }
}