import com.graphassignment.*;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;


import static org.junit.Assert.*;

public class GraphTest {

    @Test
    public void BaseClassObjectTest() throws Exception{
        BaseClass baseClass = new BaseClass();
        assertNotNull("Working Fine", baseClass);
    }

    @Test
    public void GraphObjectTest() throws Exception{
        Graph graph = new Graph();
        assertNotNull("Working Fine", graph);
    }

    @Test
    public void immidiateChildObjectTest() throws Exception{
        immidiateParent immidiateparent = new immidiateParent();
        assertNotNull("Working Fine", immidiateparent);
    }

    @Test
    public void immidiateParentObjectTest() throws Exception{
        immidiateParent immidiateparent = new immidiateParent();
        assertNotNull("Working Fine", immidiateparent);
    }
}
