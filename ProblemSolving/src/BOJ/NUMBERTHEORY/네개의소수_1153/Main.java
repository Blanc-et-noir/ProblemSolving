import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int[] arr = new int[1000001];
	public static boolean[] flag = new boolean[1000001];
	public static Vector<Integer> v = new Vector<>();
	
	//오름차순으로 정렬된 소수들의 집합 v벡터에서 처음과 끝의 소수들부터 탐색시작
	public static int[] getPrimes(int n) {
		int l=0, r=v.size()-1;
		//r>l이 아닌 r>=l인 이유는 두개의 소수가 서로 같을 수 있기 때문
		//즉, 소수의 중복을 허용하기 때문이다
		while(r>=l) {
			int sum = v.get(l)+v.get(r);
			//두 소수를 더한 값이 목적한 값보다 크면
			if(sum>n) {
				//합이 줄어들도록 r값을 감소시켜 탐색실시
				r--;
			//두 소수를 더한 값이 목적한 값보다 작으면
			}else if(sum<n){
				//합이 늘어나도록 l값을 증가시켜 탐색실시
				l++;
			//두 소수를 더한 값이 목적한 값이면
			}else {
				//해당하는 소수를 리턴함
				return new int[] {v.get(l),v.get(r)};
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		
		//에라토스테네스의 체를 이용하여 1000000이하의 소수를 모두 구함
		for(int i=2;i<1000001;i++) {
			if(flag[i]) {
				continue;
			}else {
				v.add(i);
				flag[i]=true;
				for(int j=i;j<1000001;j=j+i) {
					flag[j]=true;
				}
			}
		}
		int arr[];
		
		//8이하라면 절대로 4개의 소수 합으로 나타낼 수 없다
		if(N<8) {
			bw.write("-1\n");
		}else {
			//골드바흐의 추측 1
			//2보다 큰 모든 짝수는 2개의 소수의 합으로 나타낼 수 있다
			//골드바흐의 추측 2
			//5보다 큰 정수는 3개의 소수의 합으로 나타낼 수 있다
			
			//즉, 짝수를 입력받았을때 2를 두 번 뺀 결과인 N-4역시도 짝수다
			//N-4는 짝수이므로 골드바흐의 추측에 의해 두 개의 소수로 나타낼 수 있다
			if(N%2==0) {
				arr = getPrimes(N-4);
				System.out.println("2 2 "+arr[0]+" "+arr[1]);
			
			//홀수를 입력받았을때 이 홀수에서 2, 3을 뺀 값은 반드시 짝수다
			//N-5가 짝수이므로 골드바흐 추측에 의해 두개의 소수의 합으로 나타낼 수 있다
			}else {
				arr = getPrimes(N-5);
				System.out.println("2 3 "+arr[0]+" "+arr[1]);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}