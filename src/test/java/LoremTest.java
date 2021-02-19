import encoders.Encoder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoremTest {
    
    private static Path text;
    
    @BeforeAll
    public static void setUp() {
        text = Paths.get("src/test/resources/lorem.txt");
    }
    
    @Test
    public void testDefaultOperations() throws IOException {
        Encoder encoder = new Encoder(text, Paths.get("src/test/resources/operations.txt"));
        
        assertEquals("Llfd7 k;wj7 elolf wkg q7dg8 3l6wd3gdgjf " +
                        "qek;kw3k6t dokg9 Ug 6d3lf6qfd ejk8 3l64qookw yd6efdfkg " +
                        "wd79 Pfqdwd6g dtdg 4k4dffq dwg9Mqd3d6qw olfd7 rdokw8 " +
                        "wjw3k;kg dtdg elolf wleqodw8 ek3gj7;lfggkglf d6k79 Sde " +
                        "rq3kokwkw 7lookw dokg8 wde ;dood6gdwajd7dgjw 4d6d6qgkw " +
                        "wd7;df9 Njooq7 7qjfkw gjf;kw8 ;yqfdgfq k6gk63kej6g q8 lf6qfd " +
                        "4kgqd ajq79 I6 4kgqd 3l77lel dwg9 Egkq7yd6efdfkg 4d6d6qgkw " +
                        "glfglf 6d3 fjgfj79 Mqd3d6qw dg oqlfddg6kwk9 Njooq7 ;lfgq 7qwwq " +
                        "ok5dfl8 wkg q7dg 4qfkjw dfqg k7;dfekdgq39 " +
                        "Fjw3d wde wlook3kgjek6 elolf9",
                encoder.getEncodedText());
    }
    
    @Test
    public void testBadOperations() throws IOException {
        Encoder encoder = new Encoder(text, Paths.get("src/test/resources/operations-bad.txt"));
        
        assertEquals("Llfd7 k;wj7 elolf wkg q7dg8 3l6wd3gdgjf " +
                        "qek;kw3k6t dokg9 Ug 6d3lf6qfd ejk8 3l64qookw yd6efdfkg " +
                        "wd79 Pfqdwd6g dtdg 4k4dffq dwg9Mqd3d6qw olfd7 rdokw8 " +
                        "wjw3k;kg dtdg elolf wleqodw8 ek3gj7;lfggkglf d6k79 Sde " +
                        "rq3kokwkw 7lookw dokg8 wde ;dood6gdwajd7dgjw 4d6d6qgkw " +
                        "wd7;df9 Njooq7 7qjfkw gjf;kw8 ;yqfdgfq k6gk63kej6g q8 lf6qfd " +
                        "4kgqd ajq79 I6 4kgqd 3l77lel dwg9 Egkq7yd6efdfkg 4d6d6qgkw " +
                        "glfglf 6d3 fjgfj79 Mqd3d6qw dg oqlfddg6kwk9 Njooq7 ;lfgq 7qwwq " +
                        "ok5dfl8 wkg q7dg 4qfkjw dfqg k7;dfekdgq39 " +
                        "Fjw3d wde wlook3kgjek6 elolf9",
                encoder.getEncodedText());
    }
}
