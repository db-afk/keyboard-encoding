import operations.HorizontalFlip;
import operations.ShiftOperation;
import operations.VerticalFlip;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path kbd = Paths.get("src/main/resources/kbd.txt");
        Path lorem = Paths.get("src/main/resources/lorem.txt");
        
        OperationExecutor queue = new OperationExecutor(MatrixTransformer.transformMatrix(kbd));
        queue.addOperation(new HorizontalFlip());
        queue.addOperation(new VerticalFlip());
        queue.addOperation(new ShiftOperation(5));
        queue.addOperation(new VerticalFlip());
        queue.addOperation(new ShiftOperation(-1));
        
        Encoder encoder = new Encoder(queue);
        encoder.setText(lorem);
        System.out.println("originalText = " + encoder.getText());
        final String encodedText = encoder.getEncodedText();
        System.out.println("encodedText = " + encodedText);
    }
}
