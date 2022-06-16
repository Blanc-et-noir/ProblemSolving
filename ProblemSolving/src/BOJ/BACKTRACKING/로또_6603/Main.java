package BOJ.BACKTRACKING.·Î¶Ç_6603;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void combination(String[] arr, int idx, int n, String str) throws IOException{
		if(n==6) {
			sb.append(str+"\n");
		}else {
			for(int i=idx; i<arr.length; i++) {
				combination(arr, i+1, n+1, str+arr[i]+" ");

			}
		}
	}
	public static void main(String[] args) throws IOException{
		boolean first = true;
		Scanner sc = new Scanner(System.in);
		while(true) {

			String temp = sc.nextLine();

			if(temp.equals("0")) {
				System.out.print(sb.deleteCharAt(sb.length()-1).toString());
				return;
			}
			if(first == true) {
				first=false;
			}else {
				sb.append("\n");
			}
			String[] str = Arrays.copyOfRange(temp.split(" "), 1, temp.split(" ").length);
			combination(str,0,0,"");
		}
	}
}