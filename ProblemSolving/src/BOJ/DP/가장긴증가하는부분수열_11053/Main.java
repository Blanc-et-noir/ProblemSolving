import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	//lowerBound란 자신보다 큰 값들중 가장 최소값
	public static int getLowerBound(int[] arr,int n, int s, int e) {
		int m = (s+e)/2;
		if(s==e) {
			return m;
		}
		//arr[m]이 n보다 작다는 것은, lowerBound가 될 수 없음을 의미
		//8의 lowerBound는 최소 9이상이어야하는데, 중간값이 7이하라면 굳이 탐색할 필요없음
		if(arr[m]<n) {
			return getLowerBound(arr,n,m+1,e);
		//arr[m]이 n보다 크거나 같다면, arr[m]은 lowerBound가 될 가능성이 존재하므로
		//해당 값을 포함하여 다시 이분탐색을 실시해야함
		}else{
			return getLowerBound(arr,n,s,m);
		}
	}
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] result = new int[N];
		String[] str = br.readLine().split(" ");
		
		for(int i=0;i<str.length;i++) {
			arr[i]=Integer.parseInt(str[i]);
		}
		
		result[0]=arr[0];
		int cnt=0;
		for(int i=1; i<arr.length; i++) {
			//배열의 값이, 오름차순 정렬된 배열의 마지막 값보다 작다면
			//해당값을 lowerBound와 교체하더라도 오름차순에는 문제가 없음
			if(result[cnt]>arr[i]) {
				int l = getLowerBound(result,arr[i],0,cnt);
				result[l]=arr[i];
			//배열의 값이 오름차순 정렬된 배열의 마지막 값보다 크면
			//정렬된 배열 끝에 추가하더라도 오름차순에는 전혀 문제가 없음
			//단, result배열에는 LIS와는 무관한 값들이 오름차순으로 정렬됨
			//이 해답에서 구하는 것은 가장 긴 수열의 길이임
			}else if(result[cnt]<arr[i]){
				result[++cnt] = arr[i];
			}

		}
		
		bw.write((cnt+1)+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}