package at.ac.fhcampuswien;

import java.util.Locale;

public class PasswordValidator {
    public boolean checkPassword(String password){
        if(password == null){                                           //testPasswordNull
            return false;
        }
        else if(password.length() < 8 || password.length() > 25){       //testPasswordLength
            return false;
        }
        else if(password.equals(password.toLowerCase()) ||              //testPasswordUpperLowerCase
                password.equals(password.toUpperCase())){
            return false;
        }
        else{
            int count = 0;
            char[] pwArr = password.toCharArray();
            for(char c : pwArr){
                if(Character.isDigit(c)){
                    count++;
                }
            }
            if(count == pwArr.length){                                  //testPasswordUpperLowerCase
                return false;
            }
            else if(count == 0){                                        //testPasswordHasNumber
                return false;
            }
        }
        return true;
    }
}
