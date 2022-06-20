import java.util.*;

class Solution {
	//�� �Ǽ��� �� ���� ���� ��ȯ�ϴ� �޼ҵ�
    public static double min(double a, double b){
        return a>b?b:a;
    }
    
    public long solution(int w, int h) {
        long answer = 0;
        
        //�� ���� Ž���� �ǽ���
        for(long i=0; i<w; i++){
            
        	//������ ������ y = ax�� ���Ͽ�
        	//x��ǥ�� i, i+1�� ���� �����Ͽ� y��ǥ�� ���ϰ�
        	//�ش� y��ǥ�� �Ҽ����� ���� ���߿� �� �������� �� ���� �Ʒ��� ��ġ��
        	//�������� �簢������ ���� �ǹ���
        	
        	//�̶� ���� h/w�� �̸� ����ϰ� �̸� ����ߴٰ��� 6�� �׽�Ʈ���̽��� ������� ���ϴµ�
        	//�̴� double �ڷ����� �Ǽ��� ��Ȯ�� ǥ������ ���ϴ� �Ѱ��� ������
        	//���� ��� ���� ���ϰ� w�� ������ ������ ������ �����Ŀ� x���� �����ϴ� ��ó��
        	//ǥ���ؾ߸� �������� �������� �� ����
            double l = Math.floor(h*i/w);
            double r = Math.floor(h*(i+1)/w);
            
            long m = (long) min(l,r);
            
            answer = answer + m;
        }
        
        //���� �Ʒ��� �����ϴ� �������� �簢���� �� x 2�� �ٷ� ��ü ������ �簢���� ����
        answer=answer*2;
        
        return answer;
    }
}