package com.study.mb.utilities;

public class Converter {
    private Converter(){}
    public  static int StringToInt(String value, int fallback){
        try{
            return Integer.parseInt(value);
        }catch (Exception ignored){
            return fallback;
        }
    }
}
