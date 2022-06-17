import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception{
		String[] temp = br.readLine().split(" ");
		long A = Long.parseLong(temp[0]);
		long B = Long.parseLong(temp[1]);
		long V = Long.parseLong(temp[2]);
		
		//달팽이가 최초로 V미터 이상 올라갔을때의 걸린 시간을 D일 이라고 한다면
		//( A - B )*( D - 1 ) + A >= V를 만족하는 가장 작은 정수가 바로 D임
		bw.write((int)Math.ceil((V-B)*1.0/(A-B))+"\n");
		bw.flush();
	}
}