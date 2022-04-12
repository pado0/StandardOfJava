package com.pado;

import java.io.Console;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ch9_2_useful_class {


    public static void main(String[] args) {
        // Objects 클래스
        // isNull(), nonNull(), compare() 대소비교

        // Random 클래스
        // Math.random() , 곱하기로 범위를 지정해줌

        // 정규식 regex
        // 텍스트 데이터 중 원하는 조건, 패턴과 일치하는 문자열을 찾아내기 위해 사용

        // Scanner 클래스
        Console console = System.console();
        //String input = console.readLine();

        BD.printBD();

        BigDecimal bd1 = new BigDecimal("123.456");
        BigDecimal bd2 = new BigDecimal("1.0");

        System.out.println(bd1.divide(bd2, 2, RoundingMode.HALF_UP));
    }
}

class BD{
    private static final BigDecimal bigDecimal=  new BigDecimal("12345.6789101112");

    public static void printBD() {
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.unscaledValue());
        System.out.println(bigDecimal.scale());
        System.out.println(bigDecimal.precision());
    }

}