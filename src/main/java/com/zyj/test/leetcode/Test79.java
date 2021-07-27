package com.zyj.test.leetcode;

/**
 * @author zhongyj
 * @since 2021-04-08 16:15
 */
public class Test79 {
    public static void main(String[] args) {
        Test79 test79 = new Test79();
        char[][] board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(test79.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width = board[0].length;
        boolean[][] visited = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boolean flag = check(i, j, 0, board, visited, word);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(int height, int width, int k, char[][] board, boolean[][] visited, String word) {
        if (word.charAt(k) != board[height][width]) {
            return false;
        } else if (word.length() - 1 == k) {
            return true;
        }

        visited[height][width] = true;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean result = false;

        for(int[] direction: directions) {
            int newHeight = height + direction[0];
            int newWidth = width + direction[1];
            if (newHeight >= 0 && newHeight < board.length && newWidth >= 0 && newWidth < board[0].length) {
                if (!visited[newHeight][newWidth]) {
                    boolean flag = check(newHeight, newWidth, k + 1, board, visited, word);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[height][width] = false;
        return result;
    }
}
