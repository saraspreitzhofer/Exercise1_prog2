package at.ac.fhcampuswien;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    @DisplayName("Has password valid length")
    public void testPasswordLength1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("password1234"));
    }
    @Test
    public void testPasswordLength2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("pw1"));
    }
    @Test
    public void testPasswordLength3(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("pw1234pw1234pw1234pw1234pw"));
    }

}
