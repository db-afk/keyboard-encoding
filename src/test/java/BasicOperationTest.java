import encoders.Encoder;
import operations.HorizontalFlip;
import operations.ShiftOperation;
import operations.VerticalFlip;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicOperationTest {
    
    private static Path digit;
    
    @BeforeAll
    public static void SetUp() {
        digit = Paths.get("src/test/resources/digit.txt");
    }
    
    @Test
    public void testShift() throws IOException {
        Encoder encoder = new Encoder(digit, Collections.singletonList(new ShiftOperation(5)));
        assertEquals("nm,./12345", encoder.getEncodedText());
    }
    
    @Test
    public void testVerticalFlip() throws IOException {
        Encoder encoder = new Encoder(digit, Collections.singletonList(new VerticalFlip()));
        assertEquals("0987654321", encoder.getEncodedText());
    }
    
    @Test
    public void testHorizontalFlip() throws IOException {
        Encoder encoder = new Encoder(digit, Collections.singletonList(new HorizontalFlip()));
        assertEquals("zxcvbnm,./", encoder.getEncodedText());
    }
}
