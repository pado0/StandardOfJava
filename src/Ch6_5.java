// 생성자
public class Ch6_5 {
    public static void main(String[] args) {
        //기본 생성자 테스트
        Data1 d1 = new Data1();
        // Data2 d2 = new Data2(); // 오류, 디폴트 생성자가 없어졌기 때문
        Data2 d2 = new Data2(3);
        System.out.println(d2.value);


        // 매개변수가 있는 생성자
        Car c1 = new Car("red", "auto", 123);
        System.out.println(c1.color + " " + c1.gearType + " " + c1.door);
    }
}

// 기본생성자 (디폴트 생성자): 매개변수도 없고, 아무런 내용도 없음. 단, 클래스 내에 생성자가 하나도 없을때만 정의됨
class Data1{
    int value;
}

class Data2{
    int value;

    Data2(int x){
        value = x;
    }
}

// 매개변수가 있는 생성자, 속성을 필수로 지정하게 함

class Car{
    String color;
    String gearType;
    int door;

    Car(){
        // 생성자를 생성자가 call 가능 by using this
        this("white","auto",4);
    }

    Car(String c, String g, int door){
        color  = c;
        gearType = g;
        this.door = door; // 매개변수 명과 인스턴스 변수 명이 같을때, this로 구분.
        //!!!! this는 자기 자신을 가리키는 참조변수!!! this(): 자기자신의 생성자, this:자기자신을 가리키는 참조변수.
    }
}


