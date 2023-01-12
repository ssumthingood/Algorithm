import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
        int tc = sc.nextInt();
        int[] scores = new int[101];
         // 입력받은 숫자 빈도수 체크
        for(int i =0; i<1000; i++){
             scores[sc.nextInt()]++;
            }
            int max = 0;
            int index = 0;
            // 최빈값 비교
            for(int i =0; i<scores.length; i++){
                if(scores[i] >= max){
                    max = scores[i];
                    index = i;
                }
            }
            System.out.println("#" + tc + " " + index);  
        }
    }
}