package BOJ.DP._1�θ����_1463;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		
		int X = Integer.parseInt(br.readLine());
		int[] arr = new int[1000001];
		Queue<Integer> q = new LinkedList<>();
		q.add(X);
		arr[X] = 0;
		while(!q.isEmpty()) {
			int n = q.poll();
			
			if(n==1) {
				bw.write(arr[n]+"\n");
				break;
			}
			//�ڿ��� X���� 1�� �Ǳ� ���ؼ� X�� 3���� �����ų�, 2�� �����ų�, 1�� ������
			//�̶� �迭 arr�� ��� ����, �� �ε����� �����ϱ����� �ʿ��� �ּҰ��� ��ϵǾ�����
			//��ġ ������� ������ Ǯ ���� ���� ��Ȳ, ������ �˰����� ������
			if(n%3==0&&arr[n/3]==0) {
				q.add(n/3);
				arr[n/3]=arr[n]+1;
			}
			if(n%2==0&&arr[n/2]==0) {
				q.add(n/2);
				arr[n/2]=arr[n]+1;
			}
			if(n-1>=0&&n-1<1000001&&arr[n-1]==0) {
				q.add(n-1);
				arr[n-1]=arr[n]+1;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}