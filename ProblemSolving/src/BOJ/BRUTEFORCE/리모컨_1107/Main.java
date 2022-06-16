package BOJ.BRUTEFORCE.¸®¸ğÄÁ_1107;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class Main {
	public static int dif=0x7FFFFFFF;
	public static String s;
	public static void DFS(String[] str, String[] arr,String result,int cnt) {
		if(result.length()==cnt) {
			int num = Integer.parseInt(result)-Integer.parseInt(String.join("", str));
			if((num>0?num:num*-1)<dif) {
				s = result;
				dif = (num>0?num:num*-1);
			}
			return;
		}
		for(int i=0; i<arr.length; i++) {
			DFS(str, arr, result+arr[i],cnt);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str = br.readLine().split("");
		int N = Integer.parseInt(br.readLine());
		String[] numArr=null;
		if(N!=0) {
			numArr = br.readLine().split(" ");
		}
		Vector<String> v = new Vector<>();
		if(N==10) {
			int num = Integer.parseInt(String.join("", str))-100;
			System.out.println(num>0?num:num*-1);
			return;
		}else {
			String[] arr = new String[10-N];
			for(int i=0; i<=9;i++) {
				v.add(Integer.toString(i));
			}
			for(int i=0; numArr!=null&&i<numArr.length; i++) {
				v.remove(numArr[i]);
			}
			arr = (String[])v.toArray(arr);
			for(int i=1; i<=7;i++) {
				DFS(str,arr,"",i);
			}

			if(Math.abs(Integer.parseInt(String.join("", str))-100)<str.length+Math.abs(dif)) {
				System.out.println(Math.abs(Integer.parseInt(String.join("", str))-100));
			}else {
				System.out.println(Math.abs(s.length()+Math.abs(dif)));
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}