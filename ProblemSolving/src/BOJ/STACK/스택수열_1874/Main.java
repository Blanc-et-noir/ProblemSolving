package BOJ.STACK.스택수열_1874;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		Stack<Integer> s = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		int arr[];
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		int num=1,index=0;
		while(num<=N) {
			if(s.isEmpty()) {
				s.push(num);
				num++;
				sb.append("+\n");
			}else{
				if(s.peek()==arr[index]) {
					s.pop();
					sb.append("-\n");
					index++;
				}else {
					s.push(num);
					sb.append("+\n");
					num++;
				}
			}
		}
		int size = s.size();
		for(int i=0; i<size; i++) {
			if(s.pop()!=arr[index]) {
				System.out.println("NO");
				return;
			}else {
				sb.append("-\n");
			}
			index++;
		}
		System.out.println(sb.toString());
		br.close();
		bw.close();
	}

}