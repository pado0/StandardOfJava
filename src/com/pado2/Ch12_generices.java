package com.pado2;
/*
다양한 타입의 객체를 다루는 메서드나 컬랙션 클래스에
컴파일시 타입 체크를 해주는 기능.

장점) 타입 안정성 제공, 타입 체크와 형변환 생략 가능하여 코드 간결성 향상

static 멤버를 가질 수 없다.
T가 인스턴스변수로 간주되기 때문에.

지네릭 배열도 생성 불가하다.
new 연산자는 컴파일 시점에 T 타입이 무엇인지 정확히 알아야하는데, 배열로 선언시 알 수 없음.

와일드카드?
* */

public class Ch12_generices {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.setItem("box");
        System.out.println(box.getItem());
    }
}

class Box<T> {
    T item;

    void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}