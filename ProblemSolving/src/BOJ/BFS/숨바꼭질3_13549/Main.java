package BOJ.BFS.¼û¹Ù²ÀÁú3_13549;

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
	public static int[] arr = new int[100001];
	public static int BFS(int N, int K) {
		
		for(int i=0; i<arr.length; i++) {
			arr[i]=0x7FFFFFFF;
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		arr[N]=0;
		
		while(!q.isEmpty()) {
			
			int X = q.poll();
			
			if(X==K) {
				return arr[X];
			}
			if(X*2>=0&&X*2<arr.length) {
				if(arr[X*2]==0X7FFFFFFF) {
					q.add(X*2);
					arr[X*2]=arr[X];
				}
			}
			if(X-1>=0&&X-1<arr.length) {
				if(arr[X-1]==0X7FFFFFFF) {
					q.add(X-1);
					arr[X-1]=arr[X]+1;
				}
			}
			if(X+1>=0&&X+1<arr.length) {
				if(arr[X+1]==0X7FFFFFFF) {
					q.add(X+1);
					arr[X+1]=arr[X]+1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException{
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		
		bw.write(BFS(N,K)+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}