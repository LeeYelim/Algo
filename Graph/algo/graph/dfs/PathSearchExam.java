package algo.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathSearchExam {

	static int pathMatrix[][];
	static int n;
	static int [][] matrix;
	static List<Integer> array; 
	
	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		n = sc.nextInt(); // 정점 갯수
		matrix = new int[n][n]; // 인접행렬(방향 고려)
		pathMatrix = new int[n][n];
		array = new ArrayList<Integer>(); // 지나간 정점
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				matrix[i][j] = sc.nextInt(); // 0 : 간선X, 1 : 간선O
			}
		}
		
		for(int i=0; i<n; i++) {
			array.clear();
			pathSearch(i);
			for(int j=0; j<array.size(); j++) {
				int x = array.get(j);
				pathMatrix[i][x]=1;
			}
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
	private static void pathSearch(int v) { // 시작 정점
		for(int i=0; i<n; i++) {
			if(matrix[v][i]==1 && !array.contains(i)) {
				array.add(i); // 정점 추가
				pathSearch(i);
			}
		}
	}

}
