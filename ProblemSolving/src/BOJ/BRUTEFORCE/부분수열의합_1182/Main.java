import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	public static int count=0;
	public static void DFS(int result, String[] arr,boolean[] v,int sum,int idx, int cnt, int max) {
		if(cnt == max) {
			if(result == sum) {
				count++;
			}
			return;
		}else {
			for(int i=idx; i<arr.length; i++) {
				DFS(result, arr,v,sum+Integer.parseInt(arr[i]),i+1,cnt+1,max);		
			}
			
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int S = Integer.parseInt(str[1]);
		String[] arr = br.readLine().split(" ");
		for(int i=1; i<=N; i++) {
			DFS(S,arr,new boolean[arr.length],0,0,0,i);
		}
		System.out.println(count);
		bw.flush();
		bw.close();
		br.close();
	}
}