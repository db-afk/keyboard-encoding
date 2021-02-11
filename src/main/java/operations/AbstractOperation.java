package operations;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AbstractOperation {
    
    protected static Character[][] ma3x = new Character[4][];
    private final Character[][] original = new Character[4][];
    
    public AbstractOperation() {
        original[0] = new Character[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        original[1] = new Character[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        original[2] = new Character[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';'};
        original[3] = new Character[]{'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/'};
        
        ma3x[0] = new Character[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        ma3x[1] = new Character[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        ma3x[2] = new Character[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';'};
        ma3x[3] = new Character[]{'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/'};
    }
    
    public Map<Character, Character> getMap() {
    
        Character[] kbSingle = Stream.of(ma3x)
                .flatMap(Stream::of)
                .toArray(Character[]::new);
    
        Character[] originalSingle = Stream.of(original)
                .flatMap(Stream::of)
                .toArray(Character[]::new);
        
        return IntStream.range(0, originalSingle.length).boxed()
                .collect(Collectors.toMap(i -> originalSingle[i], i -> kbSingle[i]));
    }
}
