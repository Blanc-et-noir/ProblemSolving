import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	//lowerBound�� �ڽź��� ū ������ ���� �ּҰ�
	public static int getLowerBound(int[] arr,int n, int s, int e) {
		int m = (s+e)/2;
		if(s==e) {
			return m;
		}
		//arr[m]�� n���� �۴ٴ� ����, lowerBound�� �� �� ������ �ǹ�
		//8�� lowerBound�� �ּ� 9�̻��̾���ϴµ�, �߰����� 7���϶�� ���� Ž���� �ʿ����
		if(arr[m]<n) {
			return getLowerBound(arr,n,m+1,e);
		//arr[m]�� n���� ũ�ų� ���ٸ�, arr[m]�� lowerBound�� �� ���ɼ��� �����ϹǷ�
		//�ش� ���� �����Ͽ� �ٽ� �̺�Ž���� �ǽ��ؾ���
		}else{
			return getLowerBound(arr,n,s,m);
		}
	}
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] result = new int[N];
		String[] str = br.readLine().split(" ");
		
		for(int i=0;i<str.length;i++) {
			arr[i]=Integer.parseInt(str[i]);
		}
		
		result[0]=arr[0];
		int cnt=0;
		for(int i=1; i<arr.length; i++) {
			//�迭�� ����, �������� ���ĵ� �迭�� ������ ������ �۴ٸ�
			//�ش簪�� lowerBound�� ��ü�ϴ��� ������������ ������ ����
			if(result[cnt]>arr[i]) {
				int l = getLowerBound(result,arr[i],0,cnt);
				result[l]=arr[i];
			//�迭�� ���� �������� ���ĵ� �迭�� ������ ������ ũ��
			//���ĵ� �迭 ���� �߰��ϴ��� ������������ ���� ������ ����
			//��, result�迭���� LIS�ʹ� ������ ������ ������������ ���ĵ�
			//�� �ش信�� ���ϴ� ���� ���� �� ������ ������
			}else if(result[cnt]<arr[i]){
				result[++cnt] = arr[i];
			}

		}
		
		bw.write((cnt+1)+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}