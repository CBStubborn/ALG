import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */

public class IslandsCount {


    public static int numIslands(char[][] grid) {

        int islands = 0;
        // 首先判断特特例，当grid为空，则直接返回0
        if (null == grid || grid.length == 0) {
            return islands;
        }

        int r = grid.length;
        int c = grid[0].length;

        int[][] visited = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (visited[i][j] == 1) {
                    continue;
                }

                visited[i][j] = 1;

                if ('1' == grid[i][j]) {
                    islands++;
                    Queue<Integer> nodes = new LinkedList<>();
                    nodes.add(i * c + j);
                    while (nodes.size() > 0) {
                        int node = nodes.poll();
                        int h = node / c;
                        int t = node % c;

                        if (t + 1 < grid[0].length && visited[h][t + 1] == 0) {
                            visited[h][t + 1] = 1;
                            if ('1' == grid[h][t + 1]) {
                                nodes.add(h * c + (t + 1));
                            }
                        }

                        if (h + 1 < grid.length && visited[h + 1][t] == 0) {
                            visited[h + 1][t] = 1;
                            if ('1' == grid[h + 1][t]) {
                                nodes.add((h + 1) * c + t);
                            }
                        }

                        if (t - 1 >= 0 && visited[h][t - 1] == 0) {
                            visited[h][t - 1] = 1;
                            if ('1' == grid[h][t - 1]) {
                                nodes.add(h * c + (t - 1));
                            }
                        }

                        if (h - 1 >= 0 && visited[h - 1][t] == 0) {
                            visited[h - 1][t] = 1;
                            if ('1' == grid[h - 1][t]) {
                                nodes.add((h - 1) * c + t);
                            }
                        }
                    }
                }
            }
        }

        return islands;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(grid));
    }


}
