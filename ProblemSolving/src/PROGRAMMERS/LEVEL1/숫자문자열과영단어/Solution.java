import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        //�ش� ���ڿ����� �迭�� �߰���
        String[] str = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        //�� ���ڿ����� ���ʷ� replaceAll( )�ϸ鼭 �׿� �ش��ϴ� �ε����� ��ü��
        for(int i=0; i<str.length; i++){
            s = s.replaceAll(str[i],i+"");
        }
        
        //�ش� ���ڿ��� ������ ��ȯ��
        answer = Integer.parseInt(s);
        return answer;
    }
}