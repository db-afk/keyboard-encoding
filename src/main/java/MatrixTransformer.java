import org.apache.commons.lang.ArrayUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MatrixTransformer {
    
    public static Character[][] transformMatrix(Path path) throws IOException {
        List<String> ma3x = Files.readAllLines(path);
        Character[][] result = new Character[ma3x.size()][];
        for (int i = 0; i < ma3x.size(); i++) {
            String x = ma3x.get(i);
            result[i] = ArrayUtils.toObject(x.toCharArray());
        }
        return result;
    }
}
