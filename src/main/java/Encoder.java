import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Encoder {
    private final OperationExecutor executor;
    private String text;
    
    public Encoder(OperationExecutor executor) {
        this.executor = executor;
    }
    
    public void setText(Path path) throws IOException {
        this.text = String.join("", Files.readAllLines(path));
    }
    
    public String getEncodedText() {
        final Map<Character, Character> stringMap = executor.execute();
        return encodeText(stringMap, text);
    }
    
    private String encodeText(Map<Character, Character> dictionary, String text) {
        
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append(dictionary.getOrDefault(c, c));
        }
        
        return result.toString();
    }
}
