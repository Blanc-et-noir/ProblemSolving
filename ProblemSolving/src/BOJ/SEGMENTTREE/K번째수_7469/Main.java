package BOJ.SEGMENTTREE.K번째수_7469;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

//val은 값, idx는 인덱스를 갖는 노드 클래스
class Node{
	int val, idx;
	Node(int val, int idx){
		this.val=val;
		this.idx=idx;
	}
}

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Node[] arr;
	
	public static void main(String[] args) throws Exception{
		String[] temp = br.readLine().split(" ");
		
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		
		temp = br.readLine().split(" ");
		
		arr = new Node[N];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = new Node(Integer.parseInt(temp[i]),i);
		}
		
		//노드들을 값을 기준으로 오름차순 정렬함
		Arrays.sort(arr,new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				if(n1.val<n2.val) {
					return -1;
				}else {
					return 1;
				}
			}
		});
		
		for(int i=0;i<M;i++) {
			temp = br.readLine().split(" ");
			int I = Integer.parseInt(temp[0])-1;
			int J = Integer.parseInt(temp[1])-1;
			int K = Integer.parseInt(temp[2])-1;
			int cnt=0;
			
			//arr배열은 이미 값을 기준으로 오름차순 정렬된 상태
			//이 상태에서 주어진 구간인 I, J사이의 인덱스를 가진 값이 있다면
			//카운트 변수를 1씩 증가시킴
			for(int j=0;j<arr.length;j++) {
				if(arr[j].idx>=I&&arr[j].idx<=J){
					cnt++;
				}
				//카운트 변수 -1이 주어진 K와 같으면 이 값이 곧
				//주어진 구간에서의 K번째 숫자임
				if(cnt-1==K) {
					bw.write(arr[j].val+"\n");
					break;
				}
			}
		}
		bw.flush();
	}
}