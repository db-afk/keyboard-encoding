package operations;

import java.util.Arrays;
import java.util.Collections;

public class ShiftOperation implements ShuffleOperation {
    
    private Character[][] ma3x;
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
    
    @Override
    public Character[][] getMa3x() {
        return ma3x;
    }
    
    @Override
    public void setMa3x(Character[][] ma3x) {
        this.ma3x = ma3x;
    }
}
