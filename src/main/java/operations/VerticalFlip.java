package operations;

public class VerticalFlip extends AbstractOperation implements ShuffleOperation {
    
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
}
