package com.example.datastructure.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

//TDD Approach
@ExtendWith(MockitoExtension.class)
class AVLBalanceTreeTest {

    static final int MAX_RAND_NUM = +100000;
    static final int MIN_RAND_NUM = -100000;

    static final int TEST_SZ = 2500;

    private AVLBalanceTree<Integer> balanceTree;

    @BeforeEach
    public void setup() {
        balanceTree = new AVLBalanceTree<>();
    }


    @Test
    public void test_WithoutInsertNoElementsInTree() {
        assertFalse(balanceTree.contains(1));
    }


    @Test
    public void insert_null_should_return_false() {
        assertFalse(balanceTree.insert(null));
        assertEquals(0, balanceTree.getSize());
    }

    @Test
    public void insert_new_element() {
        assertTrue(balanceTree.insert(54));
        assertFalse(balanceTree.insert(54));
        assertEquals(1, balanceTree.getSize());
    }

    @Test
    public void testLeftLeftCase() {
        balanceTree.insert(3);
        balanceTree.insert(2);
        balanceTree.insert(1);
        balanceTree.insert(4);
        assertEquals(1, balanceTree.root.getBalanceFactor());
        assertEquals(2, balanceTree.height());
        assertEquals(2, balanceTree.root.getValue());
        assertEquals(3, balanceTree.root.right().getValue());
        assertEquals(1, balanceTree.root.left().getValue());
        assertNotNull(balanceTree.root.getLeft());
        assertNotNull(balanceTree.root.getRight());
        assertNull(balanceTree.root.getLeft().getLeft());
        assertNull(balanceTree.root.getLeft().getRight());
        assertNull(balanceTree.root.getRight().getLeft());
//        assertNull(balanceTree.root.getRight().getRight());
    }

    @Test
    public void testLeftRightCase() {
        balanceTree.insert(10);
        balanceTree.insert(5);
        balanceTree.insert(7);
        balanceTree.insert(8);
        assertEquals(2, balanceTree.height());
        assertEquals(7, balanceTree.root.getValue());
        assertEquals(10, balanceTree.root.right().getValue());
        assertEquals(5, balanceTree.root.left().getValue());
        assertEquals(8, balanceTree.root.right().left().getValue());
        assertNull(balanceTree.root.right().right());
        assertNull(balanceTree.root.left().right());
        assertNull(balanceTree.root.left().left());
    }

    @Test
    public void testRemoveLastNode() {
        balanceTree.insert(3);
        balanceTree.insert(2);
        balanceTree.insert(1);
        assertTrue(balanceTree.remove(1));
        assertEquals(3, balanceTree.root.right().getValue());
        assertEquals(2, balanceTree.root.getValue());
        assertNull(balanceTree.root.left());
        assertTrue(balanceTree.validateBinarySearchTree(balanceTree.root));
    }

    @Test
    public void deleteRootNode() {
        balanceTree.insert(3);
        balanceTree.insert(2);
        balanceTree.insert(1);
        assertTrue(balanceTree.remove(2));
        assertEquals(1, balanceTree.root.getHeight());
        assertEquals(3, balanceTree.root.right().getValue());
    }

    @Test
    void test_removeWhereChildExist() {
        balanceTree.insert(100);
        balanceTree.insert(50);
        balanceTree.insert(75);
        balanceTree.insert(40);
        balanceTree.insert(85);
        balanceTree.insert(13);
        balanceTree.insert(125);
        balanceTree.insert(130);
        balanceTree.insert(111);
        balanceTree.insert(109);
        assertTrue(balanceTree.remove(75));
        assertFalse(balanceTree.remove(1000));
        assertFalse(balanceTree.contains(75));
        assertTrue(balanceTree.validateBinarySearchTree(balanceTree.root));
    }

    @Test
    public void testRandomizedBalanceFactorTest() {
        for (int i = 0; i < TEST_SZ; i++) {
            balanceTree.insert(randValue());
            assertTrue(balanceTree.validateBalanceFactorValues(balanceTree.root));
        }
    }

    @Test
    public void randomRemoveTests() {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < TEST_SZ; i++) {

            List<Integer> lst = genRandList(i);
            for (Integer value : lst) {
                balanceTree.insert(value);
                ts.add(value);
            }
            Collections.shuffle(lst);

            // Remove all the elements we just placed in the tree.
            for (int j = 0; j < i; j++) {

                Integer value = lst.get(j);

                assertEquals(ts.remove(value), balanceTree.remove(value));
                assertFalse(balanceTree.contains(value));
                assertEquals(i - j - 1, balanceTree.size());
            }

            assertTrue(balanceTree.isEmpty());
            assertNull(balanceTree.root);
        }
    }

    static List<Integer> genRandList(int sz) {
        List<Integer> lst = new ArrayList<>(sz);
        for (int i = 0; i < sz; i++) lst.add(i); // unique values.
        Collections.shuffle(lst);
        return lst;
    }

    public static int randValue() {
        return (int) (Math.random() * MAX_RAND_NUM * 2) + MIN_RAND_NUM;
    }

    @Test
    void testTraverse() {
        balanceTree.insert(10);
        balanceTree.insert(12);
        balanceTree.insert(5);
        balanceTree.insert(6);
        balanceTree.insert(19);
        balanceTree.insert(4);
        System.out.println(balanceTree.toString());
//        while (balanceTree.iterator().hasNext()) {
//            System.out.println(balanceTree.iterator().next());
//        }
    }

}