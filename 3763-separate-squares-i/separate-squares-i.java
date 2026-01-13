class Solution {
    public double separateSquares(int[][] squares) {
        double maxY = 0; 
        double minY = Integer.MAX_VALUE;
        double totalArea = 0;

        for (int i = 0; i < squares.length; i++) {
            int[] sq = squares[i];
            double topY = sq[1] + sq[2];
            maxY = Math.max(maxY, topY);
            minY = Math.min(minY, sq[1]);
            totalArea += (double)sq[2] * (double)sq[2];
        }
        // System.out.println("totalARea: " + totalArea);

        double lo = minY;
        double hi = maxY;
        double precision = Math.pow(10,-5);
        // System.out.println("precision: " + precision);

        while ( lo < hi ) {
            // System.out.println("\nhi: " + hi + " lo: " + lo + " diff: " + (hi-lo) );
            if (hi - lo < precision) {
                break;
            }

            double mid = lo+(hi-lo)/2.0;
            // System.out.println("mid: " + mid);
            double topArea = getTop(squares, mid);
            double bottomArea = totalArea - topArea;

            // System.out.println("top area: " + topArea + " bottomArea: " + bottomArea);

            if (topArea <= bottomArea) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return lo;
    }

    public double getTop(int[][] squares, double line) {
        double area = 0.0;

        for (int[] square : squares) {
            double y = square[1];
            double width = square[2];

            if (y >= line) {
                area += width*width;
            } else {
                if (y + width >= line) {
                    double actualHeight = y+width-line;
                    area += actualHeight*width;
                }
            }
        }

        return area;
    }
}

/**

We have an array of squares which tells us x,y coordinate of the bottom left point, as well as its length

We need to find the minimum y-coordinate of a line that separates all the squares areas into top/bottom sections
ssuch that the total area occupied by squares are equals on both sides.

constraints / edge cases
- squares may overlap -> must count them both
- assume that is always a possible answer

all coordinates positive -> so can start from 0,0 to inf,inf

maximum y would just be max(squares[i][2]) + squares[i][3]

pick mid, 
find all areas above mid (this is the expensive operation)
find all areas below mid compare
if top > bottom, adjust line up, else adjust line down.


given a value y, how to find all areas above y??

FFFFFFTTTTTT
 */