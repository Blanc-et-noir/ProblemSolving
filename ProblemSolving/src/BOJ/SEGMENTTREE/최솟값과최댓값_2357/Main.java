package BOJ.SEGMENTTREE.�ּڰ����ִ�_2357;

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
	
	//���׸�Ʈ Ʈ���� �ʱ�ȭ �ϴ� �޼ҵ�
	public static void init(int[] tree, int node, int start, int end, boolean isMin) {
		//�ش� ��尡 �����ϴ� ������ ���۰� ���� ���ٸ� ��������̹Ƿ�
		//������忡 �ش� ���� �߰���
		if(start==end) {
			tree[node] = arr[start];
		}else {
			//������尡 �ƴ϶��, ����, ������ �ڽĿ� ���� �޼ҵ带 ���ȣ��
			init(tree,node*2,start,(start+end)/2,isMin);
			init(tree,node*2+1,(start+end)/2+1,end,isMin);
			//���� �ּҰ��� �����ϴ� Ʈ����� �� �ڽĵ��� ���� �������� �ּҰ��� �� ���� ���� �����ϰ�
			//�ִ밪�� �����ϴ� Ʈ����� �� �ڽĵ��� ���� �������� �ִ밪�� �� ū ���� ����
			if(isMin) {
				tree[node] = Math.min(tree[node*2], tree[node*2+1]);
			}else {
				tree[node] = Math.max(tree[node*2], tree[node*2+1]);
			}
		}
	}
	
	//�ش� ������ ���� �ּҰ� Ȥ�� �ִ밪�� ã�� �޼ҵ�
	public static int query(int[] tree, int node, int start, int end,int left, int right, boolean isMin) {
		//ã���� �ϴ� ������ ��尡 ���� ������ ��ġ�� ������ ���� Ž���� �ʿ� ����
		if(left>end || right<start) {
			return -1;
		}
		//ã���� �ϴ� ������ �ش� ��尡 ���� ������ ������ �����ϰ� ������ �� ���� ����
		if(left<=start && right>=end) {
			return tree[node];
		}
		//���� �� ���ǹ����� �������� �ʾҴٸ� ������ Ž���� ������ ���� �����ְų�
		//Ž���� �������� ��尡 ���� ������ �� ũ�ٴ� �ǹ��̹Ƿ� �ٽ� Ž���� ����
		int lnum = query(tree,node*2,start,(start+end)/2,left,right,isMin);
		int rnum = query(tree,node*2+1,(start+end)/2+1,end,left,right,isMin);
		
		//�ּҰ�, �ִ밪�� �����ϴ� ���׸�Ʈ Ʈ���� � ������ ���� ������ �Ŀ�
		//�ּҰ� �Ǵ� �ִ밪�� ������
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
		
		//���׸�Ʈ Ʈ���� �����ϴµ�, �� ��尡 �ڽ��� �����ϴ� �����߿���
		//���� ������ �Ǵ� ���� ū ���� ������ �ϱ� ���Ͽ� isMin ���ڸ� ����
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