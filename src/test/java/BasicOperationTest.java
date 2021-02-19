import operations.HorizontalFlip;
import operations.ShiftOperation;
import operations.VerticalFlip;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicOperationTest {
    
    @Test
    public void testShift() throws IOException {
        Path digit = Paths.get("src/test/resources/digit.txt");
        Path kbd = Paths.get("src/test/resources/kbd.txt");
        OperationExecutor queue = new OperationExecutor(MatrixTransformer.transformMatrix(kbd));
        queue.addOperation(new ShiftOperation(5));
        Encoder encoder = new Encoder(queue);
        encoder.setText(digit);
        assertEquals("nm,./12345", encoder.getEncodedText());
    }
    
    @Test
    public void testVerticalFlip() throws IOException {
        Path digit = Paths.get("src/test/resources/digit.txt");
        Path kbd = Paths.get("src/test/resources/kbd.txt");
        OperationExecutor queue = new OperationExecutor(MatrixTransformer.transformMatrix(kbd));
        queue.addOperation(new VerticalFlip());
        Encoder encoder = new Encoder(queue);
        encoder.setText(digit);
        assertEquals("0987654321", encoder.getEncodedText());
    }
    
    @Test
    public void testHorizontalFlip() throws IOException {
        Path digit = Paths.get("src/test/resources/digit.txt");
        Path kbd = Paths.get("src/test/resources/kbd.txt");
        OperationExecutor queue = new OperationExecutor(MatrixTransformer.transformMatrix(kbd));
        queue.addOperation(new HorizontalFlip());
        Encoder encoder = new Encoder(queue);
        encoder.setText(digit);
        assertEquals("zxcvbnm,./", encoder.getEncodedText());
    }
}
