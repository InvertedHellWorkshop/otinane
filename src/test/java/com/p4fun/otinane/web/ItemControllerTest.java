package com.p4fun.otinane.web;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import com.p4fun.otinane.OtinaneApplication;
import com.p4fun.otinane.model.Item;
import com.p4fun.otinane.repository.ItemRepository;
import com.p4fun.otinane.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OtinaneApplication.class)
public class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemController itemController;

    private MockMvc mockMvc;

    private MediaType applicationJsonMediaType = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8")
    );

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
    }

    @Test
    public void testGetItemsSuccess() throws Exception {


        List<Item> items = new ArrayList<>();

        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();

        int id1= 1;
        int id2= 2;
        int id3= 3;

        String name1 = "item1";
        String name2 = "item2";
        String name3 = "item3";

        Double lat1 = 41.000000;
        Double lat2 = 42.000000;
        Double lat3 = 43.000000;

        Double lng1 = 51.000000;
        Double lng2 = 52.000000;
        Double lng3 = 53.000000;

        String desc1 = "Description1";
        String desc2 = "Description2";
        String desc3 = "Description3";

        item1.setId(id1);
        item1.setName(name1);
        item1.setLatitude(lat1);
        item1.setLongitude(lng1);
        item1.setDescription(desc1);

        item2.setId(id2);
        item2.setName(name2);
        item2.setLatitude(lat2);
        item2.setLongitude(lng2);
        item2.setDescription(desc2);

        item3.setId(id3);
        item3.setName(name3);
        item3.setLatitude(lat3);
        item3.setLongitude(lng3);
        item3.setDescription(desc3);

        items.add(item1);
        items.add(item2);
        items.add(item3);

        doReturn(items).when(itemService).getAllItems();
        mockMvc.perform(get("/items").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(applicationJsonMediaType))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[*].id").exists())
                .andExpect(jsonPath("$[*].name").exists())
                .andExpect(jsonPath("$[*].latitude").exists())
                .andExpect(jsonPath("$[*].longitude").exists())
                .andExpect(jsonPath("$[*].description").exists())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(3)))
                .andExpect(jsonPath("$[0].name", is("item1")))
                .andExpect(jsonPath("$[1].name", is("item2")))
                .andExpect(jsonPath("$[2].name", is("item3")))
                .andExpect(jsonPath("$[0].latitude", is(41.000000)))
                .andExpect(jsonPath("$[1].latitude", is(42.000000)))
                .andExpect(jsonPath("$[2].latitude", is(43.000000)))
                .andExpect(jsonPath("$[0].longitude", is(51.000000)))
                .andExpect(jsonPath("$[1].longitude", is(52.000000)))
                .andExpect(jsonPath("$[2].longitude", is(53.000000)))
                .andExpect(jsonPath("$[0].description", is("Description1")))
                .andExpect(jsonPath("$[1].description", is("Description2")))
                .andExpect(jsonPath("$[2].description", is("Description3")))
        ;

        verify(itemService, times(1)).getAllItems();

    }

    @Test
    public void testGetSingleItem() throws Exception{


        Item item = new Item();

        int id1= 1;
        String name1 = "item1";
        Double lat1 = 41.000000;
        Double lng1 = 51.000000;
        String desc1 = "Description1";

        item.setId(id1);
        item.setName(name1);
        item.setLatitude(lat1);
        item.setLongitude(lng1);
        item.setDescription(desc1);


        doReturn(item).when(itemService).findByName(name1);
        mockMvc.perform(get("/item").accept(MediaType.APPLICATION_JSON)
                .param("name", name1))

                .andExpect(status().isOk())
                .andExpect(content().contentType(applicationJsonMediaType))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.latitude").exists())
                .andExpect(jsonPath("$.longitude").exists())
                .andExpect(jsonPath("$.description").exists())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("item1")))
                .andExpect(jsonPath("$.latitude", is(41.000000)))
                .andExpect(jsonPath("$.longitude", is(51.000000)))
                .andExpect(jsonPath("$.description", is("Description1")))
        ;

        verify(itemService, times(1)).findByName(name1);

    }
}