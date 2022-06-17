import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

class Node{
	int y,x;
	Node(int y,int x){
		this.y=y;
		this.x=x;
	}
}
public class Main {
	public static int[][] map;
	public static int N,M,C;
	public static Vector<Node> vc = new Vector<>();
	public static Vector<Node> vh = new Vector<>();
	
	public static int shortest = 0x7FFFFFFF;
	
	public static void DFS(int[] E,int idx, int cnt) {
		if(M==cnt) {
			int sum=0;
			for(int i=0; i<vh.size(); i++) {
				int min = 0x7FFFFFFF;
				for(int j=0; j<E.length; j++) {
					int num = Math.abs(vh.get(i).y-vc.get(E[j]).y) + Math.abs(vh.get(i).x-vc.get(E[j]).x);
					if(num<min) {
						min=num;
					}
				}
				sum+=min;
			}
			if(sum<shortest) {
				shortest = sum;
			}
			return;
		}else {
			for(int i=idx; i<C; i++) {
				E[cnt] = i;
				DFS(E, i+1,cnt+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][N];
		for(int i=0; i<N;i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				int c = Integer.parseInt(str[j]);
				if(c==2) {
					vc.add(new Node(i,j));
					C++;
				}else if(c==1) {
					vh.add(new Node(i,j));
				}
				map[i][j] = c;
			}
		}
		DFS(new int[M],0,0);
		System.out.println(shortest);
		bw.flush();
		bw.close();
		br.close();
	}
}