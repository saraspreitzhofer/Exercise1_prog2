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
            int letterCount = 0;
            int specialCount = 0;
            char[] pwArr = password.toCharArray();
            //for(char c : pwArr){
            for(int i=0; i<pwArr.length; i++){
                char c = pwArr[i];
                if(Character.isDigit(c)){
                    letterCount++;
                }
                if(c < 'A' || c > 'z' || (c > 'Z' && c < 'a')){
                    switch (c){
                        case '(':
                        case ')':
                        case '#':
                        case '$':
                        case '?':
                        case '!':
                        case '%':
                        case '/':
                        case '@':
                            specialCount++;
                            break;
                        default:
                            break;
                    }
                }
                if(pwArr.length > 3 && i < (pwArr.length - 3)){               //testPasswordSameNumber
                    if(pwArr[i]==pwArr[i+1] && pwArr[i]==pwArr[i+2] && pwArr[i]==pwArr[i+3] && pwArr[i]>='0' && pwArr[i]<='9'){
                        return false;
                    }
                }
            }
            if(letterCount == pwArr.length){                                  //testPasswordUpperLowerCase
                return false;
            }
            else if(letterCount == 0){                                        //testPasswordHasNumber
                return false;
            }
            else if(specialCount == 0){                                       //testPasswordSpecialCharacter
                return false;
            }
        }
        /*if(password.contains("012") ||                                        //testPasswordContinuousNumbers
                password.contains("123") ||
                password.contains("234") ||
                password.contains("345") ||
                password.contains("456") ||
                password.contains("567") ||
                password.contains("678") ||
                password.contains("789")){
            return false;
        }*/
        return true;
    }
}
