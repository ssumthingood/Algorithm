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
        System.out.println("#"+test_case);
        int size = sc.nextInt();
        int[][] arr = new int[size][size];
        for(int i=0;i<size;i++){
        for(int j=0;j<size;j++){
        arr[i][j] = sc.nextInt();
        }
        }
         
        for(int i=0;i<size;i++){
            for(int j=1; j<=size; j++){
            // System.out.print(arr[i][size-j]);
            System.out.print(arr[size-j][i]);
            }
            System.out.print(" ");
             
            for(int k=1;k<=size;k++){
            //System.out.print(arr[size-k][size-i-1]);
            System.out.print(arr[size-i-1][size-k]);
            }
            System.out.print(" ");
             
            for(int t=0;t<size;t++){
            //System.out.print(arr[size-i-1][t]);
            System.out.print(arr[t][size-i-1]);
            }
             
            System.out.println();
        }
         
        }
    }
}