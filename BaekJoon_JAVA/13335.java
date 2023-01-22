import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 무게와 나갈 시간을 가진 Truck 클래스 선언
class Truck {
	int weight;
	int outTime;
	public Truck(int weight, int outTime) {
		this.weight = weight;
		this.outTime = outTime;
	}
}

public class java13335 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		//트럭 정보를 담은 큐 
		Queue<Integer> trucks = new LinkedList<>();
		//다리 위에 있는 트럭 정보를 담은 큐 
		Queue<Truck> inBridge = new LinkedList<>();
		int time = 0;
		int nowsum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			trucks.offer(Integer.parseInt(st.nextToken()));
		}

		//트럭 목록과 다리위 트럭이 모두 없어질때까지 
		while(trucks.size()!=0 || inBridge.size()!=0) {
			//올릴 수 있으면 
			if(trucks.size()>0 && nowsum +trucks.peek() <= L && inBridge.size() <W) {
				int newTruck = trucks.poll();
				nowsum +=newTruck;
				inBridge.offer(new Truck(newTruck, W + time));
				time++;
				//트럭을 올린 다음에 time을 플러스하는 이유
				//트럭이 나가는 것과 들어오는 것이 동시일 경우 time을 올리고 트럭을 올리면 원하는 대로 이어지지 않
			}else {
				//못올리면 다리위에서 하나 빼고 시간을 트럭이 다리의 끝에 위치한 시간으로 이동 
				Truck outTruck = inBridge.poll();
				if(time < outTruck.outTime) {time = outTruck.outTime;}
				nowsum -=outTruck.weight;
			}
		}
		//마지막 트럭이 완전히 지나가기까지는 1초의 시간이 더 필요 
		System.out.println(time+1);
	}

}
