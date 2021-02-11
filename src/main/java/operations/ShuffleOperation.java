package operations;

import java.util.Map;

@FunctionalInterface
public interface ShuffleOperation {
    
    void execute();
    
    default Map<Character, Character> getMap() {
        return null;
    }
}
