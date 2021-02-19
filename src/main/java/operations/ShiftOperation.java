package operations;

import util.MatrixUtil;

import java.util.Arrays;
import java.util.Collections;

public final class ShiftOperation implements ShuffleOperation {
    
    private Character[][] ma3x;
    private final int k;
    
    public ShiftOperation(int k) {
        this.k = k;
    }
    
    @Override
    public void execute() {
        final Object[] flatten = MatrixUtil.flatten(ma3x);
        Collections.rotate(Arrays.asList(flatten), -k);
        ma3x = (Character[][]) MatrixUtil.makeMatrix(flatten, 4, 10);
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
