package BOJ.DP._1로만들기_1463;

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
		Queue<Integer> q = new LinkedList<>();
		q.add(X);
		arr[X] = 0;
		while(!q.isEmpty()) {
			int n = q.poll();
			
			if(n==1) {
				bw.write(arr[n]+"\n");
				break;
			}
			//자연수 X에서 1이 되기 위해서 X를 3으로 나누거나, 2로 나누거나, 1을 빼야함
			//이때 배열 arr에 담긴 값은, 그 인덱스에 도달하기위해 필요한 최소값이 기록되어있음
			//마치 술래잡기 문제를 풀 때와 같은 상황, 동일한 알고리즘을 적용함
			if(n%3==0&&arr[n/3]==0) {
				q.add(n/3);
				arr[n/3]=arr[n]+1;
			}
			if(n%2==0&&arr[n/2]==0) {
				q.add(n/2);
				arr[n/2]=arr[n]+1;
			}
			if(n-1>=0&&n-1<1000001&&arr[n-1]==0) {
				q.add(n-1);
				arr[n-1]=arr[n]+1;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}