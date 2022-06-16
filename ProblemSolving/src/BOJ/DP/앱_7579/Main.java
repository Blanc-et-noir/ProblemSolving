package BOJ.DP.앱_7579;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int M;
	public static int[][] apps;//i번째 앱, j0은 차지하고있는 메모리, j1은 복구비용
	public static int[][] dp;//i번째까지탐색시, j만큼의 비용으로,  [i][j]만큼의 메모리확보
	
	public static void main(String[] args) throws IOException{
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int min=0x7FFFFFFF;
    		//앱의 총 수는 100, 각 앱의 복구비용은 100이므로 최악의 경우에 모든 앱의 복구비용이 100이고 앱이 총 100개이면
    		//사용해야할 복구비용은 100*100이 될 수 있는데, 계산하기 쉽게 +1씩 추가한 101, 10001로 설정
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
		//i번째 앱부터 확인
		for(int i=1; i<=N; i++) {
      			//비용0으로 얻을 수 있는 최대 메모리부터 확인
			for(int j=0; j<10001;j++) {
        			//만약 해당 앱의 복구비용이 j비용으로 감당이 가능하다면
				if(apps[i][1]<=j) {
          				//i이전의 요소까지 j비용으로 얻을 수 있는 메모리 양보다
          				//i이전 요소까지 j비용-i번째요소의 비용으로 얻을 수 있는 메모리양 + 해당 앱을 종료하여 얻을수 있는 메모리양이 더 크면
					if(dp[i-1][j]<dp[i-1][j-apps[i][1]]+apps[i][0]) {
            					//그것으로 갱신
						dp[i][j] = dp[i-1][j-apps[i][1]]+apps[i][0];
          				//아니라면 i번째 요소까지 j비용으로 얻을 수 있는 최대 메모리양은
          				//i-1번째 요소까지 j비용으로 얻을 수 있는 양과 같다.
					}else {
						dp[i][j] = dp[i-1][j];
					}
        			//앱을 종료시키는데 비용이 j비용보다 크다면
        			//종료시킬 수 없으므로 i번째 요소까지 j비용으로 얻는 최대 메모리양은
        			//i-1번째 요소까지 j비용으로 얻는 최대 메모리양과 같다
				}else {
					dp[i][j] = dp[i-1][j];
				}
        			//만약 i번째 요소까지 j비용으로 얻을 수 있는 메모리양이 필요한 양보다 크다면
        			//그때 여태까지의 최소비용보다 더 작은 비용으로 얻을 수 있다면
				if(dp[i][j]>=M&&min>j) {
          				//최소비용을 갱신
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