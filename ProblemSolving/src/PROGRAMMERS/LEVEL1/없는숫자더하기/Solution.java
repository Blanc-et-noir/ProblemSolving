class Solution {
    public int solution(int[] numbers) {
        int sum = 45;
        
        //���� ���ڸ� ã�Ƴ��� ���ٴ�
        //�̹� �����ϴ� ���ڵ��� ���տ��� �����ν�
        //���� ���� ���ڵ��� ���� �����
        for(int n : numbers){
            sum -= n;
        }
        
        return sum;
    }
}