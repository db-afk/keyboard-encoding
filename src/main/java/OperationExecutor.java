import operations.ShuffleOperation;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class OperationExecutor {
    
    private final Queue<ShuffleOperation> queue;
    
    public OperationExecutor() {
        queue = new ArrayDeque<>();
    }
    
    public void addOperation(ShuffleOperation operation) {
        queue.add(operation);
    }
    
    public void removeOperation(ShuffleOperation operation) {
        queue.remove(operation);
    }
    
    public Map<Character, Character> execute() {
        queue.forEach(ShuffleOperation::execute);
        return Objects.requireNonNull(queue.peek()).getMap();
    }
}
