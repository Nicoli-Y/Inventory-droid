package inventory.droid;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;


public class ExampleUnitTest {
    @Test
    public void readitemJsonToString() throws Exception {
        String jsonStr = FileUtils.readFileToString(new File("item.json"), "UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        Item itemJson = mapper.readValue(jsonStr, Item.class);
        System.out.println(jsonStr);
        Item itemExpected = new Item("1", "Hammer", "Tool");

        assertEquals(itemExpected, itemJson);
    }
}
