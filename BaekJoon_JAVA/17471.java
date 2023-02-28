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
	static int[] people;
	static int answer = -1;
	static int[] parents;
	static List<List<Integer>> injeop;

	// 디스조인트 셋(어제오늘 배운거)
	static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	// 대표자 뱉어내기
	static int findSet(int a) {
		if (a == parents[a]) {
			return a;
		} else {
			return parents[a] = findSet(parents[a]);
		}
	}

	// 합치기
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		} else {
			parents[bRoot] = aRoot;
			return true;
		}
	}

	// ArrayList 내의 모든 요소에 대해 인접리스트를 확인해
	// ArrayList의 크기가 2 이상이고 서로 연결되어있을 경우 union
	static void makeUnion(ArrayList<Integer> list) {
		if (list.size() >= 2) {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (injeop.get(list.get(i)).contains(list.get(j))) {
						union(list.get(i), list.get(j));
					}
				}
			}
		}
	}

	// 나누어진 구역 내의 모든 인구수 합 반환
	static int getSum(ArrayList<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += people[list.get(i)];
		}
		return sum;
	}

	// 부분집합 구하는 메서드
	static void makeCombination(ArrayList<Integer> myList, int start, int depth) {
		if (depth == 0) {
			makeSet();
			ArrayList<Integer> another = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (!myList.contains(i)) {
					another.add(i);
				}
			}

			makeUnion(myList);
			makeUnion(another);

			int setN = 0;

			for (int i = 0; i < N; i++) {
				if (parents[i] == i)
					setN++;
			}
			if (setN != 2)
				return;

			int sum1 = getSum(myList);
			int sum2 = getSum(another);

			// answer가 -1인 경우(그전까지 만족하는 경우가 없었을 경우) answer를 sum1 - sum2로 변경
			if (answer == -1) {
				answer = Math.abs(sum1 - sum2);
			} else {
				// answer가 -1이 아닌 경우(그전까지 만족하는 경우가 있어서 answer값이 변경된 상태) Math.min연산
				answer = Math.min(answer, Math.abs(sum1 - sum2));
			}
		}

		// 재귀로 조합구하기
		for (int i = start; i < N; i++) {
			myList.add(i);
			makeCombination(myList, i + 1, depth - 1);
			myList.remove(myList.size() - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		// 구역과 연결 상태의 수 N
		N = Integer.parseInt(br.readLine());

		// 연결 상태를 나타내는 인접 리스트 선언
		injeop = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			injeop.add(new ArrayList<Integer>());
		}

		// 인구수 담은 배열
		people = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		// 인접 리스트 초기화
		// 중복을 피하기 위해 인접리스트의 index보다 인접한 구역을 나타내는 값이 더 클 때만 리스트에 추가
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {
				int to = Integer.parseInt(st.nextToken()) - 1;
				if (i < to) {
					injeop.get(i).add(to);
				}
			}
		}

		// 크기가 1부터 N-1인 모든 부분집합을 구하고 그 부분집합들에 대해 연결 상태 확인
		for (int i = 1; i <= N - 1; i++) {
			makeCombination(new ArrayList<Integer>(), 0, i);
		}

		System.out.println(answer);

	}

}
