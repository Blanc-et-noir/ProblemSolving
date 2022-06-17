import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int solve(int x1, int y1, int r1, int x2, int y2, int r2) {
		//거리를 구하기보다는 거리의 제곱을 활용함
		//제곱근은 컴퓨터의 실수 표현방법으로 인해 정확한 값이 나오지 않을 수 있기 때문
		
		//L은 두 개의 원의 중심간 거리의 제곱
		int L = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
		
		//R은 두개의 원의 반지름 합의 제곱
		int R = (r1+r2)*(r1+r2);
		
		//원이 완전히 겹쳐지면 접점은 무한개
		if(x1==x2&&y1==y2&&r1==r2) {
			return -1;
		//작은 원이 큰원의 내부에서 접하지 않거나, 외부에서 접하지 않으면 접점은 0개
		}else if(L<(r1-r2)*(r1-r2)||R<L) {
			return 0;
		//두 원이 서로 내접하거나 외접하는 경우 접점은 1개
		}else if((r1-r2)*(r1-r2)==L||R==L) {
			return 1;
		}else {
			return 2;
		}
	}
	
	public static void main(String[] args) throws Exception{
		String[] temp = br.readLine().split(" ");
		int T = Integer.parseInt(temp[0]);
		
		for(int i=0;i<T;i++) {
			temp = br.readLine().split(" ");
			int x1 = Integer.parseInt(temp[0]);
			int y1 = Integer.parseInt(temp[1]);
			int r1 = Integer.parseInt(temp[2]);
			int x2 = Integer.parseInt(temp[3]);
			int y2 = Integer.parseInt(temp[4]);
			int r2 = Integer.parseInt(temp[5]);
			bw.write(solve(x1,y1,r1,x2,y2,r2)+"\n");
		}
		bw.flush();
	}
}