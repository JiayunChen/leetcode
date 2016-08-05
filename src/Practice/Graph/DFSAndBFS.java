package Practice.Graph;
/*
 *          / I
 *  / B - F - J
 * A- C   
 *  \ D - G - K
 *  \ E - H
 *  
 *  DFS: ABFIJCDGKEH
 *  BFS: ABCDEFGHIJK
 *  
 * */
public class DFSAndBFS {
	int nVertexs;
	boolean[] visited;
	boolean[][] adjMatrix;
	
	int[] stack;
	int[] queue;
	
	public DFSAndBFS(){
		nVertexs = 11;
		visited = new boolean[nVertexs];
		adjMatrix = new boolean[nVertexs][nVertexs];
		adjMatrix[0][1] = true;
		adjMatrix[0][2] = true;
		adjMatrix[0][3] = true;
		adjMatrix[0][4] = true;
		adjMatrix[1][5] = true;
		adjMatrix[3][6] = true;
		adjMatrix[4][7] = true;
		adjMatrix[5][8] = true;
		adjMatrix[5][9] = true;
		adjMatrix[6][10] = true;
		// directed graph because lacking the reverse edge, thus visited[] is not needed
		
		stack = new int[nVertexs];
		queue = new int[nVertexs];
	}
	
	private void initVisited(){
		for (int i = 0; i < nVertexs; i++){
			visited[i] = false;
		}
	}
	
	private int getNextNode(int u){
		for (int v = 0; v < nVertexs; v++){
			if (adjMatrix[u][v] && !visited[v]){
				return v;
			}
		}
		
		return -1;
	}
	
	public void DFS(){
		initVisited();
		stack[0] = 0;
		visited[0] = true;
		System.out.print((char) ('A'));
		for (int v, top = 0; top >= 0; top--){
			while ((v = getNextNode(stack[top])) != -1){
				visited[v] = true;
				stack[++top] = v;
				System.out.print((char) ('A' + v));
			}
		}
	}
	
	public void BFS(){
		int head = 0, tail = 1;
		initVisited();
		queue[0] = 0;
		visited[0] = true;
		for (int v; head != tail; head++){
			int u = queue[head];
			System.out.print((char) ('A' + u));
			while ((v = getNextNode(u)) != -1){
				queue[tail++] = v;
				visited[v] = true;
			}
		}
	}
}
