class Solution {
    public int solution(int n, int[] money) {
        
        //2차원 DP배열 선언
        //dp[i][j]에서 i는 사용한 화폐의 종류, j는 금액
        //가령 dp[2][5]의 경우 money[0], money[1], money[2]를 가지고
        //5원을 만들 수 있는 가짓수임
        
        int[][] dp = new int[money.length+1][n+1];
                
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                //금액이 0이면 편의상 1로 초기화
                if(j==0){
                    dp[i][j] = 1;
                }else{
                    //현재 합계를 구할 금액 j보다 큰 화폐들만 사용하는 경우
                    if(money[i-1]>j){
                        //결국 현재 사용하려는 화폐보다 1단계 적은
                        //화폐만으로 구성하는 경우의수와 동일
                	    dp[i][j] = dp[i-1][j];
                    }else if(money[i-1]==j){
                        //현재 사용하려는 화폐와 합계금액이 같은경우
                        //기존 가짓수에서 해당 화폐 하나만 사용하는 가짓수가 새로 추가됨
                        dp[i][j] = dp[i-1][j]+1;
                    }else {
                        //합계금액보다 더 작은 화폐들만 사용하는 경우
                        //현재 화폐로 j금액을 만들 수 있는 가짓수는
                        //현재 화폐들보다 1단계 적은 화폐만으로 구성하는 가짓수 +
                        //현재 화폐들로 구할 수 있는 남은 가짓수
                	    dp[i][j] = (dp[i-1][j] + dp[i][j-money[i-1]]) % 1000000007;
                    }
                }
            }
        }
        return dp[money.length][n];
    }
}