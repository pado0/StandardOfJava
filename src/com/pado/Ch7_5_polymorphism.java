package com.pado;
// 다향성이란? 부모 클래스 참조변수로 자식 클래스 인스턴스를 참조할 수 있게 함.
// 한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있는 것.
// 자바에서 문제가 발생하는 경우는, 없는 걸 사용하려 할때 > 자식참조변수 TvCaption c = new TV부모참조변수가 안되는 이유.

// 형변환 (부모)->(자식)로 변환 :  생략불가, (자식)->(부모)로 변환 : 생략 가능
//insteadOf 연산자

// 잠소변수 insteadof 피연산자 의 타입, bool을 반환한다.
// 아 그냥 검사하고자 하는 참조변수가 클래스로 형변환 될 수 있는지를 bool로 리턴한다

/// 부모의 자식의 멤버변수가 같은 이름으로 정의된 경우
//멤버함수는 상관없지만, 멤버 변수는 참조변수의 타입에 따라 반환값이 달라진다.
// 부모 타입의 참조변수 일 땐 부모의 멤버변수가, 자식타입의 참조변수일땐 자식의 참조변수가 사용된다.

// 매개변수의 다형성
// 매개변수도 부모객체로 정의하고, 자식 객체를 받게 하면 다향성을 잘 활용하는 코드가 된다.

import java.util.Vector;

public class Ch7_5_polymorphism {
    public static void main(String[] args) {
        Car1 car;
        FighterCar fighterCar = new FighterCar();
        FighterCar fighterCar1;

        fighterCar.water();
        car = fighterCar; // 조상타입 -> 자손타입
        fighterCar1 = (FighterCar) car; // 자손 -> 조상타입
        fighterCar1.water();

        //instanceof 실습
        FighterCar fighterCar2 = new FighterCar();

        if (fighterCar2 instanceof Car1) {
            System.out.println("fighterCar 2는 Car1 객체로 형변환될 수 있다.");
        }

        // 참조변수 타입에 따른 멤버변수 반환값 확인
        Parent1 c = new Child1();
        System.out.println(c.x); // 부모꺼 호출

        Child1 c1 = new Child1();
        System.out.println(c1.x); // 자식꺼 호출

        c1.superthis();

        // 매개변수의 다형성 실습
        Buyer buyer = new Buyer();
        buyer.buyingProduct(new Computer(100,200,"컴퓨터"));
        buyer.buyingProduct(new Audio(399,12,"오디오"));
        buyer.buyingProduct(new Computer(100,200,"컴퓨터"));
        buyer.buyingProduct(new Audio(399,12,"오디오"));
        buyer.buyingProduct(new Computer(100,200,"컴퓨터"));
        buyer.buyingProduct(new Audio(399,12,"오디오"));

        buyer.productList();

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

class Parent1{
    int x = 100;
}

class Child1 extends Parent1{
    int x = 200;
    void superthis(){
        System.out.println("super" + super.x);
        System.out.println("this" + this.x);
    }
}

class Product{
    int price ;
    int point ;
    String name;

    Product(int price, int point, String name) {
        this.price = price;
        this.point = point;
        this.name = name;
    }
}
class Audio extends Product{
    Audio(int price, int point, String name) {
        super(price, point, name);
    }
}

class Computer extends Product{
    Computer(int price, int point, String name) {
        super(price, point, name);
    }
}

class Buyer{
    //Product[] products = new Product[10];
    Vector products = new Vector();
    void buyingProduct(Product product){

        // 벡터로 리펙토링
        products.add(product);
        System.out.println(products.size()+"번째 사려는 물건이 무엇인지" + product.name);
    }

    void productList(){
        for(int i=0 ; i <products.size() ; i++){
            Product p = (Product)products.get(i);
            System.out.println("벡터에 저장된것들을 가져오기: "+p.name);
        }
    }
}