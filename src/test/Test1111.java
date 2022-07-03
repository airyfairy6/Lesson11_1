import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Test1111 {
    private static Logger logger = LoggerFactory.getLogger(Test1111.class);

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("java.util.logging.config.file", ClassLoader.getSystemResource("logging.properties").getPath());
    }

    @BeforeAll
    static void setup() {
        System.out.println("BeforeAll executed");
    }

    @BeforeEach
    void setupThis() {
        System.out.println("BeforeEach executed");
    }

    @Test
     void test() {
        System.out.println("Executed test method");
    }

    @Disabled
    @Test
    void additionTest() {

    }

    @DisplayName("Testing addition")
    @Test
    void addition2Test() {
        System.out.println("Function named 1 executed");
    }



    @Tag("a")
    @Test
    void test1() {
        System.out.println("Fulfilling a");
    }

    @DisplayName("Repeated Test")
    @RepeatedTest(value = 2, name = "{displayName} -> {currentRepetition}")
    void repeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println("Current iteration: " + repetitionInfo.getCurrentRepetition());

    }




    @AfterEach
    void tearThis() {
        System.out.println("AfterEach executed");
    }

    @AfterAll
    static void tear() {
        System.out.println("AfterAll executed");
    }

}
