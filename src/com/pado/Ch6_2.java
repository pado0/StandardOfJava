package com.pado;

class Tv{
    String color;
    boolean power;
    int channel;

    void power(){ power = !power; }
    void channelUp() { ++channel; }
    void channelDown(){--channel; }
}

class Ch6_ex6_1 {
    public static void main(String[] args) {
        // 객체 생성
        Tv t = new Tv(); // t: 객체의 참조변수. 객체의 주소를 저장한다. 인스턴스는 참조변수를 통해서만 다룰 수 있다.

        // 객체 참조변수 테스트용
        Tv t2 = new Tv();

        // 객체 배열
        Tv[] tvArr = new Tv[3];

        // 참조변수 최초 테스트
        t.power = true;
        t.channel = 7;

        t.channelDown();
        t.power();

        System.out.println(t.channel);
        System.out.println(t.power);

        // 참조변수 같게하여 텟트
        // t2도 t의 참조변수를 따르게 하면, 같은 인스턴스에 접근하게 되므로 조회시 값이 같아진다.
        t2 = t;
        t2.channel = 10;

        System.out.println(t2.channel);
        System.out.println(t.channel);

        // 객체 배열 테스트
        for(int i=0 ; i<tvArr.length ; i++) {
            tvArr[i] = new Tv();
            tvArr[i].channel = i+10;
            System.out.println(tvArr[i].channel);
        }
    }
}
