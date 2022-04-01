package com.pado;
// 다향성이란? 부모 클래스 참조변수로 자식 클래스 인스턴스를 참조할 수 있게 함.
// 한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있는 것.
// 자바에서 문제가 발생하는 경우는, 없는 걸 사용하려 할때 > 자식참조변수 TvCaption c = new TV부모참조변수가 안되는 이유.

// 형변환 (부모)->(자식)로 변환 :  생략불가, (자식)->(부모)로 변환 : 생략 가능
public class Ch7_5_polymorphism {
    public static void main(String[] args) {
        Car1 car;
        FighterCar fighterCar = new FighterCar();
        FighterCar fighterCar1;

        fighterCar.water();
        car = fighterCar; // 조상타입 -> 자손타입
        fighterCar1 = (FighterCar) car; // 자손 -> 조상타입
        fighterCar1.water();
    }
}

class Car1{
    String color;
    int door;

    void drive(){
        System.out.println("drive");
    }

    void stop(){
        System.out.println("stop");
    }
}

class FighterCar extends Car1{
    void water(){
        System.out.println("water");
    }
}
