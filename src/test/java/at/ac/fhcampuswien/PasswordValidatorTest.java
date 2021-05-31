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
        assertFalse(pw.checkPasswordNull(null));
    }


    @Test
    @DisplayName("Password length valid")
    public void testPasswordLength1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPasswordLength("!Password12"));
    }
    @Test
    @DisplayName("Password length too short")
    public void testPasswordLength2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPasswordLength("!pw1"));
    }
    @Test
    @DisplayName("Password length too long")
    public void testPasswordLength3(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPasswordLength("!pw3412pw3412pw3412pw3412pw"));
    }


    @Test
    @DisplayName("Password has upper and lower case letters")
    public void testPasswordUpperLowerCase1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPasswordUpperLowerCase("!Abcdefgh1"));
    }
    @Test
    @DisplayName("Password has no upper case letter")
    public void testPasswordUpperLowerCase2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPasswordUpperLowerCase("!abcdefgh1"));
    }
    @Test
    @DisplayName("Password has no lower case letter")
    public void testPasswordUpperLowerCase3(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPasswordUpperLowerCase("!ABCDEFGH1"));
    }
    @Test
    @DisplayName("Password has no letter")
    public void testPasswordUpperLowerCase4(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPasswordUpperLowerCase("!987654321"));
    }


    @Test
    @DisplayName("Password has numbers")
    public void testPasswordHasNumber1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPasswordHasNumber("!Password12"));
    }
    @Test
    @DisplayName("Password has no numbers")
    public void testPasswordHasNumber2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPasswordHasNumber("!Password"));
    }


    @Test
    @DisplayName("Password has special character")
    public void testPasswordSpecialCharacter1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPasswordSpecialCharacter("!Password12"));
    }
    @Test
    @DisplayName("Password has no special character")
    public void testPasswordSpecialCharacter2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPasswordSpecialCharacter("Password12"));
    }
    @Test
    @DisplayName("Password has forbidden special character")
    public void testPasswordSpecialCharacter3(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPasswordSpecialCharacter(".Password12"));
    }


    @Test
    @DisplayName("Password has no continuous numbers")
    public void testPasswordContinuousNumbers1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPasswordContinuousNumbers("!3Password12"));
    }
    @Test
    @DisplayName("Password has continuous numbers")
    public void testPasswordContinuousNumbers2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPasswordContinuousNumbers("!Password123"));
    }


    @Test
    @DisplayName("Password has same number less than 4 times in series")
    public void testPasswordSameNumber1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPasswordSameNumber("!Password222"));
    }
    @Test
    @DisplayName("Password has same number more than or exactly 4 times in series")
    public void testPasswordSameNumber2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPasswordSameNumber("!Password2222"));
    }
    @Test
    @DisplayName("Password has same number less than 4 times in series")
    public void testPasswordSameNumber3(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPasswordSameNumber("!Passwordddd22"));
    }


    @Test
    @DisplayName("Password is valid")
    public void testPassword1(){
        PasswordValidator pw = new PasswordValidator();
        assertTrue(pw.checkPassword("!Passwordddd22"));
    }@Test
    @DisplayName("Password is not valid")
    public void testPassword2(){
        PasswordValidator pw = new PasswordValidator();
        assertFalse(pw.checkPassword("!234Passwordddd22"));
    }
}
