package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {
    private static final String ARCHAEOLOGIST_INITIAL_NAME_1 = "Ivan";
    private static final String ARCHAEOLOGIST_INITIAL_NAME_2 = "Ivo";
    private static final String ARCHAEOLOGIST_INITIAL_NAME_3 = "Kris";
    private static final String EXCAVATION_INITIAL_NAME = "Perperikon";
    private static final String EMPTY_NAME = " ";
    private static final int EXCAVATION_INITIAL_CAPACITY = 2;
    private static final int EXCAVATION_INVALID_CAPACITY = -1;

    private Archaeologist archaeologist;
    private Excavation excavation;

    @Before
    public void setUp() {
        this.archaeologist = new Archaeologist(ARCHAEOLOGIST_INITIAL_NAME_1, 50);
        this.excavation = new Excavation(EXCAVATION_INITIAL_NAME, EXCAVATION_INITIAL_CAPACITY);
    }

    @Test
    public void test_Constructor_Should_Create_Correct_Object() {
        String actualName = this.excavation.getName();
        int capacity = this.excavation.getCapacity();

        Assert.assertEquals(EXCAVATION_INITIAL_NAME, actualName);
        Assert.assertEquals(EXCAVATION_INITIAL_CAPACITY, capacity);
    }

    @Test (expected = NullPointerException.class)
    public void test_Constructor_Should_Throw_When_Name_Is_Null() {
        this.excavation = new Excavation(null, EXCAVATION_INITIAL_CAPACITY);
    }

    @Test (expected = NullPointerException.class)
    public void test_Constructor_Should_Throw_When_Name_Is_Empty() {
        this.excavation = new Excavation(EMPTY_NAME, EXCAVATION_INITIAL_CAPACITY);
    }
    @Test (expected = IllegalArgumentException.class)
    public void test_Constructor_Should_Throw_When_Capacity_Is_Negative() {
        this.excavation = new Excavation(EXCAVATION_INITIAL_NAME, EXCAVATION_INVALID_CAPACITY);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_AddArchaeologist_Should_Throw_When_Archaeologists_Size_Equal_Capacity() {
        this.excavation.addArchaeologist(this.archaeologist);
        Archaeologist archaeologist1 = new Archaeologist(ARCHAEOLOGIST_INITIAL_NAME_2, 50);
        Archaeologist archaeologist2 = new Archaeologist(ARCHAEOLOGIST_INITIAL_NAME_3, 50);
        this.excavation.addArchaeologist(archaeologist1);
        this.excavation.addArchaeologist(archaeologist2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_AddArchaeologist_Should_Throw_When_Archaeologist_Exist() {
        this.excavation.addArchaeologist(this.archaeologist);
        this.excavation.addArchaeologist(this.archaeologist);
    }

    @Test
    public void test_AddArchaeologist_Should_Add() {
        this.excavation.addArchaeologist(this.archaeologist);
        Assert.assertEquals(1, this.excavation.getCount());
    }

    @Test
    public void test_RemoveArchaeologist_Should_Remove() {
        this.excavation.addArchaeologist(this.archaeologist);
        this.excavation.removeArchaeologist(this.archaeologist.getName());
        Assert.assertEquals(0, this.excavation.getCount());
    }

    @Test
    public void test_RemoveArchaeologist_Should_Do_Noting() {
        this.excavation.addArchaeologist(this.archaeologist);
        this.excavation.removeArchaeologist("Kris");
        Assert.assertEquals(1, this.excavation.getCount());
    }
}
