package algo.graph.dfs;

import java.util.Scanner;

public class PathSearchExam {

	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		int n = sc.nextInt(); // 정점 갯수
		int [][] matrix = new int[n][n]; // 인접행렬(방향 고려)
		int pathMatrix[][] = new int[n][n]; // 결과 행렬
		int [] visitArray; 
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				matrix[i][j] = sc.nextInt(); // 0 : 간선X, 1 : 간선O
			}
		}
		sc.close();
		
		for(int i=0; i<n; i++) { // 정점 만큼 실행 
			visitArray = new int[n]; // 지나간 정점
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
	 * 가중치 없는 방향 그래프 G가 주어졌을 때, 
	 * 모든 정점 (i, j)에 대해서, i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램
	 * */
	private static void pathSearch(int[][] matrix, int [] visitArray, int v, boolean isFirst) { // 시작 정점
		if(!isFirst) visitArray[v]=1;
		for(int i=0; i<matrix[v].length; i++) {
			if(matrix[v][i]==1 && visitArray[i]==0) {
				pathSearch(matrix, visitArray, i, false);
			}
		}
	}

}
