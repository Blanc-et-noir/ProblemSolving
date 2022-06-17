import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		int[] v = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		
		v[N]=0;
		q.add(N);
		
		while(!q.isEmpty()) {
			int T = q.poll();
			if(T==K) {
				bw.write(v[T]+"\n");
				break;
			}else {
				
				if(T-1>=0&&v[T-1]==0) {
					v[T-1]= v[T]+1;
					q.add(T-1);
				}
				if(T+1<=100000&&v[T+1]==0) {
					v[T+1]= v[T]+1;
					q.add(T+1);
				}
				if(T*2<=100000&&v[T*2]==0) {
					v[T*2]= v[T]+1;
					q.add(T*2);
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}