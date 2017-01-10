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
		n = sc.nextInt(); // ���� ����
		matrix = new int[n][n]; // �������(���� ���)
		pathMatrix = new int[n][n];
		array = new ArrayList<Integer>(); // ������ ����
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				matrix[i][j] = sc.nextInt(); // 0 : ����X, 1 : ����O
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
	 * ����ġ ���� ���� �׷��� G�� �־����� ��, 
	 * ��� ���� (i, j)�� ���ؼ�, i���� j�� ���� ��ΰ� �ִ��� ������ ���ϴ� ���α׷�
	 * */
	private static void pathSearch(int v) { // ���� ����
		for(int i=0; i<n; i++) {
			if(matrix[v][i]==1 && !array.contains(i)) {
				array.add(i); // ���� �߰�
				pathSearch(i);
			}
		}
	}

}
