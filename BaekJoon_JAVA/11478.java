import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class java11478 {
		static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		Set<String> set = new HashSet<>();
		for(int i=0;i<st.length();i++) {
			for(int j=i+1;j<=st.length();j++) {
				set.add(st.substring(i,j));
				//substring(시작 index, 끊는 인덱스+1)
			}
		}
		System.out.println(set.size());
	}
}
