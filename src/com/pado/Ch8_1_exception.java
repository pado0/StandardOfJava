package com.pado;

/**
 > 프로그램 실행중 발생하는 오류의 종류
 1. 컴파일 에러: 컴파일 할때 발생
 2. 런타임 에러: 프로그램 실행도중 발생
    - error: 메모리부족, 스택오버플로우 등 발생하면 코드에 의해 수습될 수 없는 심각한 오류. 종료를 막을 길이 없음
    - exception: 코드로 수습할 수 있는 비교적 덜 심각한 오류. 비정상 종료를 막을 수 있음
 3. 논리적 에러: 실행은 되지만 의도와 다르게 동작

 > 예외 클래스 계층구조 > 이미지 참고 (415p)
 - 런타임 exception 클래스는 프로그래머의 실수에 의해 발생될 수 있는 예외들이다
 - 배열의 범위를 벗어남 / Null pointer, null을 참조변수로 입력 / classnotfound 클래스의 이름을 잘못 입력 / 데이터형식이 잘못된 Dataformat

 > 예외처리를 해주어야 한다
 - 정의: 프로그램 실행시 발생할 수 있는 예외에 대비한 코드 작성
 - 목적: 프로그램 비정상종료를 막고 정상적 실행상태를 유지하는 것
 - 방법: try-catch문 작성. 예외 종류와 일치하는 catch문만 수행된다.
    try{예외가 발생할 가능성이 있는 문장}
    catch(Exception1 e1){exception1이 발생했을 경우, 이를 처리하기 위한 문장. 예외와 같은 타입의 참조변수를 선언해야한다.}

 > 문장 흐름
 - try 내에서 예외 발생한 경우
 - 일치하는 catch를 찾다가, 찾으면 캐치 문장 수행하고 전체 트라이 캐치르 ㄹ빠져나간다

 - 트라이 예외 발생하지 않은 경우 캐치를 거치지 않는다.

 - 예외 발생한 경우, 발생한 예외와 선언된 예외 참조변수의 종류를 instanceof로 비교하며 검사.
 - Exception 클래스는 모든 오류의 조상이므로, 모든 종류의 예외처리를 처리할 수 있다 (instance of로 비교하마ㅡ로!)

 > throw를 통해 고의로 예외를 발생시키기

 > 메서드에 예외선언하기, throws 키워드 사용
 - void method() throws Exception1, Exception2{//메서드 내용}
 - 메서드에 선언한 예외는 상속되므로, 자손에서도 처리해야한다.
 - throws는 예외 처리가 아닌, 호출한 메서드에게 예외를 전달하여 예외처리를 떠맡기는 것이다.

 > finally
 - 예외 발생여부에 관계 없이 마지막에 꼭 실행하는 동작

 > 예외 던지기
 - 예외 발생시 처리하고, 처리부에서 다시 예외를 발생시켜 호출된 쪽으로 넘길 수도 있다.

 > 연결된 예외
 - initCause()를 사용하여 지정한 예외를 원인 예외로 등록할 수 있다.
 - A예외가 발생시 catch부에서 B예외를 원인으로 등록하고, B예외를 고의로 발생시킨다.
 */


public class Ch8_1_exception {
    public static void main(String[] args) {
        int number = 100;
        int result = 0;
        int random = 0;
        for(int i=0  ; i<10 ; i++){
            try {
                result = number;
                random = (int)(Math.random() * 10);
                System.out.println("rd: " + random);
                System.out.println(result/0);
            } catch (Exception e) {
                System.out.println(0);
                e.printStackTrace(); //예외 발생당시 호출스택에 있던 메소드 정보와 예외 메세지 출력
                System.out.println("getMessate"+ e.getMessage()); // 발생한 예외 클래스의 인스턴스에 저장된 메세지
            }
            /*catch (ArithmeticException e){
                System.out.println("am");
            }*/ // 상위 클래스인 Exception으로 먼저 처리해주었을 경우 하위 익셉션으로 예외처리 해줄 필요 없어 오류
            finally {
                System.out.println("finally"); //예외가 터져도 실행됨.
            }
        }

        // 고의로 예외 발생시키기
        try{
            Exception e1 = new Exception("고의 2발생");
            throw new MyException("사용자정의 오류 발생");
            //throw e1; // throw는 예외를 발생시키는 것, throws는 메소드에 선언해서 예외를 넘기는 것.
        }catch (Exception e){
            System.out.println("에러메세지 " + e.getMessage()); // 고의로 발생시킨 에러메세지를 받아온다.
            e.printStackTrace();
        }
        System.out.println("비정상종료");
    }
}

class MyException extends Exception{
    public MyException(String message) {
        super(message);
    }
}