import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static boolean isPrime(int num) {
		if(num==1) {
			return false;
		}
		for(int i=2; i<=Math.sqrt(num);i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split(" ");
		int s = Integer.parseInt(str[0]), e = Integer.parseInt(str[1]);
		for(int i=s; i<=e; i++) {
			if(isPrime(i)) {
				bw.write(i+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}