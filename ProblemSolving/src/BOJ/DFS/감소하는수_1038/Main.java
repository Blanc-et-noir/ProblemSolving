package BOJ.DFS.감소하는수_1038;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	
  //작은 값이 루트에 위치하도록 우선순위큐를 사용함
	public static PriorityQueue<Long> pq = new PriorityQueue<Long>();
	
  //DFS
	public static void DFS(long num, int digit) {
    
    //현재 숫자의 맨 앞자리를 가져옴
		long val = num/digit;
    
    //9876543210은 표현할 수 있는 가장 큰 감소하는 수이므로
    //이 이상은 탐색할 필요가 없음
		if(num>9876543210L) {
			return;
		}
    
    //현재 숫자의 맨 앞자리보다 더 큰 숫자를
    //맨 앞자리에 추가하여 DFS 탐색 실시, 자릿수 또한 한단계 증가시킴
		for(long i=val+1;i<=9;i++) {
			pq.add(i*(digit*10)+num);
			DFS(i*(digit*10)+num,digit*10);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
    //처음 0, 1, 2, 3, ... 9등의 1의 자리수는
    //우선순위큐에 추가가 되지 않음
		for(long i=0; i<=9;i++) {
			pq.add(i);
      
      //DFS탐색 실시
			DFS(i,1);
		}
		
    //0번부터 N-1번째 숫자를 우선순위 큐에서 제거
		for(int i=0;i<N;i++) {
			pq.poll();
		}
		
    //우선순위큐가 비어있으면 N번째 감소하는 수가 없는 것이고
    //있으면 그 수가 바로 N번째 감소하는 수임
		if(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}else {
			System.out.println(-1);
		}
	}
}