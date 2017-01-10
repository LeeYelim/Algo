package algo.graph.dfs;

import java.util.Scanner;

public class PathSearchExam {

	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		int n = sc.nextInt(); // ���� ����
		int [][] matrix = new int[n][n]; // �������(���� ���)
		int pathMatrix[][] = new int[n][n]; // ��� ���
		int [] visitArray; 
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				matrix[i][j] = sc.nextInt(); // 0 : ����X, 1 : ����O
			}
		}
		sc.close();
		
		for(int i=0; i<n; i++) { // ���� ��ŭ ���� 
			visitArray = new int[n]; // ������ ����
			pathSearch(matrix, visitArray, i, true);
			pathMatrix[i]=visitArray;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(pathMatrix[i][j]+"\t");
			}
			System.out.println();
		}
	}

	/**
	 * ����ġ ���� ���� �׷��� G�� �־����� ��, 
	 * ��� ���� (i, j)�� ���ؼ�, i���� j�� ���� ��ΰ� �ִ��� ������ ���ϴ� ���α׷�
	 * */
	private static void pathSearch(int[][] matrix, int [] visitArray, int v, boolean isFirst) { // ���� ����
		if(!isFirst) visitArray[v]=1;
		for(int i=0; i<matrix[v].length; i++) {
			if(matrix[v][i]==1 && visitArray[i]==0) {
				pathSearch(matrix, visitArray, i, false);
			}
		}
	}

}
