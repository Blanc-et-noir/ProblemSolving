package BOJ.BRUTEFORCE.신입사원_1946;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

//배열 대신 노드를 활용
//A와 B는 각각 서류, 면접 등수
class Node{
	int A, B;
	Node(int A, int B){
		this.A=A;
		this.B=B;
	}
}

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			
			//우선순위큐에 등수의 절대값이 작은 값이 루트에 오도록 사용
			//기본값이 오름차순 정렬이므로 Comparator객체를 굳이 사용할 필요는 없음
			//서류점수로만 오름차순 정렬
			PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
				@Override
				public int compare(Node n1, Node n2) {
					if(n1.A < n2.A) {
						return -1;
					}else {
						return 1;
					}
				}	
			});
			
			//값을 입력받음
			for(int j=0; j<N;j++) {
				String[] str = br.readLine().split(" ");
				int A = Integer.parseInt(str[0]);
				int B = Integer.parseInt(str[1]);
				pq.add(new Node(A,B));
			}
			
			//가장 서류점수가 높은 사람의 정보를 얻음
			Node n = pq.poll();
			
			//그 사람의 면접점수를 얻음
			int lowest = n.B;
			int cnt = 0;
			
			while(!pq.isEmpty()) {
        
				//서류점수 등수가 바로 한 단계 아래인 사람의 면접 등수의 절대값이 더 크다면
				//서류점수 및 면접점수 모두 뒤떨어진다는 얘기이므로 탈락할 사람의 수를 증가시킴
				Node tn = pq.poll();
				if(tn.B>lowest) {
					cnt++;
				}else {
					//합격이라면 그 사람의 면접점수를 다시 기준점수로 삼음
					//즉, 다음에 탐색할 사람은, 일단 서류점수로는 바로 이전의 탐색대상보다
					//떨어지는 것이 확정이므로, 합격하기 위해서는, 바로 이전사람의 면접 등수보다
					//절대값이 작은, 즉 점수가 더 높아야만 합격할 수 있음
					lowest = tn.B;
				}
			}
			bw.write(N-cnt+"\n");
		}
		bw.flush();	
	}
}