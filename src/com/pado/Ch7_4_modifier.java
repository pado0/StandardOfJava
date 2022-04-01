package com.pado;

/*
 제어자 ! (접근 제어자 / 그외 )
 이기회에 확실하게 정리하고 넘어가자!

// 제어자
 1) static : 클래스 공통인 메서드 / 변수에 할당. 인스턴스와 관계 없이 같은 값을 갖는다. 인스턴스 멤버를 생성하지 않고 사용하고 싶을때 쓴다.
 2) final :  마지막의, 변경될 수 없는. 변수에 사용시 상수가 되며, 메소드에 사용시 오버라이딩 불가, 클래스에 사용시 상속 불가
 3) abstract : 미완성의. 메서드의 선언부만 작성하고 실제 수행 내용은 구현하지 않는 클래스에 적용. 미완성 설계도이므로 인스턴스를 생성할 수 없음. 추상클래스: 추상메서드를 포함한 클래스, 추상메서드: 구현부가 없는 메서드
    인스턴스를 생성하지 못하게 할때 일부러 붙일 수 있다.

// 접근제어자
1) private : 같은 클래스 내에서만 접근 가능
2) default: 같은 패키지 내에서만 접근 가능
3) protected: 패키지에 관계 없이 자손클래스에서 접근 가능 > 실습해보기.
4) public: 전체에서 접근 가능

// 제어자 조합
1. 메서드에 static과 abstract를 함께 사용 불가(static은 몸통이 있어야만 사용 가능)
2. 클래스에 abstact final 동시 사용 불가(abstract는 상속으로 구현해야하는데 final은 상속불가하여 모순)
3. abstract 메서드를 private로 선언할 수 없음(상속해야하는데 자손클래스에서 접근 불가)
*/

public class Ch7_4_modifier {
    public static void main(String[] args) {
        Card2 card2 = new Card2();
        System.out.println(card2.NUM);

        Card2 card21 = new Card2(123);
        System.out.println(card21.NUM);

        // card2.NUM = 123; // final이라 변경 불가

        // Singleton st = new Singleton(); 생성자가 private라서 접근 불가
        Singleton s = Singleton.getInstance();
        Singleton.getInstance();
    }

}

class Card2{
    final int NUM;

    Card2(int n){
        this.NUM = n; // final은 초기화해주어야 오류 안남
    }

    Card2(){
        this(100);
    }
}

// 제어자 실습
final class Singleton{
    private static Singleton s= new Singleton(); // static이므로 인스턴스에 관계없이 같은 값. 2차 생성시에 ()생성자가 호출되지 않는 이유.

    private Singleton(){
        System.out.println("private 생성자");
    }

    public static Singleton getInstance() { // getInstance 호출시 미리 인스턴스를 생성해놔야하므로 static으로 선언한다.
        if(s == null) s = new Singleton();
        System.out.println("static 대리 생성");
        return s;
    }
}