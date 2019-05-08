import java.util.*;
import java.lang.*;
import java.io.*;
class Sudoku{

  int[][] matrix;
  boolean solutionExist;
  int[][] solMatrix;
  List<int[]> toBeFilled;

  public Sudoku(int[][] matrix) {
    this.matrix = matrix;
    solMatrix = new int[9][];
    for (int i = 0; i < 9; i++) {
      solMatrix[i] = matrix[i].clone();
    }
    toBeFilled = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (solMatrix[i][j] == 0) toBeFilled.add(new int[]{i, j});
      }
    }
  }

  void solve() {
    solutionExist = solve(0);
  }

  boolean solve(int cur) {

    if (cur == toBeFilled.size()) {return true;}

    int[] curPosition = toBeFilled.get(cur);
    for (int t = 1; t <= 9; t++) {
      if (checkValidity(curPosition, t, solMatrix)) {
        solMatrix[curPosition[0]][curPosition[1]] = t;
        if (solve(cur + 1)) {return true;}
        solMatrix[curPosition[0]][curPosition[1]] = 0;
      }
    }
    return false;
  }


  boolean checkValidity(int[] curPosition, int fill, int[][] solMatrix) {
    int r = curPosition[0];
    int c = curPosition[1];
    if (!checkRow(r, fill, solMatrix)) return false;
    if (!checkCol(c, fill, solMatrix)) return false;
    if (!checkSquare(r, c, fill, solMatrix)) return false;
    return true;
  }

  boolean checkRow(int r, int fill, int[][] solMatrix) {
    for (int i = 0; i < 9; i++) {
      if (solMatrix[r][i] == fill) return false;
    }
    return true;
  }

  boolean checkCol(int c, int fill, int[][] solMatrix) {
    for (int i = 0; i < 9; i++) {
      if (solMatrix[i][c] == fill) return false;
    }
    return true;
  }

  boolean checkSquare(int r, int c, int fill, int[][] solMatrix) {
    for (int i = (r / 3) * 3; i < (r / 3 + 1) * 3; i++) {
      for (int j = (c / 3) * 3; j < (c / 3 + 1) * 3; j++) {
        if (solMatrix[i][j] == fill) return false;
      }
    }
    return true;
  }

  void print() {
    if (!solutionExist) {Jren.p("No solution available!");}
    else Jren.p(solMatrix);
  }

  public static void main (String[] args){
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();

    for (int t = 1; t <= T; t++) {
      int[][] matrix = new int[9][9];
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          matrix[i][j] = in.nextInt();
        }
      }

      Jren.p("Original Question: ");
      Jren.p(matrix); Jren.p();

      Sudoku sudoku = new Sudoku(matrix);
      sudoku.solve();
      sudoku.print();
    }
  }
}