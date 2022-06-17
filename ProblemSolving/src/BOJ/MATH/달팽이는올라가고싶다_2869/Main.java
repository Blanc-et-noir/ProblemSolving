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
		
		//�����̰� ���ʷ� V���� �̻� �ö������� �ɸ� �ð��� D�� �̶�� �Ѵٸ�
		//( A - B )*( D - 1 ) + A >= V�� �����ϴ� ���� ���� ������ �ٷ� D��
		bw.write((int)Math.ceil((V-B)*1.0/(A-B))+"\n");
		bw.flush();
	}
}