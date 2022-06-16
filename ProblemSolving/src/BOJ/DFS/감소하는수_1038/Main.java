package BOJ.DFS.�����ϴ¼�_1038;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	
  //���� ���� ��Ʈ�� ��ġ�ϵ��� �켱����ť�� �����
	public static PriorityQueue<Long> pq = new PriorityQueue<Long>();
	
  //DFS
	public static void DFS(long num, int digit) {
    
    //���� ������ �� ���ڸ��� ������
		long val = num/digit;
    
    //9876543210�� ǥ���� �� �ִ� ���� ū �����ϴ� ���̹Ƿ�
    //�� �̻��� Ž���� �ʿ䰡 ����
		if(num>9876543210L) {
			return;
		}
    
    //���� ������ �� ���ڸ����� �� ū ���ڸ�
    //�� ���ڸ��� �߰��Ͽ� DFS Ž�� �ǽ�, �ڸ��� ���� �Ѵܰ� ������Ŵ
		for(long i=val+1;i<=9;i++) {
			pq.add(i*(digit*10)+num);
			DFS(i*(digit*10)+num,digit*10);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
    //ó�� 0, 1, 2, 3, ... 9���� 1�� �ڸ�����
    //�켱����ť�� �߰��� ���� ����
		for(long i=0; i<=9;i++) {
			pq.add(i);
      
      //DFSŽ�� �ǽ�
			DFS(i,1);
		}
		
    //0������ N-1��° ���ڸ� �켱���� ť���� ����
		for(int i=0;i<N;i++) {
			pq.poll();
		}
		
    //�켱����ť�� ��������� N��° �����ϴ� ���� ���� ���̰�
    //������ �� ���� �ٷ� N��° �����ϴ� ����
		if(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}else {
			System.out.println(-1);
		}
	}
}