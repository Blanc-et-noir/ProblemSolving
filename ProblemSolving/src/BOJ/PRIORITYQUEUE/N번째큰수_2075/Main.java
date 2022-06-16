package BOJ.PRIORITYQUEUE.N번째큰수_2075;

import java.util.Scanner;

class Heap{
	int[] heap;
	int N, size;
	Heap(int N){
		this.N = N;
		heap = new int[N*N];
		size = 0;
	}
	public int peek() {
		return heap[0];
	}
	public void insert(int num) {
		int child = size, parent = (child - 1) / 2, temp;
		heap[size++] = num;
		while(parent>=0) {
			if(heap[parent] > heap[child]) {
				temp = heap[parent];
				heap[parent] = heap[child];
				heap[child] = temp;
				child = parent;
				parent = (child-1)/2;
			}else {
				return;
			}
		}
	}
	public int remove() {
		int returnNum = heap[0];
		
		heap[0] = heap[--size];
		int temp, min, parent = 0, left = parent*2+1, right = left + 1;
		
		while(left<size&&right<size) {
			if(heap[left] > heap[right]) {
				min = right;
			}else {
				min = left;
			}
			if(heap[min] < heap[parent]) {
				temp = heap[parent];
				heap[parent] = heap[min];
				heap[min] = temp;
				parent = min;
				left = parent*2+1;
				right = left+1;
				
			}else {
				return returnNum;
			}
		}
		
		if(left<size) {
			if(heap[left] < heap[parent]) {
				temp = heap[parent];
				heap[parent] = heap[left];
				heap[left] = temp;
				return returnNum;
			}else {
				return returnNum;
			}
		}else {
			return returnNum;
		}
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String temp = sc.nextLine();
		int N = Integer.parseInt(temp);
		Heap h = new Heap(N*N);
		String str;
		String[] strArr;
		for(int i=0; i<N; i++) {
			str = sc.nextLine();
			strArr = str.split(" ");
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(strArr[j]);
				h.insert(num);
			}
		}
		for(int i=0; i<N*N-N; i++) {
			h.remove();
		}
		System.out.println(h.peek());
	}
}