import java.util.Stack;

public class GraphAdjMatrix implements Graph {
	
	int[][] graph;
	int size;
	
	//constructor
	public GraphAdjMatrix(int size) {
		this.size = size;
		graph = new int[size][size];
	}
	
	//assign edge between vertices
	public void addEdge(int v1, int v2) {
		graph[v1][v2] = 1;
	}
	
	//return array of neighbors
	public int[] neighbors(int vertex) {
		int[] neb = new int[size];
		int index = 0;
		for(int i=0; i < size ; i++){
			if(graph[vertex][i] == 1 && i != vertex){
				neb[index] = i;
				index++;		
			}
		}

		int[] neighbor = new int[index];
		System.arraycopy(neb, 0, neighbor, 0, index);
		
		return neighbor;
	}
	
	//call recursive topological sort
    public void topologicalSort() {
        Stack stack = new Stack();
        boolean visited[] = new boolean[size];
        
        for (int i = 0; i < size; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < size; i++) {
            if (visited[i] == false) {
                topologicalSort(i, visited, stack);
            }
        }
    }
	
    //recursive topological sort
    private void topologicalSort(int vertex, boolean visited[], Stack stack) {
    		Stack<Integer> s = new Stack<Integer>();
		s.push(new Integer(vertex));
		
		while(!s.empty()) {
			int v = s.pop();
			visited[v] = true;
			for(int i = 0; i < neighbors(v).length; i++) {
				int u = neighbors(v)[i];	
				if(!visited[u]) {
					visited[u] = true;
					s.push(new Integer(u));
				}
			}
		}
    }
}
