class RatInMaze {

	int[][] maze;
	int[][] sol;
	boolean possible = false;


	void buildMaze() {
		maze = new int[4][];
		maze[0] = new int[]{1, 0, 0, 0};
		maze[1] = new int[]{1, 1, 1, 1};
		maze[2] = new int[]{0, 0, 0, 1};
		maze[3] = new int[]{1, 1, 1, 1};
	}

	void solveMaze() {
		sol = new int[4][4];
		possible = solve(0, 0);

		if (possible) {Jren.p(sol);}
		else {Jren.p("not possible");}
	}

	boolean solve(int x, int y) {

		sol[x][y] = 1;

		if (x == maze.length - 1 && y == maze[0].length - 1) {return true;}		

		if (y + 1 < maze[0].length && maze[x][y + 1] == 1) {
			if (solve(x, y + 1)) return true;
		}
		if (x + 1 < maze.length && maze[x + 1] [y] == 1) {
			if (solve(x + 1, y)) return true;
		}

		sol[x][y] = 0;
		return false;

	}


	public static void main(String[] args) {
		RatInMaze rim = new RatInMaze();
		rim.buildMaze();
		Jren.p(rim.maze);
		Jren.p();
		rim.solveMaze();
		
	}
}