import java.util.*;
import java.lang.*;
import java.io.*;
class HamiltonianPath{
  public static void main (String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();

    for (int i = 1; i <= t; i++) {
      boolean pathExist;
      int V = in.nextInt();
      int E = in.nextInt();
      Map<Integer, List<Integer>> graph = new HashMap<>();
      for (int j = 0; j <= V; j++) {
        graph.put(j, new ArrayList<Integer>());
      }

      //set a virtual #0 vertice for algs initialization, avoiding code duplication
      for (int j = 1; j <= V; j++) {
        graph.get(0).add(j);
      }

      for (int j = 0; j < E; j++) {
        int v1 = in.nextInt();
        int v2 = in.nextInt();
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
      }

      //start from a virtual vertice
      pathExist = findPath(graph, 0, new HashSet<Integer>());

      System.out.println(pathExist ? 1 : 0);

    }
  }

  static boolean findPath(Map<Integer, List<Integer>> graph, int curV, Set<Integer> curPath) {
    if (curPath.size() == graph.size() - 1) return true;

    for (Integer nextV : graph.get(curV)) {
      if (!curPath.contains(nextV)) {
        curPath.add(nextV);
        if (findPath(graph, nextV, curPath)) return true;
        curPath.remove(nextV);
      }
    }
    return false;
  } 
}