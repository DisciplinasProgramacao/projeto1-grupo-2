import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateTest {

 
    static Date date;

    
    @BeforeEach
    public void init(){
        date = new Date(29, 02, 2024);
    }

    @Test
    public void testIfYearIsLeapYear(){
        assertTrue(date.isLeapYear());
        
    }

    @Test
    public void isDateValid(){
        assertTrue(date.isDateValid());
    }

    @Test
    public void testingInvalidDateAnswer(){
        Date dateInvalid = new Date(29, 02, 2022);
        assertFalse(dateInvalid.isDateValid());
    }


    @Test
    public void testingFormatedStringMethod(){
        assertEquals("29/02/2024",date.formatedDate());
    }

    
    
}
