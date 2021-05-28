package at.ac.fhcampuswien;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    @DisplayName("Password is NULL")
    public void testPasswordNull(){
        PasswordValidator pw = new PasswordValidator();
        //assertThrows(IllegalArgumentException.class, ()->pw.checkPassword(null));
        assertFalse(pw.checkPassword(null));
    }

    @Test
    @DisplayName("Password length valid")
    public void testPasswordLength1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("password1234"));
    }
    @Test
    @DisplayName("Password length too short")
    public void testPasswordLength2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("pw1"));
    }
    @Test
    @DisplayName("Password length too long")
    public void testPasswordLength3(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("pw1234pw1234pw1234pw1234pw"));
    }
/*
    @Test
    @DisplayName("password has upper and lower case letters")
    public void testPasswordUpperLowerCase1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("Abcdefgh"));
    }
    @Test
    @DisplayName("password has no upper case letter")
    public void testPasswordUpperLowerCase2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("abcdefgh"));
    }
    @Test
    @DisplayName("password has no lower case letter")
    public void testPasswordUpperLowerCase3(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("ABCDEFGH"));
    }
*/
}
