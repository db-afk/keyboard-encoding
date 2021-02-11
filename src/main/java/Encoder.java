import java.util.Map;

public class Encoder {
    private final OperationExecutor executor;
    private final String text;
    
    public Encoder(OperationExecutor executor, String text) {
        this.executor = executor;
        this.text = text;
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
