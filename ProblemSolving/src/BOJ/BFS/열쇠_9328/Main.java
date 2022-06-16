package BOJ.BFS.¿­¼è_9328;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int y,x;
	Node(int y, int x){
		this.y=y;
		this.x=x;
	}
}

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static char[][] m;
	public static HashMap<Character, Boolean> key;
	public static int BFS() {
		int tol = 'a'-'A';
		int[][] dist = {{-1,0},{1,0},{0,-1},{0,1}};
		int H = m.length, W = m[0].length,cnt=0;
		boolean[][] v = new boolean[H][W];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0));
		v[0][0]=true;
		while(!q.isEmpty()) {
			Node n = q.poll();
			for(int i=0; i<dist.length; i++) {
				int y = n.y+dist[i][0];
				int x = n.x+dist[i][1];
				if(y>=0&&y<H&&x>=0&&x<W&&!v[y][x]) {
					if(m[y][x]=='*') {
						continue;
					}
					if(m[y][x]=='.') {
						q.add(new Node(y,x));
						v[y][x]=true;
						continue;
					}
					char temp = (char) (m[y][x]+tol);
					if(m[y][x]>='A'&&m[y][x]<='Z'&&key.containsKey(temp)) {
						q.add(new Node(y,x));
						m[y][x]='.';
						v[y][x]=true;
						continue;
					}
					if(m[y][x]>='a'&&m[y][x]<='z') {
						key.put(m[y][x], true);
						m[y][x]='.';
						q.add(new Node(y,x));
						v=new boolean[H][W];
						v[y][x]=true;
						continue;
					}
					if(m[y][x]=='$') {
						cnt++;
						m[y][x]='.';
						q.add(new Node(y,x));
						v=new boolean[H][W];
						v[y][x]=true;
						continue;
					}
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine()), H, W;
		boolean[][][] arr = new boolean[100][100][2^26];
		for(int i=0; i<T; i++) {
			String[] str = br.readLine().split(" ");
			H = Integer.parseInt(str[0]);
			W = Integer.parseInt(str[1]);
			m = new char[H+2][W+2];
			for(int j=0; j<H+2; j++) {
				if(j!=0&&j!=H+1) {
					str = br.readLine().split("");	
				}
				for(int k=0; k<W+2; k++) {
					if(j==0||j==H+1||k==0||k==W+1) {
						m[j][k]='.';
					}else {
						m[j][k] = str[k-1].charAt(0);
					}
				}
			}
			str =br.readLine().split("");
			key = new HashMap<>();
			for(int j=0; j<str.length; j++) {
				if(!str[j].equals("0")) {
					key.put(str[j].charAt(0), true);
				}
			}
			int result = BFS();
			bw.write(result+"\n");			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}