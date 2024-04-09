package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ToyStoryTest {
    private Toy toy;
    private ToyStore toyStore;

    @Before
    public void setUp() {
        this.toy = new Toy("Fenix", "SS");
        this.toyStore = new ToyStore();
    }

    @Test
    public void getVaultCells() {
        Map<String, Toy> toyShelf = new LinkedHashMap<>();
        toyShelf.put("A", null);
        toyShelf.put("B", null);
        toyShelf.put("C", null);
        toyShelf.put("D", null);
        toyShelf.put("E", null);
        toyShelf.put("F", null);
        toyShelf.put("G", null);
        Assert.assertEquals(toyShelf, toyStore.getToyShelf());

    }

    @Test (expected = IllegalArgumentException.class)
    public void test_addToy_Should_Throw_Exception_When_Shelf_Isnt_Exist() throws OperationNotSupportedException {
        this.toyStore.addToy("Q", this.toy);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_addToy_Should_Throw_Exception_When_Shelf_Is_Already_Have_A_Toy() throws OperationNotSupportedException {
        this.toyStore.addToy("A", this.toy);
        Toy toy1 = new Toy("Ivan", "A");
        this.toyStore.addToy("A", toy1);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void test_addToy_If_Item_Exist_Should_Throw_Exception() throws OperationNotSupportedException {
        this.toyStore.addToy("A", this.toy);
        this.toyStore.addToy("B", this.toy);
    }

    @Test
    public void test_Should_Add_Item_Successfully() throws OperationNotSupportedException {
        this.toyStore.addToy("A", this.toy);

       Assert.assertEquals("Fenix", this.toyStore.getToyShelf().get("A").getManufacturer());
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_removeToy_Should_Throw_Exception_When_Shelf_Isnt_Exist() {
        this.toyStore.removeToy("Q", this.toy);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_removeToy_Should_Throw_Exception_When_Shelf_Hasnt_Have_A_Toy() {
        this.toyStore.removeToy("A",this.toy);
    }

    @Test
    public void test_removeToy_Should_Remove_Successfully() throws OperationNotSupportedException {
        this.toyStore.addToy("A", this.toy);
        this.toyStore.removeToy("A",this.toy);

        Assert.assertEquals(null, this.toyStore.getToyShelf().get("A"));
    }
}