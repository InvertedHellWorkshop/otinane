package com.p4fun.otinane.model;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

public class ItemTest {
    @Test
    public void testGetName() throws Exception {
        final Item item = new Item();
        final Field field = item.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(item, "gun");

        final String result = item.getName();

        Assert.assertEquals(result, "gun");

    }

    @Test
    public void testSetName() throws Exception {
        final Item item = new Item();

        item.setName("gun");

        final Field field = item.getClass().getDeclaredField("name");
        field.setAccessible(true);
        Assert.assertEquals(field.get(item), "gun");

    }

    @Test
    public void testGetLatitude() throws Exception {
        final Item item = new Item();
        final Field field = item.getClass().getDeclaredField("latitude");
        field.setAccessible(true);
        field.set(item, 66.666);

        final double result = item.getLatitude();

        Assert.assertEquals(result, 66.666, 0);

    }

    @Test
    public void testSetLatitude() throws Exception {
        final Item item = new Item();

        item.setLatitude(66.666);

        final Field field = item.getClass().getDeclaredField("latitude");
        field.setAccessible(true);
        Assert.assertEquals(field.get(item), 66.666);

    }

    @Test
    public void testGetLongitude() throws Exception {
        final Item item = new Item();
        final Field field = item.getClass().getDeclaredField("longitude");
        field.setAccessible(true);
        field.set(item, 66.666);

        final double result = item.getLongitude();

        Assert.assertEquals(result, 66.666, 0);

    }

    @Test
    public void testSetLongitude() throws Exception {
        final Item item = new Item();

        item.setLongitude(66.666);

        final Field field = item.getClass().getDeclaredField("longitude");
        field.setAccessible(true);
        Assert.assertEquals(field.get(item), 66.666);

    }

}