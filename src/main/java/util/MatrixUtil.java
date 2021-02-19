package util;

import java.util.Arrays;

public class MatrixUtil {
    
    public static Object[] flatten(Object[][] ma3x) {
        return Arrays.stream(ma3x)
                .flatMap(Arrays::stream)
                .toArray();
    }
    
    public static Object[][] makeMatrix(Object[] array1d, int rows, int cols) {
        Object[][] array2d = new Character[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array2d[i][j] = array1d[(i * cols) + j];
            }
        }
        
        return array2d;
    }
}
