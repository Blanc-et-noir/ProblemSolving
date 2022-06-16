package BOJ.DP.평범한배낭_12865;

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
		//누적합을 저장할 DP배열, dp[i][j]
		//i번째까지 요소를 탐색해서 j의 비용으로 얻을 수 있는 최대 가치 v를 저장함
		int[][] dp;
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);
    
		//물품의 총 개수는 100개, 최대로 들 수 있는 무게는 100000
		//쉽게 계산하기 위해 101, 100001로 크기를 잡아둠
		dp = new int[101][100001];
		int[][] arr = new int[N+1][2]; 
		for(int i=1; i<=N; i++) {
			str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		}
		//i번째 요소부터 탐색
		for(int i=1; i<=N;i++) {
			//j의 비용으로 최대 들 수 있는 무게를 찾음
			for(int j=1; j<=100000;j++) {
				//만약 자신이 들 수 있는 무게라면
				if(arr[i][0]<=j) {
					//이전까지 탐색했을때의 가치가, i번째 물품으로 대신 채웠을때의 가치가 더 크다면
					//즉, i-1까지 j비용으로 탐색했을때 가치 > i-1까지 탐색했을때 j-arr[i][0]의 비용으로의 최대가치 + 현재 물품의 가치
					//결국 i번째까지 탐색한 최대 가치는 이전과 같음
					if(dp[i-1][j]>dp[i-1][j-arr[i][0]]+arr[i][1]) {
						dp[i][j]=dp[i-1][j];
					//이전까지 탐색했을때의 가치보다, i번째 물품을 대신 선택했을때의 가치가 더 크다면
					}else {
						dp[i][j]=dp[i-1][j-arr[i][0]]+arr[i][1];
					}
				//들지 못한다면 i번째까지 탐색한 결과는 결국, 그전까지 탐색한 결과와 같음
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