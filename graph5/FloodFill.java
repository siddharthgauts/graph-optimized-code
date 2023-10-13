package graphs4.graph5;
import java.util.*;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 0, 0, 0},
                {1, 1, 1, 0, 1, 0, 0, 0},
                {1, 1, 1, 0, 1, 1, 1, 1}
        };

        floodFill(image, 1, 1, 5);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return;
        fill(image, sr, sc, image[sr][sc], newColor);
    }

    public static void fill(int[][] image, int i, int j, int oldColor, int newColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != oldColor) {
            return;
        }

        image[i][j] = newColor;

        fill(image, i + 1, j, oldColor, newColor); // down
        fill(image, i - 1, j, oldColor, newColor); // up
        fill(image, i, j + 1, oldColor, newColor); // right
        fill(image, i, j - 1, oldColor, newColor); // left
    }
}
