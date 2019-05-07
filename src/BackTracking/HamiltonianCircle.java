import java.util.*; 

class HamiltonianCircle {
	int[][] graph;
	int[] path;
	int V;
	boolean circleExist; 

	HamiltonianCircle(int[][] graph) {
		this.graph = graph;
		V = graph.length;
		path = new int[V + 1];
		Arrays.fill(path, -1);
		circleExist = false;
	}

	void findCircle() {
		//Jren.p(V);
		path[0] = 0;
		if (findCircle(graph, 0, path, 0)) {circleExist = true; return;}

		/*
		for (int i = 0; i < V; i++) {

			path[0] = i;
			if (findCircle(graph, i, path, 0)) {circleExist = true; return;}
			//break;
			//path[0] = -1;
		}
		*/
	}

	boolean findCircle(int[][] graph, int curV, int[] path, int curStep) {
		//Jren.p(path);
		if (curStep == V && path[V] == path[0]) return true;
		if (curStep == V && path[V] != path[0]) return false;

		for (int v = 0; v < V; v++) {
			//Jren.p(v);
			if (graph[curV][v] == 1 && (curStep == V - 1 || notInPath(path, v, curStep))) {
				path[curStep + 1] = v;
				if (findCircle(graph, v, path, curStep + 1)) return true;
				//path[curStep + 1] = -1;
			}
		}
		return false;
	}

	void printPath() {
		if (!circleExist) Jren.p("No HamiltonianCircle found!");
		else {Jren.p("HamiltonianCircle found!"); Jren.p(path);}
	}

	boolean notInPath(int[] path, int v, int curStep) {
		for (int i = 0; i <= curStep; i++) {
			if (path[i] == v) return false;
		}
		return true;
	}




	public static void main(String[] args) {

		List<int[][]> graphs = new ArrayList<>();
		int[][] graph1 = {
			{0, 1, 0, 1, 0}, 
            {1, 0, 1, 1, 1}, 
            {0, 1, 0, 0, 1}, 
            {1, 1, 0, 0, 1}, 
            {0, 1, 1, 1, 0}, 
        }; 

        int[][] graph2 = {
        	{0, 1, 0, 1, 0}, 
            {1, 0, 1, 1, 1}, 
            {0, 1, 0, 0, 1}, 
            {1, 1, 0, 0, 0}, 
            {0, 1, 1, 0, 0}, 
        };

        graphs.add(graph1);
        graphs.add(graph2);

        for (int[][] graph : graphs) {
        	HamiltonianCircle hC = new HamiltonianCircle(graph);
        	//Jren.p(graph);
        	hC.findCircle();
        	hC.printPath();
        	Jren.p();
        }
	}
}