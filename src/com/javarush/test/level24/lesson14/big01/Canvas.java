package com.javarush.test.level24.lesson14.big01;

/**
 * Created by promoscow on 28.01.17.
 */
public class Canvas {
    private int width;
    private int height;

    private char[][] matrix;

    public Canvas(int width, int height) {

        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setPoint(double x, double y, char c) {
        if (x >= 0 && y >= 0 && y <= matrix.length && x <= matrix[0].length) {
            int a = (int) Math.round(x);
            int b = (int) Math.round(y);
            matrix[a][b] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) setPoint(x + j, y + i, c);
            }
        }
    }
}
