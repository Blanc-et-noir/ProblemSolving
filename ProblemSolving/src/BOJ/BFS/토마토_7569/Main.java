import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int z, y, x;
	Node(int z, int y, int x){
		this.z = z;
		this.y = y;
		this.x = x;
	}
}

public class Main {
	public static void main(String[] args) {
		Queue<Node> queue = new LinkedList<>();
		int M, N, H, temp, count = 0, result=0, max = 0;
		int[][][] map;
		int[] dz = {0,0,0,0,1,-1}, dx = {-1,1,0,0,0,0}, dy= {0,0,-1,1,0,0};
		String[] strArr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			strArr = br.readLine().split(" ");
			M = Integer.parseInt(strArr[0]);
			N = Integer.parseInt(strArr[1]);
			H = Integer.parseInt(strArr[2]);
			
			map = new int[H][N][M];
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<N; j++) {
					strArr = br.readLine().split(" ");
					for(int k=0; k<M; k++) {
						temp = Integer.parseInt(strArr[k]);
						if(temp == 0) {
							map[i][j][k] = 0;
							count++;
						}else if(temp == 1) {
							queue.add(new Node(i,j,k));
							map[i][j][k] = 1;
						}else if(temp == -1){
							map[i][j][k] = -1;
						}
					}
				}
			}
			
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				for(int i=0; i<6; i++) {
					if(node.z+dz[i]>=0&&node.z+dz[i]<H&&node.y+dy[i]>=0&&node.y+dy[i]<N&&node.x+dx[i]>=0&&node.x+dx[i]<M&&map[node.z+dz[i]][node.y+dy[i]][node.x+dx[i]] == 0) {
						result++;
						if(map[node.z][node.y][node.x]+1 > max) {
							max = map[node.z][node.y][node.x];
						}
						map[node.z+dz[i]][node.y+dy[i]][node.x+dx[i]] = map[node.z][node.y][node.x]+1;
						queue.add(new Node(node.z+dz[i],node.y+dy[i],node.x+dx[i]));
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