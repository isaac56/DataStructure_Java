package LinkedList;

import CustomInterface.CustomListTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest extends CustomListTest {
    @BeforeEach
    protected void setUp(){
        super.test = new DoubleLinkedList<>();
    }

    @Test
    protected void test(){
        super.fullFunctionTest();
    }
}