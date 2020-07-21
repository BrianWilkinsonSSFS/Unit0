import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class HelloWorldTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


    @Test
    @Order(1)
    void HelloWorldTest() {
        String[] args = null;
        HelloWorld.main(args);
        assertEquals("Hello, World!\n", outContent.toString(), "Check your punctuation?");
    }

}