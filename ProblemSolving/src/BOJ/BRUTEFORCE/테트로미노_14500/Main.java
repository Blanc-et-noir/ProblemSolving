import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		String[] str = br.readLine().split(" ");
		boolean flag;
		int sum, max=-1, y,x;
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int[][] arr = new int[N][M];
		int[][][] v = new int[][][] {
			//Á¤»ç°¢Çü
			{{0,0},{1,0},{0,1},{1,1}},
			//ÀÏÀÚ
			{{0,0},{0,1},{0,2},{0,3}},
			{{0,0},{1,0},{2,0},{3,0}},
			/*   #
			 * ##@ ÁÂ¿ì»óÇÏ´ëÄª
			 */
			{{0,0},{-1,0},{0,-1},{0,-2}},//¤¤¸ð¾ç
			{{0,0},{-1,0},{0,1},{0,2}},
			{{0,0},{1,0},{0,-1},{0,-2}},
			{{0,0},{1,0},{0,1},{0,2}},
			/*
			 *  #
			 *  #
			 * #@ ÁÂ¿ì»óÇÏ´ëÄª
			 */
			{{0,0},{-1,0},{-2,0},{0,-1}},
			{{0,0},{-1,0},{-2,0},{0,1}},
			{{0,0},{0,-1},{1,0},{2,0}},
			{{0,0},{0,1},{1,0},{2,0}},
			/*  #
			 * #@# ½Ã°è È¸Àü
			 */
			{{0,0},{-1,0},{0,1},{0,-1}},
			{{0,0},{-1,0},{1,0},{0,1}},
			{{0,0},{1,0},{0,-1},{0,1}},
			{{0,0},{-1,0},{1,0},{0,-1}},
			/* @#
			 *  ## »óÇÏ´ëÄª
			 */
			{{0,0},{0,1},{1,1},{1,2}},
			{{0,0},{0,1},{-1,1},{-1,2}},
			/* @
			 * ## ÁÂ¿ì´ëÄª
			 *  #
			 */
			{{0,0},{1,0},{1,1},{2,1}},
			{{0,0},{1,0},{1,-1},{2,-1}}
		};
		for(int i=0; i<N;i++) {
			str = br.readLine().split(" ");
			for(int j=0;j<str.length;j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		for(int i=0; i<N;i++) {
			for(int j=0; j<M; j++) {
				for(int k=0;k<v.length; k++) {
					flag = false;
					sum=0;
					for(int l=0; l<4; l++) {
						y=i+v[k][l][0];
						x=j+v[k][l][1];
						if(y<0||y>=N||x<0||x>=M) {
							flag = true;
							break;
						}
						sum+=arr[y][x];
					}
					if(flag == true) {
						continue;
					}else {
						if(sum>max) {
							max = sum;
						}
					}
				}
			}
		}
		
		bw.write(max+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}