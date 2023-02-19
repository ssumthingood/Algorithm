import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int M;
	static List<int[]> house;
	static List<int[]> gyoChon;
	static int townChickenCurry = Integer.MAX_VALUE;

	static void makeCombination(ArrayList<int[]> alive, int leftOver, int start) {
		if (leftOver == 0) {
			int sum = 0;
			for (int i = 0; i < house.size(); i++) {
				int houseChickenCurry = Integer.MAX_VALUE;
				for (int j = 0; j < alive.size(); j++) {
					houseChickenCurry = Math.min(houseChickenCurry,
							Math.abs(house.get(i)[0] - alive.get(j)[0]) + Math.abs(house.get(i)[1] - alive.get(j)[1]));
				}
				sum +=houseChickenCurry;
			}
			townChickenCurry = Math.min(sum, townChickenCurry);
		}
		
		for(int i=start;i<gyoChon.size();i++) {
			alive.add(gyoChon.get(i));
			makeCombination(alive, leftOver-1, i+1);
			alive.remove(alive.size()-1);
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house = new ArrayList<>();
		gyoChon = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int target = Integer.parseInt(st.nextToken());
				if (target == 1) {
					house.add(new int[] { i, j });
				} else if (target == 2) {
					gyoChon.add(new int[] { i, j });
				}
			}
		}
		makeCombination(new ArrayList<int[]>(), M, 0);
		System.out.println(townChickenCurry);
	}
}