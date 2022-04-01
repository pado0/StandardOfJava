package com.pado;// 상속받은 클래스가 부모클래스의 멤버 함수를 재구현하는것! "오버라이딩!"

// 오버라이딩의 조건
/*
1. 함수명이 같아야한다
2. 매개변수 / 반환타입이 같아야한다.
3. 접근제어자는 조상클래스의 멤버메서드에 정의된 것 보다 넓은 범위로만 정의할 수 있다. (public > protected > default > private)
   ex. 조상이 Protected라면 자식은 public or protected
   왜?
4. 조상클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.
5. 인스턴스메서드를 static으로, 스태틱을 인스턴스 메서드로 바꿀 수 없다.
   스태틱은 스태틱으로 가능하나, 이건 오버라이딩은 아니고 그냥 각자의 클래스에 스태틱 메서드를 선언한 것. 독립적. 연관관계 없음.
 */

//!!! super :  자손 클래스에서 조상 클래스로부터 상속받은 멤버를 참조할때 사용되는 참조변수
// 조상클래스로부터 상속받은 멤버도 자신의 멤버이므로 this 가능해서
// 조상과 자손의 멤버가 중복되어 서로 구분해야할 때만 super 쓰는게 좋다.
// 조상클래스 메소드를 오버라이딩했는데 조상꺼 그대로 쓰고싶을 때 사용

// 조상클래스의 생성자
/*
자손클래스 인스턴스를 만들면 조상클래스 멤버가 다 합쳐진 인스턴스가 만들어짐.
 이떄 조상클래스의 생성자 초기화 작업이 들어가야해서, 자손클래스는 조상클래스의 생성자를 호출해야한다!!!!! > 이부분을 기억하자
 조상들이 먼저 초기화 되어있어야 자식꺼 사용할 수 있음.
 개발자가 추가하지 않으면 조상 생성자 super();는 자동 호출됨
 */

public class Ch7_2_overriding {
    public static void main(String[] args) {
        // super 연습 1
        Child child = new Child();
        child.method();

        // super 연습 2
        point3D point3D = new point3D();
        System.out.println(point3D.x + " " + point3D.y +  " " + point3D.z);
        point3D point3D1 = new point3D(4, 2, 1);
        System.out.println(point3D1.x + " " + point3D1.y +  " " + point3D1.z);
    }
}

// super 연습1
class Parent{
    int x = 10;
    void pr(){
        System.out.println("조상꺼");
    }
}

class Child extends Parent{
    int x = 20;

    Child(){
        super(); // 조상 클래스의 기본 생성자가 디폴트로 호출됨!!!!. 부모에서 생성자를 만들어 디폴트생성자가 없다면, 만들어주던가 super(파라미터)로 만들어진 생성자를 호출하자.
    }

    @Override
    void pr() {
        //super.pr();
        System.out.println("자식꺼");
    }

    void method(){
        System.out.println(x);
        System.out.println(this.x);
        System.out.println(super.x); // 부모를 가리키므로 10이 출력됨
        this.pr(); // 내꺼
        super.pr(); // 조상꺼
    }
}

//super 연습 2
class Point2{
    int x=10;
    int y = 20;

    Point2(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class point3D extends Point{
    int z = 30;
    point3D(){
        this(100, 200, 300);
    }
    point3D(int x, int y, int z){
        super(x, y);
        this.z = z;
    }
}