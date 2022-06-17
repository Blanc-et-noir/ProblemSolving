import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		int X = Integer.parseInt(br.readLine());
		int[] arr = new int[1000001];
		String[] str = new String[1000001];
		Queue<Integer> q = new LinkedList<>();
		q.add(X);
		arr[X] = 0;
		str[X] = X+"";
		
		//전체적으로는 술래잡기 문제와 동일함
		//X에서 1로 도달하는데 걸리는 최소 경로를 각 배열의 인덱스에 저장함
		//배열의 특정 인덱스의 값이 0이 아니면 이미 최단경로로 왔었던 장소이므로 무시함
		while(!q.isEmpty()) {
			int n = q.poll();
			if(n==1) {
				bw.write(arr[n]+"\n");
				bw.write(str[n]+"\n");
				break;
			}
			if(n%3==0&&arr[n/3]==0) {
				q.add(n/3);
				arr[n/3]=arr[n]+1;
				str[n/3]=str[n]+" "+(n/3);
			}
			if(n%2==0&&arr[n/2]==0) {
				q.add(n/2);
				arr[n/2]=arr[n]+1;
				str[n/2]=str[n]+" "+(n/2);
			}
			if(n-1>=0&&n-1<1000001&&arr[n-1]==0) {
				q.add(n-1);
				arr[n-1]=arr[n]+1;
				str[n-1]=str[n]+" "+(n-1);
			}
			//해당 경로에 도달하기 위한 경로를 ""로 초기화하지 않으면 메모리 초과 발생
			//null로 초기화 하여도 됨
			str[n]="";
		}
		bw.flush();
		bw.close();
		br.close();
	}
}