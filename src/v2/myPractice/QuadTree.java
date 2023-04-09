package v2.myPractice;

/**
 * https://leetcode.com/problems/construct-quad-tree/description/
 * 427. Construct Quad Tree
 * Given a n * n matrix grid of 0's and 1's only. We want to represent grid with a Quad-Tree.
 * <p>
 * Return the root of the Quad-Tree representing grid.
 * <p>
 * A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:
 * <p>
 * val: True if the node represents a grid of 1's or False if the node represents a grid of 0's. Notice that you can assign the val to True or False when isLeaf is False, and both are accepted in the answer.
 * isLeaf: True if the node is a leaf node on the tree or False if the node has four children.
 * class Node {
 * public boolean val;
 * public boolean isLeaf;
 * public Node topLeft;
 * public Node topRight;
 * public Node bottomLeft;
 * public Node bottomRight;
 * }
 * We can construct a Quad-Tree from a two-dimensional area using the following steps:
 * <p>
 * If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and set val to the value of the grid and set the four children to Null and stop.
 * If the current grid has different values, set isLeaf to False and set val to any value and divide the current grid into four sub-grids as shown in the photo.
 * Recurse for each of the children with the proper sub-grid.
 * *
 */
class QuadNode {
    public boolean val;
    public boolean isLeaf;
    public QuadNode topLeft;
    public QuadNode topRight;
    public QuadNode bottomLeft;
    public QuadNode bottomRight;


    public QuadNode() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadNode(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadNode(boolean val, boolean isLeaf, QuadNode topLeft, QuadNode topRight, QuadNode bottomLeft, QuadNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}


public class QuadTree {
    /**
     * solution 1 that has a N^2 log N time complexity
     *
     * @param grid the grid
     * @return the quadtree
     */
    public QuadNode construct2(int[][] grid) {
        return construct2(grid, grid.length, 0, 0);
    }

    /**
     * solution 1 that has a N^2 time complexity
     *
     * @param grid the grid
     * @return the quadtree
     */
    public QuadNode construct(int[][] grid) {
        return construct(grid, grid.length, 0, 0);
    }

    public QuadNode construct(int[][] grid, int count, int x, int y) {
        if (count == 1) {
            return new QuadNode(grid[x][y] == 1, true);
        }
        count = count / 2;
        QuadNode leftTop = construct(grid, count, x, y);
        QuadNode rightTop = construct(grid, count, x, y + count);
        QuadNode leftBottom = construct(grid, count, x + count, y);
        QuadNode rightBottom = construct(grid, count, x + count, y + count);
        int combine = combine(leftTop, rightTop, leftBottom, rightBottom);
        if (combine == -1)
            return new QuadNode(true, false, leftTop, rightTop, leftBottom, rightBottom);
        return new QuadNode(combine == 1, true);
    }

    public int combine(QuadNode leftTop, QuadNode rightTop, QuadNode leftBottom, QuadNode rightBottom) {
        if (!leftTop.isLeaf || !rightTop.isLeaf || !leftBottom.isLeaf || !rightBottom.isLeaf) {
            return -1;
        }
        if (leftTop.val != rightTop.val || rightTop.val != leftBottom.val || leftBottom.val != rightBottom.val) {
            return -1;
        }
        return leftTop.val ? 1 : 0;
    }

    public QuadNode construct2(int[][] grid, int count, int x, int y) {
        if (count == 1) {
            return new QuadNode(grid[x][y] == 1, true);
        }
        int current = grid[x][y];
        for (int i = x; i < x + count; i++) {
            for (int j = y; j < y + count; j++) {
                if (current != grid[i][j]) {
                    count = count / 2;
                    return new QuadNode(true
                            , false
                            , construct(grid, count, x, y)
                            , construct(grid, count, x, y + count)
                            , construct(grid, count, x + count, y)
                            , construct(grid, count, x + count, y + count));
                }
            }
        }
        return new QuadNode(current == 1, true);
    }
}
