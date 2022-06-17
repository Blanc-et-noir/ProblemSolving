import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int[] arr = new int[2000001];
	public static boolean[] flag = new boolean[2000001];
	public static Vector<Integer> v = new Vector<>();
	public static int size;
	
	//�ռ� ���Ϳ� 2*10^12�� ������ ������ �Ҽ����� ���صξ���
	public static boolean isPrime(long n) {
		int t;
		//v.size()�� v.get()�� �ݺ����� �״�γ����� �ð��ʰ�
		//����ؼ� �޼ҵ带 ȣ���ϴ� ������尡 ������
		for(int i=0; i<size&&n>=(t=v.get(i))*t;i++) {
			//� �� n���� ���� �Ҽ���� ����� 0���� ����������� n�� �Ҽ��� �ƴ�
			if(n%t==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		//���������� 2*10^12�� 1���� sqrt(2*10^12)���� ����� �Ҽ����� �ƴ��� �Ǻ��ϱ�� �����
		//�ð��� �ʹ� �����ɸ��⿡ �̸� ������ ������ �Ҽ����� ���� ���س��°���
		for(int i=2; i<=2000000;i++) {
			if(!flag[i]) {
				flag[i]=true;
				v.add(i);
			}
			for(int j=i*2; j<=2000000;j=j+i) {
				flag[j]=true;
			}
		}
		
		size = v.size();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			String[] str = br.readLine().split(" ");
			long A = Long.parseLong(str[0]);
			long B = Long.parseLong(str[1]);
			long S = A+B;
			
			//���� 2,3�̶�� ���� �Ҽ��� ������ ǥ�� �Ұ���
			if(S<4) {
				bw.write("NO\n");
			//���� ¦����� �������� ������ ���� ������ �Ҽ��� ������ ǥ�� ����
			}else if(S%2==0) {
				bw.write("YES\n");
			}else{
				//���� Ȧ�����, �ᱹ 2+Ȧ���μҼ��� �÷� ��Ÿ�� �� �ۿ� ����
				//��, 2�� �̹� �Ҽ��̹Ƿ� S-2�� �Ҽ��̱⸸ �ϸ� ��
				if(isPrime(S-2)) {
					bw.write("YES\n");
				}else {
					bw.write("NO\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}