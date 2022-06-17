import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] str = br.readLine().split(" ");
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int min = 0x7FFFFFFF, s=0, e=N-1;
		int ns=arr[0],ne=arr[N-1];
		while(s<e) {
			int sum = arr[s]+arr[e];
			int abs = Math.abs(sum);
			if(abs==0) {
				ns=arr[s];
				ne=arr[e];
				break;
			}else if(abs<min) {
				min = abs;
				ns = arr[s];
				ne = arr[e];
			}else {
				if(sum>0) {
					e--;
				}else {
					s++;
				}
			}
		}
		bw.write(ns+" "+ne+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}