package BOJ.BFS.¼û¹Ù²ÀÁú2_12851;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int X;
	int cost;
	Node(int X, int cost){
		this.X = X;
		this.cost = cost;
	}
}
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void BFS(int N, int K) throws IOException{
		Node[] arr = new Node[100001];
		arr[N] = new Node(N,0);
		Queue<Node> q = new LinkedList<>();
		q.add(arr[N]);
		int cnt=0;
		int cost=0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.X==K) {
				cnt++;
				cost = n.cost;
				continue;
			}
			if(n.X-1>=0&&n.X-1<=100000) {
				if(arr[n.X-1]==null||(arr[n.X-1]!=null&&n.cost+1==arr[n.X-1].cost)) {
					arr[n.X-1] = new Node(n.X-1,n.cost+1);
					q.add(arr[n.X-1]);
				}
			}
			
			if(n.X+1>=0&&n.X+1<=100000) {
				if(arr[n.X+1]==null||(arr[n.X+1]!=null&&n.cost+1==arr[n.X+1].cost)) {
					arr[n.X+1] = new Node(n.X+1,n.cost+1);
					q.add(arr[n.X+1]);
				}
			}
			
			if(n.X*2>=0&&n.X*2<=100000) {
				if(arr[n.X*2]==null||(arr[n.X*2]!=null&&n.cost+1==arr[n.X*2].cost)) {
					arr[n.X*2] = new Node(n.X*2,n.cost+1);
					q.add(arr[n.X*2]);
				}
			}
		}
		bw.write(cost+"\n"+cnt+"\n");
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