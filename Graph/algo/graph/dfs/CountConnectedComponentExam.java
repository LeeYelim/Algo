package algo.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountConnectedComponentExam {

	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정점의 갯수
		int m = sc.nextInt(); // 간선의 갯수
		int [][] matrix = new int[n][n]; // 인접행렬
		list = new ArrayList<Integer>(); // 탐색 정점
		int count=0;
		
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			matrix[x-1][y-1]=matrix[y-1][x-1]=1;
		}
		sc.close();
		for(int i=0; i<n; i++) {
			if(!list.contains(i)) {
				dfs(matrix, i);
				count++;
			}
		}
		
		System.out.println(count);
	}

	private static void dfs(int [][] matrix, int v) {
		//System.out.println("탐색 : " + v);
		list.add(v);
		for(int i=0; i<matrix[v].length; i++) {
			if(matrix[v][i]==1 && !list.contains(i)) {
				dfs(matrix, i);
			}
		}
		
	}
}
