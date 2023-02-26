import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Long X;
    static List<Long> arr;
    static int answer = 0;
    static int remain = 0;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken())*2;
        arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            long target = Long.parseLong(st.nextToken())*2;
            if(target>=X){
                answer++;
                continue;
            }
            arr.add(target);
        }
        Collections.sort(arr);
        int start = 0;
        int end = arr.size()-1;
        int remain = arr.size();
        while(start<end){
            if(arr.get(start) + arr.get(end) >=X/2){
                answer++;
                start++;
                end--;
                remain -=2;
            }else{
                start++;
            }
        }

        answer += remain/3;
        System.out.println(answer);
    }
}