package by.shumilin.task1.entity;

import by.shumilin.exception.ArrayNotExsistExeption;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class ArrayTest {

    @Test(expected = ArrayNotExsistExeption.class)
    public void fillArrayRandom_Not_Exist_Array() throws ArrayNotExsistExeption {
        Array array = new Array();
        long expected = 5;

        array.fillArrayRandom(new Random());

        int actual = array.getArr().length;

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = ArrayNotExsistExeption.class)
    public void fillArrayRandom_Not_Empty_Array() throws ArrayNotExsistExeption {
        Array array = new Array();
        long[] data = new long[10];
        array.setArr(data);
        long expected = 10;

        array.fillArrayRandom(new Random());

        int actual = array.getArr().length;

        Assert.assertEquals(expected, actual);
    }

}