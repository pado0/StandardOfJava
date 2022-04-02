package com.pado;

//public abstract가 아닌 그냥 static 함수 테스트
// default함수 테스트: default 메소드는 조상클래스에서 메소드 구현해준것과 같은 효과이므로, 자식에서 구현 안해도됨.

public class Ch7_7_defaultMethod {
    public static void main(String[] args) {
        Child4 child4 = new Child4();
        child4.method1();
        child4.method2(); // parent3 상속을 삭제하면 디폴트메소드가 호출됨. 구현하지 않아도 부모클래스처럼 상속되는 것.

        MyInterface.staticMethod();
        Myinterface2.staticMethod();
    }
}

class Child4 implements MyInterface, Myinterface2{
    @Override
    public void method1() {
        System.out.println("method 1 in child4");
    }
}

class Parent3{
    public void method2(){
        System.out.println("method2 in parent3");
    }
}

interface MyInterface{
    default void method1(){
        System.out.println("method1 in myinterface");
    }
    default void method2(){
        System.out.println("method2 in myinterface");
    }

    static void staticMethod(){
        System.out.println("static method in myinterface");
    }
}

interface Myinterface2{
    default void method1(){
        System.out.println("method1 in Myinterfece2");
    }

    static void staticMethod(){
        System.out.println("static method in myinterfece2");
    }
}
