package operations;

public final class VerticalFlip implements ShuffleOperation {
    
    private Character[][] ma3x;
    
    @Override
    public void execute() {
        for (int x = 0; x < ma3x.length; x++) {
            for (int y = 0; y < ma3x[x].length / 2; y++) {
                Character tmp = ma3x[x][ma3x[x].length - y - 1];
                ma3x[x][ma3x[x].length - y - 1] = ma3x[x][y];
                ma3x[x][y] = tmp;
            }
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
