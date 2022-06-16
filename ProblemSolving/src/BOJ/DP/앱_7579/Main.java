package BOJ.DP.��_7579;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int M;
	public static int[][] apps;//i��° ��, j0�� �����ϰ��ִ� �޸�, j1�� �������
	public static int[][] dp;//i��°����Ž����, j��ŭ�� �������,  [i][j]��ŭ�� �޸�Ȯ��
	
	public static void main(String[] args) throws IOException{
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int min=0x7FFFFFFF;
    		//���� �� ���� 100, �� ���� ��������� 100�̹Ƿ� �־��� ��쿡 ��� ���� ��������� 100�̰� ���� �� 100���̸�
    		//����ؾ��� ��������� 100*100�� �� �� �ִµ�, ����ϱ� ���� +1�� �߰��� 101, 10001�� ����
		apps = new int[N+1][2];
		dp = new int[N+1][10001];
		str = br.readLine().split(" ");
		for(int i=1; i<=N;i++) {
			apps[i][0] = Integer.parseInt(str[i-1]);
		}
		str = br.readLine().split(" ");
		for(int i=1; i<=N;i++) {
			apps[i][1] = Integer.parseInt(str[i-1]);
		}
		//i��° �ۺ��� Ȯ��
		for(int i=1; i<=N; i++) {
      			//���0���� ���� �� �ִ� �ִ� �޸𸮺��� Ȯ��
			for(int j=0; j<10001;j++) {
        			//���� �ش� ���� ��������� j������� ������ �����ϴٸ�
				if(apps[i][1]<=j) {
          				//i������ ��ұ��� j������� ���� �� �ִ� �޸� �纸��
          				//i���� ��ұ��� j���-i��°����� ������� ���� �� �ִ� �޸𸮾� + �ش� ���� �����Ͽ� ������ �ִ� �޸𸮾��� �� ũ��
					if(dp[i-1][j]<dp[i-1][j-apps[i][1]]+apps[i][0]) {
            					//�װ����� ����
						dp[i][j] = dp[i-1][j-apps[i][1]]+apps[i][0];
          				//�ƴ϶�� i��° ��ұ��� j������� ���� �� �ִ� �ִ� �޸𸮾���
          				//i-1��° ��ұ��� j������� ���� �� �ִ� ��� ����.
					}else {
						dp[i][j] = dp[i-1][j];
					}
        			//���� �����Ű�µ� ����� j��뺸�� ũ�ٸ�
        			//�����ų �� �����Ƿ� i��° ��ұ��� j������� ��� �ִ� �޸𸮾���
        			//i-1��° ��ұ��� j������� ��� �ִ� �޸𸮾�� ����
				}else {
					dp[i][j] = dp[i-1][j];
				}
        			//���� i��° ��ұ��� j������� ���� �� �ִ� �޸𸮾��� �ʿ��� �纸�� ũ�ٸ�
        			//�׶� ���±����� �ּҺ�뺸�� �� ���� ������� ���� �� �ִٸ�
				if(dp[i][j]>=M&&min>j) {
          				//�ּҺ���� ����
					min = j;
				}
			}
		}
		
		bw.write(min+"\n");		
		bw.flush();
		bw.close();
		br.close();
	}
}