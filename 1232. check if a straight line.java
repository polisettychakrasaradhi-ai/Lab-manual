class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // Base case: if there are only 2 points, they always form a line
        if (coordinates.length <= 2) {
            return true;
        }

        // Calculate differences using the first two points
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        int dx = x1 - x0;
        int dy = y1 - y0;

        // Check collinearity for all remaining points
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            // Cross-multiplication check: dy * (x - x0) == dx * (y - y0)
            if (dy * (x - x0) != dx * (y - y0)) {
                return false;
            }
        }

        return true;
    }
}
