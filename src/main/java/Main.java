import operations.HorizontalFlip;
import operations.ShiftOperation;
import operations.VerticalFlip;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path kbd = Paths.get("src/main/resources/input-kbd.txt");
        Path lorem = Paths.get("src/main/resources/lorem.txt");
        
        OperationExecutor queue = new OperationExecutor();
        queue.addOperation(new HorizontalFlip());
        queue.addOperation(new VerticalFlip());
        queue.addOperation(new ShiftOperation(5));
        queue.addOperation(new VerticalFlip());
        queue.addOperation(new ShiftOperation(-1));
        
        Encoder encoder = new Encoder(queue, Files.readString(lorem));
        final String encodedText = encoder.getEncodedText();
        System.out.println("encodedText = " + encodedText);
    }
}
