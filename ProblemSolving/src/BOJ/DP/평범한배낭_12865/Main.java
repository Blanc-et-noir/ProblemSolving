package BOJ.DP.����ѹ賶_12865;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		int N, K;
		//�������� ������ DP�迭, dp[i][j]
		//i��°���� ��Ҹ� Ž���ؼ� j�� ������� ���� �� �ִ� �ִ� ��ġ v�� ������
		int[][] dp;
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
    
		//��ǰ�� �� ������ 100��, �ִ�� �� �� �ִ� ���Դ� 100000
		//���� ����ϱ� ���� 101, 100001�� ũ�⸦ ��Ƶ�
		dp = new int[101][100001];
		int[][] arr = new int[N+1][2]; 
		for(int i=1; i<=N; i++) {
			str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		}
		//i��° ��Һ��� Ž��
		for(int i=1; i<=N;i++) {
			//j�� ������� �ִ� �� �� �ִ� ���Ը� ã��
			for(int j=1; j<=100000;j++) {
				//���� �ڽ��� �� �� �ִ� ���Զ��
				if(arr[i][0]<=j) {
					//�������� Ž���������� ��ġ��, i��° ��ǰ���� ��� ä�������� ��ġ�� �� ũ�ٸ�
					//��, i-1���� j������� Ž�������� ��ġ > i-1���� Ž�������� j-arr[i][0]�� ��������� �ִ밡ġ + ���� ��ǰ�� ��ġ
					//�ᱹ i��°���� Ž���� �ִ� ��ġ�� ������ ����
					if(dp[i-1][j]>dp[i-1][j-arr[i][0]]+arr[i][1]) {
						dp[i][j]=dp[i-1][j];
					//�������� Ž���������� ��ġ����, i��° ��ǰ�� ��� ������������ ��ġ�� �� ũ�ٸ�
					}else {
						dp[i][j]=dp[i-1][j-arr[i][0]]+arr[i][1];
					}
				//���� ���Ѵٸ� i��°���� Ž���� ����� �ᱹ, �������� Ž���� ����� ����
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][K]);
		bw.flush();
		bw.close();
		br.close();
	}
}