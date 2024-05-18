import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N = 20;
    static double answer;
    static double sum = 0;
    static int divide = 0;

    static BufferedReader br;
    static StringTokenizer st;

    static HashMap<String, Double> map;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<String, Double>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        for(int i=0;i<20;i++){
            st = new StringTokenizer(br.readLine());
            String[] classData = new String[3];
            classData[0] = st.nextToken();
            classData[1] = st.nextToken();
            classData[2] = st.nextToken();
            if(classData[2].equals("P")) continue;

//            System.out.println(classData[0] + ", " + classData[1] + ", " + classData[2]);
            int classDivide = Integer.parseInt(classData[1].charAt(0)+"");
            divide += classDivide;
            double classSum = classDivide * map.get(classData[2]);
            sum += classSum;
        }
        answer = sum/divide;
        System.out.println(answer);
    }
}
