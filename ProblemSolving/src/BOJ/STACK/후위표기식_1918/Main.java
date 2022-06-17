import java.util.Scanner;

class Stack<T>{
	int top,size,capacity;
	T[] arr;
	Stack(int capacity){
		this.capacity = capacity;
		this.top = 0;
		this.size = 0;
		arr = (T[])new Object[capacity];
	}
	public void push(T data) {
		arr[top++]=data;
		size++;
	}
	public T pop() {
		T result = arr[--top];
		size--;
		return result;
	}
	public T peek() {
		return arr[top-1];
	}
	public int getSize() {
		return size;
	}
}
public class Main {

	public static void main(String[] args) {
		Stack<Character> s = new Stack<>(200);
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] temp = str.toCharArray();
		for(int i=0; i<temp.length; i++) {

			char ch = temp[i];

			switch(ch){
				case '(':
					s.push(ch);
					break;
				case ')':
					while(s.peek()!='(') {
						System.out.print(s.pop());
					}
					s.pop();
					break;
				case '*':
				case '/':
					while(s.getSize()!=0&&(s.peek()=='*'||s.peek()=='/')) {
						System.out.print(s.pop());
					}
					s.push(ch);
					break;
				case '+':
				case '-':
					while(s.getSize()!=0&&(s.peek()!='(')) {
						System.out.print(s.pop());
					}
					s.push(ch);
					break;
				default :
					System.out.print(ch);
					break;				
			}
		}
		int size = s.getSize();
		for(int i =0; i<size; i++) {
			System.out.print(s.pop());
		}
	}
}