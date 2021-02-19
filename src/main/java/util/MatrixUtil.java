package util;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MatrixUtil {
    
    private MatrixUtil() { }
    
    public static Object[] flatten(Object[][] ma3x) {
        return Arrays.stream(ma3x)
                .flatMap(Arrays::stream)
                .toArray();
    }
    
    public static Object[][] makeMatrix(Object[] array1d, int rows, int cols) {
        Object[][] array2d = new Character[rows][cols];
        if (!ArrayUtils.isEmpty(array1d)) {
            IntStream.range(0, rows)
                    .filter(i -> cols >= 0)
                    .forEach(i -> System.arraycopy(array1d, (i * cols), array2d[i], 0, cols));
        }
        
        return array2d;
    }
}
