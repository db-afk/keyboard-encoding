package encoders;

import executors.OperationExecutor;
import operations.ShuffleOperation;
import transformers.MatrixTransformer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Encoder {
    private final OperationExecutor executor;
    private String text;
    
    public Encoder(Path textPath, Path operationPath) throws IOException {
        Path kbd = Paths.get("src/main/resources/kbd.txt");
        this.executor = new OperationExecutor(MatrixTransformer.transformMatrix(kbd));
        this.executor.setOperations(operationPath);
        setText(textPath);
    }
    
    public Encoder(Path textPath, List<ShuffleOperation> operationList) throws IOException {
        Path kbd = Paths.get("src/main/resources/kbd.txt");
        this.executor = new OperationExecutor(MatrixTransformer.transformMatrix(kbd));
        operationList.forEach(this.executor::addOperation);
        setText(textPath);
    }
    
    public Encoder(OperationExecutor executor) {
        this.executor = executor;
    }
    
    public String getText() {
        return text;
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
