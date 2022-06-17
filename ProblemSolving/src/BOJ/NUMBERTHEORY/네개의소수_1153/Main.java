import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int[] arr = new int[1000001];
	public static boolean[] flag = new boolean[1000001];
	public static Vector<Integer> v = new Vector<>();
	
	//������������ ���ĵ� �Ҽ����� ���� v���Ϳ��� ó���� ���� �Ҽ������ Ž������
	public static int[] getPrimes(int n) {
		int l=0, r=v.size()-1;
		//r>l�� �ƴ� r>=l�� ������ �ΰ��� �Ҽ��� ���� ���� �� �ֱ� ����
		//��, �Ҽ��� �ߺ��� ����ϱ� �����̴�
		while(r>=l) {
			int sum = v.get(l)+v.get(r);
			//�� �Ҽ��� ���� ���� ������ ������ ũ��
			if(sum>n) {
				//���� �پ�鵵�� r���� ���ҽ��� Ž���ǽ�
				r--;
			//�� �Ҽ��� ���� ���� ������ ������ ������
			}else if(sum<n){
				//���� �þ���� l���� �������� Ž���ǽ�
				l++;
			//�� �Ҽ��� ���� ���� ������ ���̸�
			}else {
				//�ش��ϴ� �Ҽ��� ������
				return new int[] {v.get(l),v.get(r)};
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		
		//�����佺�׳׽��� ü�� �̿��Ͽ� 1000000������ �Ҽ��� ��� ����
		for(int i=2;i<1000001;i++) {
			if(flag[i]) {
				continue;
			}else {
				v.add(i);
				flag[i]=true;
				for(int j=i;j<1000001;j=j+i) {
					flag[j]=true;
				}
			}
		}
		int arr[];
		
		//8���϶�� ����� 4���� �Ҽ� ������ ��Ÿ�� �� ����
		if(N<8) {
			bw.write("-1\n");
		}else {
			//�������� ���� 1
			//2���� ū ��� ¦���� 2���� �Ҽ��� ������ ��Ÿ�� �� �ִ�
			//�������� ���� 2
			//5���� ū ������ 3���� �Ҽ��� ������ ��Ÿ�� �� �ִ�
			
			//��, ¦���� �Է¹޾����� 2�� �� �� �� ����� N-4���õ� ¦����
			//N-4�� ¦���̹Ƿ� �������� ������ ���� �� ���� �Ҽ��� ��Ÿ�� �� �ִ�
			if(N%2==0) {
				arr = getPrimes(N-4);
				System.out.println("2 2 "+arr[0]+" "+arr[1]);
			
			//Ȧ���� �Է¹޾����� �� Ȧ������ 2, 3�� �� ���� �ݵ�� ¦����
			//N-5�� ¦���̹Ƿ� ������ ������ ���� �ΰ��� �Ҽ��� ������ ��Ÿ�� �� �ִ�
			}else {
				arr = getPrimes(N-5);
				System.out.println("2 3 "+arr[0]+" "+arr[1]);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}