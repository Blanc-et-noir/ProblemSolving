import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int result=0;
		for(int i=0; i<N;i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		while(K!=0) {
			int num = pq.poll();
			int cnt = K/num;
			result+=cnt;
			K=K%num;
		}
		bw.write(result+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}