import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
        int tc=sc.nextInt();
            int sum = 0;
            int[][] data = new int[100][100];
            //배열 선언
             
            for(int i=0;i<100;i++){
                for(int j=0;j<100;j++){
                    data[i][j] = sc.nextInt();
                }
            }//배열 채우기
             
            for(int i=0;i<100;i++){
                int temp = 0;
                for(int j=0;j<100;j++){
                temp += data[i][j];
                }
                if(temp>sum) sum = temp;
            }//가로행 더하기
             
            for(int j=0;j<100;j++){
                int temp = 0;
                for(int i=0;i<100;i++){
                temp += data[i][j];
                }
                if(temp>sum) sum = temp;
            }//세로행 더하기
             
            int temp = 0;
            for(int i = 0;i<100;i++){    
                temp += data[i][i];
            }
            if(temp>sum) sum = temp;
             
            int temp2 = 0;
            for(int i = 0;i<100;i++){    
                temp2 += data[99-i][i];
            }
            if(temp>sum) sum = temp2;
            //대각선 더하기
            System.out.println("#"+tc+" "+sum);
        }
    }
}