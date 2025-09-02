public class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int x2 = points[j][0], y2 = points[j][1];

                // A is upper-left of B if x1 <= x2 and y1 >= y2 (allows horizontal/vertical lines)
                if (x1 <= x2 && y1 >= y2) {
                    boolean empty = true;

                    // Check no OTHER point lies inside or on the border of the rectangle/line
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int px = points[k][0], py = points[k][1];

                        if (px >= x1 && px <= x2 && py >= y2 && py <= y1) {
                            empty = false;
                            break;
                        }
                    }

                    if (empty) count++;
                }
            }
        }
        return count;
    }
}
