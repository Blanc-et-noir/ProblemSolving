import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Shark{
	int y,x,level, exp, time;
	Shark(int y, int x, int level, int exp, int time){
		this.y = y;
		this.x = x;
		this.level = level;
		this.exp = exp;
		this.time = time;
		if(this.level==this.exp) {
			this.level++;
			this.exp=0;
		}
	}
}
class Fish{
	int y,x,d;
	Fish(int y, int x, int d){
		this.y = y;
		this.x = x;
		this.d = d;
	}
}
public class Main {
	public static Fish findFish(int[][] map, Shark s) {
		Queue<Shark> q = new LinkedList<>();
		boolean visited[][] = new boolean[map.length][map.length];
		PriorityQueue<Fish> pq = new PriorityQueue<>(new Comparator<Fish>() {
			@Override
			public int compare(Fish o1, Fish o2) {
				
				if(o1.d>o2.d) {
					return 1;
				}else if(o1.d<o2.d) {
					return -1;
				}else {
					if(o1.y>o2.y) {
						return 1;
					}else if(o1.y<o2.y) {
						return -1;
					}else {
						if(o1.x>o2.y) {
							return 1;
						}else if(o1.x<o2.x) {
							return -1;
						}else {
							return 0;
						}
					}
				}
			}			
		});
		
		int[][] dist = {{-1,0},{0,-1},{1,0},{0,1}};
		q.add(new Shark(s.y,s.x,s.level,s.exp,0));
		visited[s.y][s.x] = true;
		while(!q.isEmpty()) {
			Shark ts = q.poll();
			int y, x;
			for(int i=0; i<dist.length; i++) {
				y = ts.y+dist[i][0];
				x = ts.x+dist[i][1];
				if(y>=0&&y<map.length&&x>=0&&x<map.length&&visited[y][x]==false) {
					if(map[y][x]>0&&map[y][x]<7&&map[y][x]<ts.level) {
						pq.add(new Fish(y,x,ts.time+1));
						q.add(new Shark(y,x,ts.level,ts.exp+1,ts.time+1));
						visited[y][x]=true;
					}else if(map[y][x]==0||map[y][x]==ts.level) {
						q.add(new Shark(y,x,ts.level,ts.exp,ts.time+1));
						visited[y][x]=true;
					}
				}
			}
		}
		if(pq.size()>0) {
			return pq.poll();
		}else {
			return null;
		}		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Shark> q = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		boolean[][] visited = new boolean[N][N];
		int[][] map = new int[N][N];
		int[] fishArr = new int[7];
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<str.length; j++) {
				int num = Integer.parseInt(str[j]);
				map[i][j] = num;
				if(num==9) {
					q.add(new Shark(i,j,2,0,0));
					visited[i][j] = true;
					map[i][j]=0;
				}
			}
		}
		int[][] dist = {{-1,0},{0,-1},{1,0},{0,1}};
		while(!q.isEmpty()) {
			Shark s = q.poll();
			Fish f = findFish(map, s);
			if(f!=null) {
				map[f.y][f.x] = 0;
				q.add(new Shark(f.y,f.x, s.level, s.exp+1, s.time+f.d));
			}else {
				System.out.println(s.time);
				break;
			}
		}		
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}