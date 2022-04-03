package com.pado;

// 예외가 발생한 메서드에서 예외를 처리하지 않고 호출한 메서드로 예외처리를 넘기는 throw 예제

public class Ch8_1_exception_throw {
    public static void main(String[] args) throws Exception{
        method1(); // method1에서 오류 바음
    }

    static void method1() throws Exception{
        try{method2();} // method1에서 method2로부터 발생한 에러를 받음, 이를 다시 main으로 thow. 여기서 처리해주면 Main은 오류 난 사실도 모르게된다.
        catch (Exception e){
            System.out.println("method2 호출시 예외 발생");
        }
    }

    static void method2() throws Exception{
        throw new Exception(); //여기서 예외 발생, 호출한 곳으로 throw
    }
}
