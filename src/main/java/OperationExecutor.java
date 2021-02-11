import operations.ShuffleOperation;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OperationExecutor {
    
    private final Queue<ShuffleOperation> queue;
    private Character[][] ma3x;
    
    public OperationExecutor(Character[][] ma3x) {
        this.ma3x = ma3x;
        queue = new ArrayDeque<>();
    }
    
    public void addOperation(ShuffleOperation operation) {
        operation.setMa3x(ma3x);
        queue.add(operation);
    }
    
    public void removeOperation(ShuffleOperation operation) {
        queue.remove(operation);
    }
    
    public Map<Character, Character> execute() {
        
        Character[] kbSingle = Stream.of(Objects.requireNonNull(queue.peek()).getMa3x())
                .flatMap(Stream::of)
                .toArray(Character[]::new);
        
        queue.forEach(ShuffleOperation::execute);
        
        Character[] originalSingle = Stream.of(Objects.requireNonNull(queue.peek()).getMa3x())
                .flatMap(Stream::of)
                .toArray(Character[]::new);
        
        return IntStream.range(0, originalSingle.length).boxed()
                .collect(Collectors.toMap(i -> originalSingle[i], i -> kbSingle[i]));
    }
}
