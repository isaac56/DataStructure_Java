package LinkedList;

import CustomInterface.CustomList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DoublyCircularLinkedListTest {
    CustomList<Integer> test;

    @BeforeEach
    void setUp() {
         test = new DoublyCircularLinkedList<>();
    }

    @Test
    void fullFunctionTest(){
        LinkedList<Integer> list = new LinkedList<>();
        // {5, 4, 3, 2, 1, 1, 2, 3, 4, 5}
        for(int i = 1; i <= 5; i++) {
            test.add(i);
            test.add(0, i);
            list.add(i);
            list.add(0, i);
        }
        Assertions.assertEquals(list, test.getList());
        test.add(100);
        list.add(100);
        Assertions.assertEquals(list, test.getList());
        test.add(1, 10);
        list.add(1, 10);
        Assertions.assertEquals(list, test.getList());
        test.add(9);
        list.add(9);
        Assertions.assertEquals(list, test.getList());
        test.add(0,12);
        list.add(0,12);
        Assertions.assertEquals(list, test.getList());
        test.remove(9);
        list.remove(Integer.valueOf(9));
        Assertions.assertEquals(list, test.getList());
        for(int i = 1; i <= 5; i++) {
            test.remove(i);
            test.remove(i);
            list.remove(Integer.valueOf(i));
            list.remove(Integer.valueOf(i));
        }
        Assertions.assertEquals(list, test.getList());
        test.remove(12);
        list.remove(Integer.valueOf(12));
        Assertions.assertEquals(list, test.getList());
        test.remove(10);
        list.remove(Integer.valueOf(10));
        Assertions.assertEquals(list, test.getList());
        test.remove(100);
        list.remove(Integer.valueOf(100));
        Assertions.assertEquals(list, test.getList());
        test.remove(100);
        list.remove(Integer.valueOf(100));
        Assertions.assertEquals(list, test.getList());
    }
}