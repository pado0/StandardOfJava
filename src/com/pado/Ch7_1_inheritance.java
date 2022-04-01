package com.pado;/*
* 상속
* 이유 : 기존 클래스를 재사용하여 새로운 코드를 작성한다. 코드의 추가 및 변경이 용이하다. 재사용/ 중복제거 효과가 있다.
* 규칙 : 자식 클래스는 부모 클래스의 모든 멤버(변수/함수)를 상속받을 수 있다.
* 벤다이어그램으로 생각하면 편하다! 부모 <포함 < 자식 (부모의 모든 멤서를 자식이 갖고있음), 자식에만 추가된 멤버는 부모가 쓸 수 없음
* GrandChild가 있다면, 부모와 자식의 멤버를 다 상속받는다.
* */

// 클래스 포함관계
/*
1. "x는 y를 가지고있다" 가 성립하면 포함관계 (클라스 안에서 다른 클래스를 선언)
2. "x는 y이다"가 성립하면 상속관계

ex. 원은 점이다 vs 원은 점을 가지고있다 > 후자가 더 자연스러우므로 원 클래스에 점 플래스를 선언한다
ex. 쉐보레차는 차이다 vs 쉐보레는 차를 가지고있다 > 전자가 더 자연스로우므로 쉐보레차가 차를 상속받는다.
 */

// 단일상속: 자바는 단일 상속만 허용한다. 여러 클래스를 상속받을 수 없다.

//조상클래스 Object
/*
아무것도 상속받지 않은 함수도 Object 클래스를 자동으로 상속받게된다.. 최상위 조상은 Object 클래스이다.
toString, equals()등이 Object 클래스에 정의된 메소드이다
 */

// 상속 테스트
class CaptionTv extends Tv{
    boolean caption;

    void displayCaption(String text) {
        if (caption) {
            System.out.println(text);
        }
    }

}

// 클래스 간 관계 (상속 / 포함) + !! 오버라이딩
class Shape{
    String color = "black";

    // 부모 draw
    void draw(){
        System.out.println(color);
    }
}

class Point{
    int x,y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    Point(){
        this(0, 0); // com.pado.Point(int x, int y) 가 호출됨
    }

    String getXY(){
        return "(" + x + " , " + y + ")";
    }
}

class Circle extends Shape{  // 상속관계
    Point center; // 포함관계
    int r;

    Circle(){
        this(new Point(0, 0), 100); // 아래 선언한 com.pado.Circle(com.pado.Point center, int r) 를 호출하여 성립되는것임
    }

    Circle(Point center, int r) {
        this.center = center;
        this.r = r;
    }

    // 상속받은 클래스가 부모클래스의 함수를 재구현하는것! "오버라이딩!"
    @Override
    void draw() {
        System.out.println("원의 정보 출력 : " +center.x + " " + center.y);
    }
}
public class Ch7_1_inheritance {
    public static void main(String[] args) {

        // 상속 기본
        CaptionTv ct = new CaptionTv();

        ct.channel = 50;
        ct.power = true;
        System.out.println(ct.channel);
        System.out.println(ct.power);

        ct.power();
        ct.channelUp();
        ct.caption = true;
        System.out.println(ct.channel);
        System.out.println(ct.power);

        // 클래스간 관계
       Point[] p = {new Point(100, 200),
                    new Point(200, 300),
                    new Point(300, 400)};

        Circle c = new Circle(p[0], 5);
        c.draw(); // 부모와 자식에 동일한 함수가 서언되어있다면, 자식 함수가 호출된다.

    }
}
