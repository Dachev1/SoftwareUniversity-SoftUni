import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;

    @Before
    public void setUp() {
        this.bst = new BinarySearchTree<>(5);
        this.bst.insert(3);
        this.bst.insert(7);
        this.bst.insert(6);
        this.bst.insert(1);
        this.bst.insert(17);
    }

    @Test
    public void testCreate() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(5);
        assertEquals(Integer.valueOf(5), bst.getRoot().getValue());
    }

    @Test
    public void testInsert() {
        assertEquals(Integer.valueOf(3), this.bst.getRoot().getLeft().getValue());
        assertEquals(Integer.valueOf(7), this.bst.getRoot().getRight().getValue());
        assertEquals(Integer.valueOf(6), this.bst.getRoot().getRight().getLeft().getValue());
    }

    @Test
    public void testEachInOrder() {
        List<Integer> elements = new ArrayList<>();
        this.bst.eachInOrder(elements::add);

        List<Integer> expected = new ArrayList<>(
                Arrays.asList(1, 3, 5, 6, 7, 17)
        );

        assertEquals(elements, expected);
    }

    @Test
    public void testContainsTrue() {
        assertTrue(bst.contains(7));
    }

    @Test
    public void testContainsFalse() {
        assertFalse(this.bst.contains(13));
    }

    @Test
    public void testSearchTrue() {
        BinarySearchTree<Integer> search = this.bst.search(7);

        this.bst.insert(8);

        assertEquals(Integer.valueOf(7), search.getRoot().getValue());
        assertEquals(Integer.valueOf(6), search.getRoot().getLeft().getValue());
        assertEquals(Integer.valueOf(17), search.getRoot().getRight().getValue());

        assertTrue(this.bst.contains(8));
        assertFalse(search.contains(8));
    }

    @Test
    public void testSearchFalse() {
        assertNull(bst.search(8));
    }

    @Test
    public void testRange() {
        List<Integer> expected = new ArrayList<>(
                Arrays.asList(5, 3, 7, 1, 6)
        );

        assertEquals(expected, this.bst.range(1, 7));
    }

    @Test
    public void testRangeWhenIsEmpty() {
        assertEquals(new ArrayList<Integer>(), this.bst.range(19, 22));
    }

    @Test
    public void testDeleteMin() {
        this.bst.deleteMin();
        assertFalse(this.bst.contains(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteMinIfTreeIsEmpty() {
        BinarySearchTree<Integer> emptyTree = new BinarySearchTree<>();
        emptyTree.deleteMin();
    }

    @Test
    public void testDeleteMax() {
        this.bst.deleteMax();
        assertFalse(this.bst.contains(17));
    }

    @Test
    public void testCount() {
        assertEquals(6, this.bst.count());
    }

    @Test
    public void testCountAfterInsert() {
        this.bst.insert(13);
        assertEquals(7, this.bst.count());
    }

    @Test
    public void testCountAfterDeleteMin() {
        this.bst.deleteMax();
        assertEquals(5, this.bst.count());
    }

    @Test
    public void testRank() {
        assertEquals(4, this.bst.rank(7));
    }

    @Test
    public void testFloor() {
        assertEquals(Integer.valueOf(3), this.bst.floor(1));
    }
}
