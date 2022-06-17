import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int[] arr = new int[2000001];
	public static boolean[] flag = new boolean[2000001];
	public static Vector<Integer> v = new Vector<>();
	public static int size;
	
	//앞서 벡터에 2*10^12의 제곱근 이하의 소수들을 구해두었음
	public static boolean isPrime(long n) {
		int t;
		//v.size()나 v.get()을 반복문에 그대로넣으면 시간초과
		//계속해서 메소드를 호출하는 오버헤드가 존재함
		for(int i=0; i<size&&n>=(t=v.get(i))*t;i++) {
			//어떤 수 n보다 작은 소수들로 나누어서 0으로 나누어떨어지면 n은 소수가 아님
			if(n%t==0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		//현실적으로 2*10^12를 1부터 sqrt(2*10^12)까지 나누어서 소수인지 아닌지 판별하기는 어려움
		//시간이 너무 오래걸리기에 미리 제곱근 이하의 소수들을 먼저 구해놓는것임
		for(int i=2; i<=2000000;i++) {
			if(!flag[i]) {
				flag[i]=true;
				v.add(i);
			}
			for(int j=i*2; j<=2000000;j=j+i) {
				flag[j]=true;
			}
		}
		
		size = v.size();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			String[] str = br.readLine().split(" ");
			long A = Long.parseLong(str[0]);
			long B = Long.parseLong(str[1]);
			long S = A+B;
			
			//합이 2,3이라면 절대 소수의 합으로 표현 불가능
			if(S<4) {
				bw.write("NO\n");
			//합이 짝수라면 골드바흐의 추측에 의해 무조건 소수의 합으로 표현 가능
			}else if(S%2==0) {
				bw.write("YES\n");
			}else{
				//합이 홀수라면, 결국 2+홀수인소수의 꼴로 나타낼 수 밖에 없다
				//즉, 2는 이미 소수이므로 S-2가 소수이기만 하면 됨
				if(isPrime(S-2)) {
					bw.write("YES\n");
				}else {
					bw.write("NO\n");
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}