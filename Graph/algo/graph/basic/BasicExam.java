package algo.graph.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BasicExam {
	/**
	 * ���� �켱 Ž��
	 * */
	static int n,m,v;
	static boolean [][] matrix;
	static List<Integer> array;
	static Queue<Integer> que;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // ���� ����
		m = sc.nextInt(); // ���� ����
		v = sc.nextInt(); // Ž�� ���� ���� ��ȣ
		matrix = new boolean[n][n]; // �������
		array = new ArrayList<Integer>();
		que = new LinkedList<Integer>();
		
		for(int i=0; i<m; i++) {
			System.out.println("���� �Է�");
			int x = sc.nextInt();
			int y = sc.nextInt();
			matrix[x-1][y-1]=true;
			matrix[y-1][x-1]=true;
		}
		dfs(v-1); // 0���� ����
        System.out.println();
		bfs(v-1); // 0���� ����
	}

	private static void dfs(int v) {
		array.add(v);
        System.out.print((v+1) + " ");
		for(int i=0; i<matrix[v].length; i++) {
			if(matrix[v][i]==true && !array.contains(i)) {
				//System.out.print((i+1) + " ");
				dfs(i);
			}	
		}
	}
	
	private static void bfs(int v) {
		que.add(v);
         System.out.print((v+1) + " ");
		array = new ArrayList<Integer>();
		array.add(v);
		while(!que.isEmpty()) {
			v = que.poll();
			for(int i=0; i<matrix[v].length; i++) {
				if(matrix[v][i]==true && !array.contains(i)) {
					System.out.print((i+1) + " ");
					que.add(i);
					array.add(i);
				}
			}
		}
	}
}
