package com.example.datastructure.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.print.attribute.HashAttributeSet;
import java.util.*;
import java.util.stream.Collectors;

import static java.awt.Color.BLACK;
import static java.awt.Color.RED;
import static org.junit.jupiter.api.Assertions.*;

class RedBlackBalanceTreeTest {

    private RedBlackBalanceTree<Integer> tree;
    static final int MAX_RAND_NUM = +100000;
    static final int MIN_RAND_NUM = -100000;

    static final int TEST_SZ = 9000;

    @BeforeEach
    void setup() {
        tree = new RedBlackBalanceTree<>();
    }

    @Test
    void testTheSizeOfTree() {
        assertEquals(0, tree.getSize());
    }

    @Test
    void test_IsTreeEmpty() {
        assertTrue(tree.isEmpty());
    }

    @Test
    void test_ContainsValueInTree() {
        assertFalse(tree.contains(10));
    }

    @Test
    public void testHashFunction() {
        HashMap<String, Integer> map = new HashMap<>();
        int leftLimit = 65; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            StringBuilder collect = random.ints(targetStringLength, leftLimit, rightLimit).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
            map.put(collect.toString(), i);
        }
        map.put("ABC", 10);
    }

    @Test
    public void testLeftRightRotation() {
        tree.insert(3);
        tree.insert(1);
        tree.insert(2);

        assertEquals(2, tree.getRoot().getValue().intValue());
        assertEquals(1, tree.getRoot().left().getValue().intValue());
        assertEquals(3, tree.getRoot().right().getValue().intValue());

        assertEquals(BLACK, tree.getRoot().getColour());
        assertEquals(RED, tree.getRoot().left().getColour());
        assertEquals(RED, tree.getRoot().right().getColour());

        assertEquals(tree.getRoot(), tree.getRoot().left().parent());
        assertEquals(tree.getRoot(), tree.getRoot().right().parent());

        assertNullChildren(tree.getRoot().left(), tree.getRoot().right());
        assertCorrectParentLinks(tree.getRoot(), null);
    }

    @Test
    public void testLeftLeftRotation() {

        tree.insert(3);
        tree.insert(2);
        tree.insert(1);

        assertEquals(2, tree.getRoot().getValue().intValue());
        assertEquals(1, tree.getRoot().left().getValue().intValue());
        assertEquals(3, tree.getRoot().right().getValue().intValue());

        assertEquals(BLACK, tree.getRoot().getColour());
        assertEquals(RED, tree.getRoot().left().getColour());
        assertEquals(RED, tree.getRoot().right().getColour());

        assertEquals(tree.getRoot(), tree.getRoot().left().parent());
        assertEquals(tree.getRoot(), tree.getRoot().right().parent());

        assertNullChildren(tree.getRoot().left(), tree.getRoot().right());
        assertCorrectParentLinks(tree.getRoot(), null);
    }

    @Test
    public void testRightLeftRotation() {

        tree.insert(1);
        tree.insert(3);
        tree.insert(2);

        assertEquals(2, tree.getRoot().getValue().intValue());
        assertEquals(1, tree.getRoot().left().getValue().intValue());
        assertEquals(3, tree.getRoot().right().getValue().intValue());

        assertEquals(BLACK, tree.getRoot().getColour());
        assertEquals(RED, tree.getRoot().left().getColour());
        assertEquals(RED, tree.getRoot().right().getColour());

        assertEquals(tree.getRoot(), tree.getRoot().left().parent());
        assertEquals(tree.getRoot(), tree.getRoot().right().parent());

        assertNullChildren(tree.getRoot().left(), tree.getRoot().right());
        assertCorrectParentLinks(tree.getRoot(), null);
    }

    @Test
    public void testRightRightRotation() {

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        assertEquals(2, tree.getRoot().getValue().intValue());
        assertEquals(1, tree.getRoot().left().getValue().intValue());
        assertEquals(3, tree.getRoot().right().getValue().intValue());

        assertEquals(BLACK, tree.getRoot().getColour());
        assertEquals(RED, tree.getRoot().left().getColour());
        assertEquals(RED, tree.getRoot().right().getColour());

        assertEquals(tree.getRoot(), tree.getRoot().left().parent());
        assertEquals(tree.getRoot(), tree.getRoot().right().parent());

        assertNullChildren(tree.getRoot().left(), tree.getRoot().right());
        assertCorrectParentLinks(tree.getRoot(), null);
    }


    @Test
    public void testLeftUncleCase() {

        /* Red left uncle case. */

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);

        assertEquals(2, tree.getRoot().getValue().intValue());
        assertEquals(1, tree.getRoot().left().getValue().intValue());
        assertEquals(3, tree.getRoot().right().getValue().intValue());
        assertEquals(4, tree.getRoot().right().right().getValue().intValue());

        assertEquals(BLACK, tree.getRoot().getColour());
        assertEquals(BLACK, tree.getRoot().left().getColour());
        assertEquals(BLACK, tree.getRoot().right().getColour());
        assertEquals(RED, tree.getRoot().right().right().getColour());

        assertNull(tree.getRoot().right().left());
        assertNullChildren(tree.getRoot().left(), tree.getRoot().right().right());
        assertCorrectParentLinks(tree.getRoot(), null);

        /* Black left uncle case. */

        tree.insert(5);

        assertEquals(2, tree.getRoot().getValue().intValue());
        assertEquals(1, tree.getRoot().left().getValue().intValue());
        assertEquals(4, tree.getRoot().right().getValue().intValue());
        assertEquals(3, tree.getRoot().right().left().getValue().intValue());
        assertEquals(5, tree.getRoot().right().right().getValue().intValue());

        assertEquals(BLACK, tree.getRoot().getColour());
        assertEquals(BLACK, tree.getRoot().left().getColour());
        assertEquals(BLACK, tree.getRoot().right().getColour());
        assertEquals(RED, tree.getRoot().right().left().getColour());
        assertEquals(RED, tree.getRoot().right().right().getColour());
        assertCorrectParentLinks(tree.getRoot(), null);
    }


    @Test
    public void testRightUncleCase() {

        /* Red right uncle case. */

        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(1);

        assertEquals(3, tree.getRoot().getValue().intValue());
        assertEquals(2, tree.getRoot().left().getValue().intValue());
        assertEquals(4, tree.getRoot().right().getValue().intValue());
        assertEquals(1, tree.getRoot().left().left().getValue().intValue());

        assertEquals(BLACK, tree.getRoot().getColour());
        assertEquals(BLACK, tree.getRoot().left().getColour());
        assertEquals(BLACK, tree.getRoot().right().getColour());
        assertEquals(RED, tree.getRoot().left().left().getColour());

        assertNull(tree.getRoot().right().left());
        assertNull(tree.getRoot().left().right());
        assertNullChildren(tree.getRoot().right(), tree.getRoot().left().left());
        assertCorrectParentLinks(tree.getRoot(), null);

        /* Black right uncle case. */

        tree.insert(0);

        assertEquals(3, tree.getRoot().getValue().intValue());
        assertEquals(1, tree.getRoot().left().getValue().intValue());
        assertEquals(4, tree.getRoot().right().getValue().intValue());
        assertEquals(0, tree.getRoot().left().left().getValue().intValue());
        assertEquals(2, tree.getRoot().left().right().getValue().intValue());

        assertEquals(BLACK, tree.getRoot().getColour());
        assertEquals(BLACK, tree.getRoot().left().getColour());
        assertEquals(BLACK, tree.getRoot().right().getColour());
        assertEquals(RED, tree.getRoot().left().left().getColour());
        assertEquals(RED, tree.getRoot().left().right().getColour());
        assertCorrectParentLinks(tree.getRoot(), null);
    }

    @Test
    public void interestingCase1() {

        int[] values = {41, 44, 95, 83, 72, 66, 94, 90, 59};
        for (int value : values) {
            tree.insert(value);
        }

        assertEquals(44, tree.getRoot().getValue().intValue());
        assertEquals(41, tree.getRoot().left().getValue().intValue());
        assertEquals(83, tree.getRoot().right().getValue().intValue());
        assertEquals(66, tree.getRoot().right().left().getValue().intValue());
        assertEquals(94, tree.getRoot().right().right().getValue().intValue());
        assertEquals(59, tree.getRoot().right().left().left().getValue().intValue());
        assertEquals(72, tree.getRoot().right().left().right().getValue().intValue());
        assertEquals(90, tree.getRoot().right().right().left().getValue().intValue());
        assertEquals(95, tree.getRoot().right().right().right().getValue().intValue());

        assertEquals(BLACK, tree.getRoot().getColour());
        assertEquals(BLACK, tree.getRoot().left().getColour());
        assertEquals(RED, tree.getRoot().right().getColour());
        assertEquals(BLACK, tree.getRoot().right().left().getColour());
        assertEquals(BLACK, tree.getRoot().right().right().getColour());
        assertEquals(RED, tree.getRoot().right().left().left().getColour());
        assertEquals(RED, tree.getRoot().right().left().right().getColour());
        assertEquals(RED, tree.getRoot().right().right().left().getColour());
        assertEquals(RED, tree.getRoot().right().right().right().getColour());
    }

    @Test
    public void test() {
        for (int i = 1; i <= 30; i++) {
            tree.insert(i);
        }
        assertEquals(8, tree.getRoot().getValue());

    }

    @Test
    public void testRandomizedValueInsertionsAgainstTreeSet() {

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < TEST_SZ; i++) {
            int v = randValue();
            assertEquals(set.add(v), tree.insert(v));
            assertEquals(set.size(), tree.getSize());
            assertTrue(tree.contains(v));
            assertTrue(assertBinarySearchTreeInvariant(tree, tree.getRoot()));
        }
    }

    boolean assertBinarySearchTreeInvariant(RedBlackBalanceTree<Integer> tree, RedBlackBalanceTree<Integer>.Node<Integer> node) {
        if (node == null) return true;
        boolean isValid = true;
        if (node.left() != null) isValid = node.left().getValue().compareTo(node.getValue()) < 0;
        if (node.right() != null) isValid = isValid && node.right().getValue().compareTo(node.getValue()) > 0;
        return isValid
                && assertBinarySearchTreeInvariant(tree, node.left())
                && assertBinarySearchTreeInvariant(tree, node.right());
    }

    public static int randValue() {
        return (int) (Math.random() * MAX_RAND_NUM * 2) + MIN_RAND_NUM;
    }


    static void assertCorrectParentLinks(RedBlackBalanceTree<Integer>.Node<Integer> node,
                                         RedBlackBalanceTree<Integer>.Node<Integer> parent) {
        if (node == null) return;
        try {
            assertEquals(parent, node.parent());
        } catch (AssertionError e) {
            e.printStackTrace();
        }
        assertCorrectParentLinks(node.left(), node);
        assertCorrectParentLinks(node.right(), node);
    }


    @SafeVarargs
    static void assertNullChildren(RedBlackBalanceTree<Integer>.Node<Integer>... nodes) {
        for (RedBlackBalanceTree<Integer>.Node<Integer> node : nodes) {
            assertNull(node.left());
            assertNull(node.right());
        }
    }


    @Test
    void test_InOrderTraversal() {
        int[] val = {1, 4, 6, 3, 5, 7, 8, 2, 9};
        for (int i : val) {
            assertTrue(tree.insert(i));
        }
        Object[] list = tree.inOrderTraversal().toArray();
        System.out.println(Arrays.toString(list));
    }
}