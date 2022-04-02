package com.pado;

// 인터페이스: 일종의 추상 클래스, 추상 클래스보다 추상화 정도가 높아 몸통을 갖춘 일반 메서드 or 멤버변수는 선언할 수 없음.
// 상수와 추상메서드만 멤버로 가질 수 있음 (public static final / public abstract, 단 이 제어자는 디폴트로 들어가므로 생략가능
// 다중 상속이 가능하다
// 인터페이스끼리의 상속도 가능하다

// 인터페이스에서도 다형성이 통한다. 타입으로 인터페이스를 선언 가능.
// 매개변수의 타입이 리턴타입이라는 것은, 인터페이스를 구현한 클래스를 매개변수로 제공한다는 것.
// 함수의 리턴타입이 인터페이스라는 것은, 메서드가 해당 인터페이스를 구현한 클래스의 인스턴스를 반환한다는 것.

// 인터페이스 장점 1. 개발시간 단축, 2. 표준화 가능 3. 서로 관계엾는 클래스(같은 조상클래스를 가지지 않은)들에 관계를 맺어줄 수 있다 4. 독립적 프로그래밍이 가능하다
// 그래서 인터페이스가 뭔데?
// 사용하는 쪽과 제공하는 쪽이 있다. 사용하는 client에서는 사용하려는 제공자의 메서드 선언부만 알면 된다.

// static 메서드도 인터페이스에 추가할 수 있게됨. 인스턴스와 관계 없는 메소드이기 때문.

// 인터페이스에 메소드가 추가되면 이를 구현한 다른 클래스들을 다 변경해야해서 난리다.
// 이때문에 디폴트 메서드를 사용한다. 다만 이름 충돌이 날 경우엔 구현체에서 디폴트 메소드를 오버라이딩.
public class Ch7_7_interface {
    public static void main(String[] args) {
        Paresable pareser = ParserManager.getParser("HTML");
        pareser.parse("asdfasd.html");
        pareser = ParserManager.getParser("XML");
        pareser.parse("asdfa.xml");
    }
}

// 인터페이스 전체 실습
class ParserManager{
    public static Paresable getParser(String type){
        if(type.equals("XML")) return new XMLParser();
        else return new HTMLParser();
    }
}
interface Paresable{
    void parse(String fileName);
}
class XMLParser implements Paresable{
    @Override
    public void parse(String fileName) {
        System.out.println(fileName +" xml 파싱중.");
    }
}

class HTMLParser implements Paresable{

    @Override
    public void parse(String fileName) {
        System.out.println(fileName+" html 파싱중");
    }
}

// 인터페이스 상속 실습
class Fighter extends Unit implements Fightable{

    @Override
    public void move(int x, int y) { // 여기서 public으로 구현한 이유? 오버라이딩시 조상메서드보다 넓은 범위여야 하므로. Fightable에서는 public abstact가 생략된 상태

    }

    @Override
    public void attack(Unit u) {

    }
}
class Unit {
    int x, y;
}
interface Fightable extends Movable, Attackable{ }
interface Movable{ void move(int x, int y);}
interface Attackable{ void attack(Unit u);}
