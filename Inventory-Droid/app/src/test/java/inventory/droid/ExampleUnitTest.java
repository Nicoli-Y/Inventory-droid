package inventory.droid;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class ExampleUnitTest {

    @Test
    public void readItemJsonToString() throws Exception {
        String jsonStr = FileUtils.readFileToString(new File("item.json"), "UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        Item itemJson = mapper.readValue(jsonStr, Item.class);
        System.out.println(jsonStr);
        Item itemExpected = new Item("1", "Hammer", "Tool");

        assertEquals(itemExpected, itemJson);
    }


    @Test
    public void readItemFilesToInfo() throws Exception {
        String jsonStr = FileUtils.readFileToString(new File("items.json"), "UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        Equipment box = mapper.readValue(jsonStr, Equipment.class);

        System.out.println(jsonStr);

        List<Item> expectedList = new ArrayList<>();
        expectedList.add(new Item("1", "Hammer", "Tool"));
        expectedList.add(new Item("2", "5m Wire", "Electrical"));
        expectedList.add(new Item("3", "Fence", "Hardware"));


        assertArrayEquals(expectedList.toArray(), box.items.toArray());
    }
}