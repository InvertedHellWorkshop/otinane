package com.p4fun.otinane.model;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Field;

public class InventoryTest {
    @Test
    public void getUserId() throws Exception {
        final User user = new User();
        final Field field = user.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(user, 1);

        final int result = user.getId();

        Assert.assertEquals(result, 1);

    }

    @Test
    public void setUserId() throws Exception {
        final User user = new User();

        user.setId(1);

        final Field field = user.getClass().getDeclaredField("id");
        field.setAccessible(true);
        Assert.assertEquals(field.get(user), 1);

    }

    @Test
    public void getItemId() throws Exception {
        final Item item = new Item();
        final Field field = item.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(item, 1);

        final int result = item.getId();

        Assert.assertEquals(result, 1);

    }

    @Test
    public void setItemId() throws Exception {
        final Item item = new Item();

        item.setId(1);

        final Field field = item.getClass().getDeclaredField("id");
        field.setAccessible(true);
        Assert.assertEquals(field.get(item), 1);

    }

}