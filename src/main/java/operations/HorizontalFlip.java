package operations;

public final class HorizontalFlip implements ShuffleOperation {
    
    private Character[][] ma3x;
    
    @Override
    public void execute() {
        for (int i = 0; i < (ma3x.length / 2); i++) {
            Character[] temp = ma3x[i];
            ma3x[i] = ma3x[ma3x.length - i - 1];
            ma3x[ma3x.length - i - 1] = temp;
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
