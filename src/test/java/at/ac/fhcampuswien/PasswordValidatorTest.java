package at.ac.fhcampuswien;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    @DisplayName("Has password valid length")
    public void testPasswordLength_1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.isValid("password1234"));
    }
    @Test
    public void testPasswordLength_2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.isValid("pw1"));
    }
    @Test
    public void testPasswordLength_3(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.isValid("pw1234pw1234pw1234pw1234pw"));
    }

}
