package com.pado;

import static java.lang.Math.*;

public class Ch9_1_java_lang_package_2 {
    public static void main(String[] args) {

        // Math
        // 올림, 내림 , 반올림
        double val = 90.552;
        System.out.println(round(val)); // 반올림, long으로 리턴
        System.out.println(rint(val)); // 반올림이지만, double로 리턴
        System.out.println(ceil(val)); // 올림
        System.out.println(floor(val)); // 내림

        // 예외를 발생시키는 메서드 Exact : 정수형간 연산에서 발생할 수 있는 오버플로우 감지 후 ArithmeticException 발생
        // 삼각함수, 지수, 로그 sin(), cos(), sqrt(), pow(),

        // wrapper 클래스
        // 8개의 기본형 변수를 객체로 다루기 위한 클래스 ex.Integer 클래스

        // Number 클래스 (short, integer, long, double...)
        // BigDecimal : Long으로도 다룰 수 없는 큰 범위의 정수, 부동 소수점수를 처리하기 위함.

        // 문자열, 숫자 변환 Integer i = Integer.valueOf("100") // wrapper 클래스로밖에 선언할 수 없음.
        // jdk 1.5부터 오토박싱 기능이 생겨 primitive 와 wrapper 클래스일때의 차이가 없어짐.

        // 오토박싱, 언박싱
        // 기본형과 참조형 변수 간 연산이 가능해짐.
        // 기본형 값을 래퍼 클래스의 객체로 자동 변환해주는걸 오토박싱, 반대로 변환하는걸 언박싱이라 한다.

    }
}
