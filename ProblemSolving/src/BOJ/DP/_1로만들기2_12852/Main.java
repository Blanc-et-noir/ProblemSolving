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
		String[] str = new String[1000001];
		Queue<Integer> q = new LinkedList<>();
		q.add(X);
		arr[X] = 0;
		str[X] = X+"";
		
		//��ü�����δ� ������� ������ ������
		//X���� 1�� �����ϴµ� �ɸ��� �ּ� ��θ� �� �迭�� �ε����� ������
		//�迭�� Ư�� �ε����� ���� 0�� �ƴϸ� �̹� �ִܰ�η� �Ծ��� ����̹Ƿ� ������
		while(!q.isEmpty()) {
			int n = q.poll();
			if(n==1) {
				bw.write(arr[n]+"\n");
				bw.write(str[n]+"\n");
				break;
			}
			if(n%3==0&&arr[n/3]==0) {
				q.add(n/3);
				arr[n/3]=arr[n]+1;
				str[n/3]=str[n]+" "+(n/3);
			}
			if(n%2==0&&arr[n/2]==0) {
				q.add(n/2);
				arr[n/2]=arr[n]+1;
				str[n/2]=str[n]+" "+(n/2);
			}
			if(n-1>=0&&n-1<1000001&&arr[n-1]==0) {
				q.add(n-1);
				arr[n-1]=arr[n]+1;
				str[n-1]=str[n]+" "+(n-1);
			}
			//�ش� ��ο� �����ϱ� ���� ��θ� ""�� �ʱ�ȭ���� ������ �޸� �ʰ� �߻�
			//null�� �ʱ�ȭ �Ͽ��� ��
			str[n]="";
		}
		bw.flush();
		bw.close();
		br.close();
	}
}