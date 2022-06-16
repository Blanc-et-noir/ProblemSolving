package BOJ.BFS.DSLR_9019;

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
	public static boolean[] v = new boolean[10000];
	public static String[] s = new String[10000];
	public static void BFS(int n, int a) throws IOException{
		v = new boolean[10000];
		for(int i=0; i<s.length; i++) {
			s[i]=new String("");
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		v[n]=true;
		while(!q.isEmpty()) {
			int t = q.poll();
			if(t==a) {
				bw.write(s[t]+"\n");
				return;
			}else {
				int D = t*2%10000;
				if(!v[D]) {
					q.add(D);
					v[D]=true;
					s[D]=s[t]+"D";
				}
				int S = t>0?t-1:9999;
				if(!v[S]) {
					q.add(S);
					v[S]=true;
					s[S]=s[t]+"S";
				}
				int L = t*10%10000+t*10/10000;
				if(!v[L]) {
					q.add(L);
					v[L]=true;
					s[L]=s[t]+"L";
				}
				int R = (t%10)*1000+t/10;
				if(!v[R]) {
					q.add(R);
					v[R]=true;
					s[R]=s[t]+"R";
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			String[] str = br.readLine().split(" ");
			BFS(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}