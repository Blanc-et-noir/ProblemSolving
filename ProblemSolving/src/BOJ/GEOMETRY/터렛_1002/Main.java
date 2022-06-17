import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int solve(int x1, int y1, int r1, int x2, int y2, int r2) {
		//�Ÿ��� ���ϱ⺸�ٴ� �Ÿ��� ������ Ȱ����
		//�������� ��ǻ���� �Ǽ� ǥ��������� ���� ��Ȯ�� ���� ������ ���� �� �ֱ� ����
		
		//L�� �� ���� ���� �߽ɰ� �Ÿ��� ����
		int L = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
		
		//R�� �ΰ��� ���� ������ ���� ����
		int R = (r1+r2)*(r1+r2);
		
		//���� ������ �������� ������ ���Ѱ�
		if(x1==x2&&y1==y2&&r1==r2) {
			return -1;
		//���� ���� ū���� ���ο��� ������ �ʰų�, �ܺο��� ������ ������ ������ 0��
		}else if(L<(r1-r2)*(r1-r2)||R<L) {
			return 0;
		//�� ���� ���� �����ϰų� �����ϴ� ��� ������ 1��
		}else if((r1-r2)*(r1-r2)==L||R==L) {
			return 1;
		}else {
			return 2;
		}
	}
	
	public static void main(String[] args) throws Exception{
		String[] temp = br.readLine().split(" ");
		int T = Integer.parseInt(temp[0]);
		
		for(int i=0;i<T;i++) {
			temp = br.readLine().split(" ");
			int x1 = Integer.parseInt(temp[0]);
			int y1 = Integer.parseInt(temp[1]);
			int r1 = Integer.parseInt(temp[2]);
			int x2 = Integer.parseInt(temp[3]);
			int y2 = Integer.parseInt(temp[4]);
			int r2 = Integer.parseInt(temp[5]);
			bw.write(solve(x1,y1,r1,x2,y2,r2)+"\n");
		}
		bw.flush();
	}
}