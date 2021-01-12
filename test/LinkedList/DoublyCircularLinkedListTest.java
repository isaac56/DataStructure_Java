package LinkedList;

import CustomInterface.CustomList;
import CustomInterface.CustomListTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class DoublyCircularLinkedListTest extends CustomListTest {
    @BeforeEach
    protected void setUp() {
        super.test = new DoublyCircularLinkedList<>();
    }

    @Test
    void test(){
        super.fullFunctionTest();
    }
}