class Solution {
    public int solution(int[] numbers) {
        int sum = 45;
        
        //없는 숫자를 찾아내기 보다는
        //이미 존재하는 숫자들을 총합에서 뺌으로써
        //쉽게 없는 숫자들의 합을 계산함
        for(int n : numbers){
            sum -= n;
        }
        
        return sum;
    }
}