public class LC1 {
        public boolean isBoomerang(int[][] points) {
            for (int i = 0; i < 3; i++) {
                for (int j = i ; j < 3; j++) {
                    if (samePoint(points[i], points[j])) {return false;}
                }
            }

            return onALine(points);
        }

        boolean samePoint(int[] p1, int[] p2) {
            return (p1[0] == p2[0] && p1[1] == p2[1]);
        }

        boolean onALine(int[][] points) {
            int[] p1 = points[0];
            int[] p2 = points[1];
            int[] p3 = points[2];

            return ((p2[0] - p1[0]) * (p3[1] - p2[1]) == (p2[1] - p1[1]) * (p3[0] - p2[0]));

        }





	public static void main(String[] args) {
		
	}
    
}
