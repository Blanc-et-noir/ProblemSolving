class Solution {
	  
    //10���� ������ �м��Ͽ� ������ �� ���� ������
    //���ڿ��� ����ϴ� �޼ҵ�
    public String func(int n, int b){
        String r = "";
        int m = 1;
        
        //���� b�� MSB���� LSB���� ��Ʈ�� �м���
        for(int i=n-1; i>=0; i--){
            //i��° ��Ʈ�� 0�� �ƴ϶�� ������ ó��
            if((b&(m<<i))!=0){
                r+="#";
            //i��° ��Ʈ�� 0�̶�� ��������� ó��
            }else{
                r+=" ";
            }
        }
        return r;
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int[] arr3 = new int[n];
        
        //���ٸ� ó���� �ʿ� ���� or������ ��
        for(int i=0; i<n; i++){
            arr3[i] = arr1[i]|arr2[i];
            answer[i] = func(n,arr3[i]);
        }

        return answer;
    }
}