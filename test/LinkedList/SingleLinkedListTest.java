package LinkedList;

import CustomInterface.CustomList;
import CustomInterface.CustomListTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest extends CustomListTest {

    @BeforeEach
    protected void setUp(){
        super.test = new SingleLinkedList<>();
    }

    @Test
    protected void test() {
        super.fullFunctionTest();
    }
}