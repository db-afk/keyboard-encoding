package operations;

public class HorizontalFlip extends AbstractOperation implements ShuffleOperation {
    
    @Override
    public void execute() {
        for (int i = 0; i < (ma3x.length / 2); i++) {
            Character[] temp = ma3x[i];
            ma3x[i] = ma3x[ma3x.length - i - 1];
            ma3x[ma3x.length - i - 1] = temp;
        }
    }
}
