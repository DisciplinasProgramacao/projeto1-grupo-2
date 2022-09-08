import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskTest {
    static Task task;

    @BeforeEach
    public void init(){
        task = new Task("01/01/2022", "Dog walking", "Walking with my dog", 7);
    }

    //Testing the getters and setters to see if the instance was created right
    @Test
    public void testingReturningTaskName(){
        assertEquals("Dog walking", task.getName());
    }

    @Test
    public void testingReturningTaskDescription(){
        assertEquals("Walking with my dog", task.getDescription());
    }


}
