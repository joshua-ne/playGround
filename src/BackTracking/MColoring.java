import java.util.*;
import java.lang.*;
import java.io.*;
class MColoring
 {
	public static void main (String[] args)
	 {
	 Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	 int t = in.nextInt();
	 for (int i = 1; i <= t; i++) {
	     boolean res = false;
	     int V = in.nextInt();
	     int M = in.nextInt();
	     int E = in.nextInt();
	     Map<Integer, Set<Integer>> map = new HashMap<>();
	     for (int j = 1; j <= V; j++) {
	     	map.put(j, new HashSet<Integer>());
	     }
	     
	     for (int j = 0; j < E; j++) {
	         int a = in.nextInt();
	         int b = in.nextInt();
	         map.get(a).add(b);
	         map.get(b).add(a);
	     }
	     
	     int[] color = new int[V + 1];
	     
	     res = paint(map, color, 1, M);
	     
	     System.out.println(res ? 1 : 0);
	 }
	}
	 
	 static boolean paint(Map<Integer, Set<Integer>> map, int[] color, int curIndex, int M) {
	     if (curIndex == color.length) return true;
	     
	     for (int i = 1; i <= M; i++) {
	         if (valid (map, color, curIndex, i)) {
	             color[curIndex] = i;
	             if (paint(map, color, curIndex + 1, M)) {return true;}
	             color[curIndex] = 0; // really need this?
	         }
	     }
	     return false;
	 }
	 
	 static boolean valid(Map<Integer, Set<Integer>> map, int[] color, int curIndex, int colorIndex) {
	 	for (Integer i : map.get(curIndex)) {
	 		if (i < curIndex && color[i] == colorIndex) return false;
	 	}
	 	return true;
	 }
	 
}