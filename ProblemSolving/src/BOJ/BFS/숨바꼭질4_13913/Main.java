package BOJ.BFS.¼û¹Ù²ÀÁú4_13913;

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
	public static String[] s = new String[100001];
	public static void BFS(int N, int K) throws IOException{
		if(N>K) {
			System.out.println(N-K);
			for(int i=N; i>=K; i--) {
				System.out.print(i+" ");
			}
			return;
		}
		s[N] = new String(N+"");
		Queue<Integer> q = new LinkedList<>();
		q.add(N);

		while(!q.isEmpty()) {
			int X = q.poll();
			if(X==K) {
				bw.write((s[X].split(" ").length-1)+"\n");
				bw.write(s[X]+"\n");
				return;
			}
			if(X-1>=0&&X-1<s.length&&s[X-1]==null) {
				s[X-1] = s[X] +" "+ (X-1);
				q.add(X-1);
			}
			if(X+1>=0&&X+1<s.length&&s[X+1]==null) {
				s[X+1] = s[X] +" "+ (X+1);
				q.add(X+1);
			}
			if(X*2>=0&&X*2<s.length&&s[X*2]==null) {
				s[X*2] = s[X] +" "+ (X*2);
				q.add(X*2);
			}
			s[X]="";
		}		
	}
	public static void main(String[] args) throws IOException{
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		BFS(N,K);
		bw.flush();
		bw.close();
		br.close();
	}
}