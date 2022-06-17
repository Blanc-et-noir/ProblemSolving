import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int y, x;
	Node(int y, int x){
		this.y = y;
		this.x = x;
	}
}
public class Main {

	public static void main(String[] args) {
		Queue<Node> queue = new LinkedList<>();
		int M, N, temp, count = 0, result=0, max = 0;
		int[][] map;
		int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
		String[] strArr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			strArr = br.readLine().split(" ");
			M = Integer.parseInt(strArr[0]);
			N = Integer.parseInt(strArr[1]);
			map = new int[N][M];
			for(int i=0; i<N; i++) {
				strArr = br.readLine().split(" ");
				for(int j=0; j<M; j++) {
					temp = Integer.parseInt(strArr[j]);
					if(temp == 0) {
						count++;
					}else if(temp == 1) {
						queue.add(new Node(i,j));
					}
					map[i][j] = temp;
				}
			}
			
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				for(int i=0; i<4; i++) {
					if(node.y+dy[i]>=0&&node.y+dy[i]<N&&node.x+dx[i]>=0&&node.x+dx[i]<M&&map[node.y+dy[i]][node.x+dx[i]] == 0) {
						map[node.y+dy[i]][node.x+dx[i]] = map[node.y][node.x]+1;
						result++;
						if(map[node.y][node.x]+1>max) {
							max = map[node.y][node.x];
						}
						queue.add(new Node(node.y+dy[i],node.x+dx[i]));
					}
				}
			}
			if(result == count) {
				System.out.println(max);
			}else {
				System.out.println(-1);
			}
		}catch(Exception e) {
			
		}
	}
}