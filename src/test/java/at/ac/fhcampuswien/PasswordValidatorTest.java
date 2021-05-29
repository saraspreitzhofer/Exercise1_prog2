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
        assertTrue(pw.checkPassword("!Password1234"));
    }
    @Test
    @DisplayName("Password length too short")
    public void testPasswordLength2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("!pw1"));
    }
    @Test
    @DisplayName("Password length too long")
    public void testPasswordLength3(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("!pw1234pw1234pw1234pw1234pw"));
    }

    @Test
    @DisplayName("Password has upper and lower case letters")
    public void testPasswordUpperLowerCase1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("!Abcdefgh1"));
    }
    @Test
    @DisplayName("Password has no upper case letter")
    public void testPasswordUpperLowerCase2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("!abcdefgh1"));
    }
    @Test
    @DisplayName("Password has no lower case letter")
    public void testPasswordUpperLowerCase3(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("!ABCDEFGH1"));
    }
    @Test
    @DisplayName("Password has no letter")
    public void testPasswordUpperLowerCase4(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("!123456789"));
    }

    @Test
    @DisplayName("Password has numbers")
    public void testPasswordHasNumber1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("!Password12"));
    }
    @Test
    @DisplayName("Password has no numbers")
    public void testPasswordHasNumber2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("!Password"));
    }

    @Test
    @DisplayName("Password has special character")
    public void testPasswordSpecialCharacter1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("!Password12"));
    }
    @Test
    @DisplayName("Password has no special character")
    public void testPasswordSpecialCharacter2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("Password12"));
    }
    @Test
    @DisplayName("Password has forbidden special character")
    public void testPasswordSpecialCharacter3(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword(".Password12"));
    }
/*
    @Test
    @DisplayName("Password has no continuous numbers")
    public void testPasswordContinuousNumbers1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("!3Password12"));
    }
    @Test
    @DisplayName("Password has continuous numbers")
    public void testPasswordContinuousNumbers2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("!Password123"));
    }
*/
    @Test
    @DisplayName("Password has same number less than 4 times in series")
    public void testPasswordSameNumber1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("!Password222"));
    }
    @Test
    @DisplayName("Password has same number more than or exactly 4 times in series")
    public void testPasswordSameNumber2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("!Password2222"));
    }
    @Test
    @DisplayName("Password has same number less than 4 times in series")
    public void testPasswordSameNumber3(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("!Passwordddd22"));
    }
}
