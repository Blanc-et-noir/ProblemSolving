import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static char[][] arr;
	public static int R,C;
	public static int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
	public static int max = -1;
	public static void DFS(boolean[] v, int r, int c, int cnt) {
		if(cnt>max) {
			max = cnt;
		}
		for(int i=0; i<dist.length; i++) {
			int y = r + dist[i][0];
			int x = c + dist[i][1];
			if(y>=0&&y<R&&x>=0&&x<C&&!v[(arr[y][x]-'A')]) {
				v[(arr[y][x]-'A')] = true;
				DFS(v,y,x,cnt+1);
				v[(arr[y][x]-'A')] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		arr = new char[R][C];
		for(int i=0; i<R; i++) {
			str = br.readLine().split("");
			for(int j=0; j<C;j++) {
				arr[i][j]=str[j].charAt(0);
			}
		}
		boolean[] v = new boolean[26];
		v[(arr[0][0]-'A')]=true;
		DFS(v,0,0,1);
		bw.write(max+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}