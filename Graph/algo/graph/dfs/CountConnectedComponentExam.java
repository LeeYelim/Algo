package algo.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountConnectedComponentExam {

	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // ������ ����
		int m = sc.nextInt(); // ������ ����
		int [][] matrix = new int[n][n]; // �������
		list = new ArrayList<Integer>(); // Ž�� ����
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
		//System.out.println("Ž�� : " + v);
		list.add(v);
		for(int i=0; i<matrix[v].length; i++) {
			if(matrix[v][i]==1 && !list.contains(i)) {
				dfs(matrix, i);
			}
		}
		
	}
}
