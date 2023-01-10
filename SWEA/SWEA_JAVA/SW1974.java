import java.util.Scanner;
  
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] sudoku;
        for (int test_case = 1; test_case <= T; test_case++) {
            sudoku = new int[9][9];
            int checked = 1;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < 9; i++) {
                int sum = 0;
                for (int j = 0; j < 9; j++) {
                    sum += sudoku[i][j];
                }
                if (sum != 45) {
                    checked = 0;
                }
            }
            for (int i = 0; i < 9; i++) {
                int sum = 0;
                for (int j = 0; j < 9; j++) {
                    sum += sudoku[j][i];
                }
                if (sum != 45) {
                    checked = 0;
                }
            }
            for (int i = 0; i < 3; i++) {
                for(int j = 0; j< 3 ; j++) {
                    int sum = 0;
                    for(int row = i*3; row < i*3+3; row++) {
                        for(int col = j*3; col < j*3+3; col++) {
                            sum += sudoku[row][col];
                        }
                    }
                    if (sum != 45) {
                        checked = 0;
                    }
                }
            }
            System.out.println("#"+ test_case+" "+ checked);
        }
    }
  
}