import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static void makePermutation(int needTo, List<Integer> list) {
		if (needTo == 0) {
			int sum = 0;
			for (int i = list.size() - 1; i >= 0; i--) {
				sum += list.get(list.size() - 1 - i) * Math.pow(10, i);
			}
			if (sum > Target && !flag) {
				flag = true;
				System.out.println(sum);
				return;
			}
		}

		if (!flag) {
			for (int i = 0; i < arr.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					list.add(arr[i]);
					makePermutation(needTo - 1, list);
					list.remove(list.size() - 1);
					visited[i] = false;
				}
			}
		}
	}

	static int Target;
	static int[] arr;
	static boolean[] visited;
	static String str;
	static BufferedReader br;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		Target = Integer.parseInt(str);
		arr = new int[str.length()];
		visited = new boolean[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i) - '0';
		}
		Arrays.sort(arr);
		makePermutation(arr.length, new ArrayList<Integer>());
		if (!flag) {
			System.out.println(0);
		}
	}
}
