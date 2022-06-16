package BOJ.SEGMENTTREE.최솟값과최댓값_2357;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int[] mintree = new int[300000];
	public static int[] maxtree = new int[300000];
	public static int[] arr;
	
	//세그먼트 트리를 초기화 하는 메소드
	public static void init(int[] tree, int node, int start, int end, boolean isMin) {
		//해당 노드가 저장하는 구간의 시작과 끝이 같다면 리프노드이므로
		//리프노드에 해당 값을 추가함
		if(start==end) {
			tree[node] = arr[start];
		}else {
			//리프노드가 아니라면, 왼쪽, 오른쪽 자식에 대해 메소드를 재귀호출
			init(tree,node*2,start,(start+end)/2,isMin);
			init(tree,node*2+1,(start+end)/2+1,end,isMin);
			//만약 최소값을 저장하는 트리라면 두 자식들이 가진 구간들의 최소값중 더 작은 값을 저장하고
			//최대값을 저장하는 트리라면 두 자식들이 가진 구간들의 최대값중 더 큰 값을 저장
			if(isMin) {
				tree[node] = Math.min(tree[node*2], tree[node*2+1]);
			}else {
				tree[node] = Math.max(tree[node*2], tree[node*2+1]);
			}
		}
	}
	
	//해당 구간에 대해 최소값 혹은 최대값을 찾는 메소드
	public static int query(int[] tree, int node, int start, int end,int left, int right, boolean isMin) {
		//찾고자 하는 범위와 노드가 가진 구간이 겹치지 않으면 굳이 탐색할 필요 없음
		if(left>end || right<start) {
			return -1;
		}
		//찾고자 하는 범위가 해당 노드가 가진 구간을 완전히 포함하고 있으면 그 값을 리턴
		if(left<=start && right>=end) {
			return tree[node];
		}
		//앞의 두 조건문에서 리턴하지 않았다면 구간과 탐색할 범위가 서로 겹쳐있거나
		//탐색할 범위보다 노드가 가진 구간이 더 크다는 의미이므로 다시 탐색을 진행
		int lnum = query(tree,node*2,start,(start+end)/2,left,right,isMin);
		int rnum = query(tree,node*2+1,(start+end)/2+1,end,left,right,isMin);
		
		//최소값, 최대값을 저장하는 세그먼트 트리중 어떤 것인지 먼저 구분한 후에
		//최소값 또는 최대값을 리턴함
		if(isMin) {
	        if (lnum == -1) {
	            return rnum;
	        } else if (rnum == -1) {
	            return lnum;
	        } else {
	            return Math.min(lnum, rnum);
	        }
		}else {
	        if (lnum == -1) {
	            return rnum;
	        } else if (rnum == -1) {
	            return lnum;
	        } else {
	            return Math.max(lnum, rnum);
	        }
		}
	}
	
	public static void main(String[] args) throws Exception{

		String[] temp = br.readLine().split(" ");
		
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//세그먼트 트리를 설정하는데, 각 노드가 자신이 관리하는 구간중에서
		//가장 작은값 또는 가장 큰 값을 갖도록 하기 위하여 isMin 인자를 전달
		init(mintree,1,0,N-1,true);
		init(maxtree,1,0,N-1,false);
		
		for(int i=0;i<M;i++) {
			temp = br.readLine().split(" ");
			int left = Integer.parseInt(temp[0]);
			int right = Integer.parseInt(temp[1]);
			bw.write(query(mintree,1, 0, N-1,left-1, right-1, true)+" "+query(maxtree,1, 0, N-1,left-1, right-1, false)+"\n");
		}
		bw.flush();
	}
}