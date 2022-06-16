package BOJ.BRUTEFORCE.���Ի��_1946;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

//�迭 ��� ��带 Ȱ��
//A�� B�� ���� ����, ���� ���
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
			
			//�켱����ť�� ����� ���밪�� ���� ���� ��Ʈ�� ������ ���
			//�⺻���� �������� �����̹Ƿ� Comparator��ü�� ���� ����� �ʿ�� ����
			//���������θ� �������� ����
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
			
			//���� �Է¹���
			for(int j=0; j<N;j++) {
				String[] str = br.readLine().split(" ");
				int A = Integer.parseInt(str[0]);
				int B = Integer.parseInt(str[1]);
				pq.add(new Node(A,B));
			}
			
			//���� ���������� ���� ����� ������ ����
			Node n = pq.poll();
			
			//�� ����� ���������� ����
			int lowest = n.B;
			int cnt = 0;
			
			while(!pq.isEmpty()) {
        
				//�������� ����� �ٷ� �� �ܰ� �Ʒ��� ����� ���� ����� ���밪�� �� ũ�ٸ�
				//�������� �� �������� ��� �ڶ������ٴ� ����̹Ƿ� Ż���� ����� ���� ������Ŵ
				Node tn = pq.poll();
				if(tn.B>lowest) {
					cnt++;
				}else {
					//�հ��̶�� �� ����� ���������� �ٽ� ���������� ����
					//��, ������ Ž���� �����, �ϴ� ���������δ� �ٷ� ������ Ž����󺸴�
					//�������� ���� Ȯ���̹Ƿ�, �հ��ϱ� ���ؼ���, �ٷ� ��������� ���� �������
					//���밪�� ����, �� ������ �� ���ƾ߸� �հ��� �� ����
					lowest = tn.B;
				}
			}
			bw.write(N-cnt+"\n");
		}
		bw.flush();	
	}
}