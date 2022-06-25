import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        //해당 문자열들을 배열에 추가함
        String[] str = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        //이 문자열들을 차례로 replaceAll( )하면서 그에 해당하는 인덱스로 교체함
        for(int i=0; i<str.length; i++){
            s = s.replaceAll(str[i],i+"");
        }
        
        //해당 문자열을 정수로 변환함
        answer = Integer.parseInt(s);
        return answer;
    }
}