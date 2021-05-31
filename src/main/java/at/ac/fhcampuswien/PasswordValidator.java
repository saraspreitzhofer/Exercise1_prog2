package at.ac.fhcampuswien;

import java.util.Locale;

public class PasswordValidator {
    public boolean checkPassword(String password){
        if(!checkPasswordNull(password)) return false;
        if(!checkPasswordLength(password)) return false;
        if(!checkPasswordUpperLowerCase(password)) return false;
        if(!checkPasswordHasNumber(password)) return false;
        if(!checkPasswordSpecialCharacter(password)) return false;
        if(!checkPasswordContinuousNumbers(password)) return false;
        if(!checkPasswordSameNumber(password)) return false;
        else return true;

        /*if(password == null){                                           //testPasswordNull
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
                if(pwArr[i]>='0' && pwArr[i]<='9'){
                    if(i<(pwArr.length-3) && pwArr[i]==pwArr[i+1] && pwArr[i]==pwArr[i+2] && pwArr[i]==pwArr[i+3]){     //testPasswordSameNumber
                        return false;
                    }
                    if(i<(pwArr.length-2) &&                                                                            //testPasswordContinuousNumbers
                            Character.getNumericValue(pwArr[i]) == Character.getNumericValue(pwArr[i+1])-1 &&
                            Character.getNumericValue(pwArr[i]) == Character.getNumericValue(pwArr[i+2])-2){
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
        }*/
    }

    public boolean checkPasswordNull(String password){                      //testPasswordNull
        if(password == null) return false;
        else return true;
    }
    public boolean checkPasswordLength(String password){                    //testPasswordLength
        if(password.length() < 8 || password.length() > 25) return false;
        else return true;
    }
    public boolean checkPasswordUpperLowerCase(String password){            //testPasswordUpperLowerCase
        if(password.equals(password.toLowerCase()) || password.equals(password.toUpperCase())) return false;
        else return true;
    }
    public boolean checkPasswordHasNumber(String password){                 //testPasswordHasNumber
        int letterCount = 0;
        char[] pwArr = password.toCharArray();
        for(char c : pwArr){
            if (Character.isDigit(c)) letterCount++;
        }
        if(letterCount == 0) return false;
        else return true;
    }
    public boolean checkPasswordSpecialCharacter(String password){          //testPasswordSpecialCharacter
        int specialCount = 0;
        char[] pwArr = password.toCharArray();
        for(int i=0; i<pwArr.length; i++){
            char c = pwArr[i];
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
        }
        if(specialCount == 0){
            return false;
        }
        else return true;
    }
    public boolean checkPasswordContinuousNumbers(String password){         //testPasswordContinuousNumbers
        char[] pwArr = password.toCharArray();
        for(int i=0; i<pwArr.length; i++) {
            if (pwArr[i] >= '0' && pwArr[i] <= '9') {
                if (i < (pwArr.length - 2) &&
                        Character.getNumericValue(pwArr[i]) == Character.getNumericValue(pwArr[i + 1]) - 1 &&
                        Character.getNumericValue(pwArr[i]) == Character.getNumericValue(pwArr[i + 2]) - 2) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkPasswordSameNumber(String password){            //testPasswordSameNumber
        char[] pwArr = password.toCharArray();
        for(int i=0; i<pwArr.length; i++){
            if(pwArr[i]>='0' && pwArr[i]<='9'){
                if(i<(pwArr.length-3) && pwArr[i]==pwArr[i+1] && pwArr[i]==pwArr[i+2] && pwArr[i]==pwArr[i+3]){
                    return false;
                }
            }
        }
        return true;
    }
}
