import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(br.readLine()), X;

		for(int i=0; i<N; i++) {
			X = Integer.parseInt(br.readLine());
			if(X==0) {
				if(pq.size()!=0) {
					bw.write(pq.poll()+"\n");
				}else {
					bw.write(0+"\n");
				}
			}else {
				pq.add(X);
			}
		}
		bw.flush();
		bw.close();
		br.close();
		sc.close();
		
	}

}