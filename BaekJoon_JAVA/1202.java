import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Dia {
	int price;
	int weight;
	
	public Dia(int weight, int price) {
		this.price = price;
		this.weight = weight;
	}
		
//		public int compareTo(Dia dia) {
//			// TODO Auto-generated method stub
//			if (this.getPrice() < dia.getPrice())
//	            return 1;
//	        else if (this.getPrice() > dia.getPrice())
//	            return -1;
//	       
//		}
}

public class java1202 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		PriorityQueue<Dia> diaQueue = new PriorityQueue<>();
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		List<Integer> bagList = new ArrayList<>();
//		int answer = 0;
//		for(int i=0;i<N;i++) {
//			st = new StringTokenizer(br.readLine());
//			int weight = Integer.parseInt(st.nextToken());
//			int price = Integer.parseInt(st.nextToken());
//			diaQueue.add(new Dia(weight, price));
//		}
//		
//		for(int i=0;i<K;i++) {
//			st = new StringTokenizer(br.readLine());
//			int capacity = Integer.parseInt(st.nextToken());
//			bagList.add(capacity);
//		}
//		
//		Collections.sort(bagList);
//		int count = 0;
//		
//		while(diaQueue.size() >0 && count<K ) {
//			Dia myDia = diaQueue.poll();
//			for( int i=0 ;i<bagList.size();i++) {
//				if(myDia.getWeight() <=bagList.get(i)) {
//					answer +=myDia.getPrice();
//					count++;
//					bagList.remove(i);
//					break;
//				}
//			}
//		}
//		System.out.println(answer); // 시간초과
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Dia[] diaList = new Dia[N];
		int[] bagList = new int[K];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			diaList[i] = new Dia(weight, price);
		}
		
		Arrays.sort(diaList, new Comparator<Dia>() {
			@Override
			public int compare(Dia o1, Dia o2) {
				// TODO Auto-generated method stub
				if(o1.weight == o2.weight) {
					return o2.price - o1.price;
				}
				return o1.weight - o2.weight;
			}
		});
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int capacity = Integer.parseInt(st.nextToken());
			bagList[i] = capacity;
		}
		
		Arrays.sort(bagList);
		
		long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && diaList[j].weight <= bagList[i]) {
                pq.add(diaList[j++].price);
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
		System.out.println(answer);
	}
}