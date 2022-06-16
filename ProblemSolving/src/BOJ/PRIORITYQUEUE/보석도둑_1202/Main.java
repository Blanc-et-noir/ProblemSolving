package BOJ.PRIORITYQUEUE.º¸¼®µµµÏ_1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Jewel{
	int m, v;
	Jewel(int m, int v){
		this.m = m;
		this.v = v;
	}
}
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> bq = new PriorityQueue<>();
		PriorityQueue<Jewel> jq = new PriorityQueue<>(new Comparator<Jewel>(){
			@Override
			public int compare(Jewel o1, Jewel o2) {
				if(o1.m>o2.m) {
					return 1;
				}else if(o1.m<o2.m) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		int N,K;
		String[] temp = br.readLine().split(" ");
		String str;
		N = Integer.parseInt(temp[0]);
		K = Integer.parseInt(temp[1]);
		
		for(int i=0; i<N; i++) {
			temp = br.readLine().split(" ");
			jq.add(new Jewel(Integer.parseInt(temp[0]),Integer.parseInt(temp[1])));
		}
		
		for(int i=0; i<K; i++) {
			bq.add(Integer.parseInt(br.readLine()));
		}
		PriorityQueue<Jewel> vq = new PriorityQueue<>(new Comparator<Jewel>(){
			@Override
			public int compare(Jewel o1, Jewel o2) {
				if(o1.v>o2.v) {
					return -1;
				}else if(o1.v<o2.v) {
					return 1;
				}else {
					return 0;
				}
			}
		});
		long sum=0;
		while(!bq.isEmpty()) {
			int bag = bq.poll();

			int val;
			while(jq.size()>0&&jq.peek().m<=bag) {
				vq.add(jq.poll());
			}
			if(vq.size()!=0) {
				sum+=vq.poll().v;
			}
		}
		System.out.println(sum);
	}
}