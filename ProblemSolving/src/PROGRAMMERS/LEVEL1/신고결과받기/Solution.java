class Solution {
	  
    //10진수 정수를 분석하여 지도의 한 행의 정보를
    //문자열로 출력하는 메소드
    public String func(int n, int b){
        String r = "";
        int m = 1;
        
        //정수 b의 MSB부터 LSB까지 비트를 분석함
        for(int i=n-1; i>=0; i--){
            //i번째 비트가 0이 아니라면 벽으로 처리
            if((b&(m<<i))!=0){
                r+="#";
            //i번째 비트가 0이라면 빈공간으로 처리
            }else{
                r+=" ";
            }
        }
        return r;
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[] arr3 = new int[n];
        
        //별다른 처리할 필요 없이 or연산을 함
        for(int i=0; i<n; i++){
            arr3[i] = arr1[i]|arr2[i];
            answer[i] = func(n,arr3[i]);
        }

        return answer;
    }
}