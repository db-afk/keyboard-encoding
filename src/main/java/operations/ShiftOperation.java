package operations;

import java.util.Arrays;
import java.util.Collections;

public class ShiftOperation extends AbstractOperation implements ShuffleOperation {
    
    private final int k;
    
    public ShiftOperation(int k) {
        this.k = k;
    }
    
    @Override
    public void execute() {
        for (Character[] strings : ma3x) {
            Collections.rotate(Arrays.asList(strings), k);
        }
    }
}
