package com.pado;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
내부클래스: 클래스 안에 클래스를 선언하는 것.
익명클래스 : 내부 클래스 중 이름이 없는 클래스/ new 구현인터페이스 이름(){}  / new 조상클래스 이름(){} 형식으로 사용
객체의 선언과 생성을 동시에 해서 단 한번만 사용된다. 별도 참조변수에 선언하지 않음.
-> 조상클래스나 인터페이스로 클래스 명을 대신해줌. 부모 인터페이스나 클래스의 구현체와 유사하므로 오버라이드 해준다.
-> 익명클래스가 내부클래스인 이유는 클래스 안에서 클래스를 선언하는 것과 동일하기 때문.
 */

public class Ch7_8_innterclass {
    public static void main(String[] args) {
        Button button = new Button("start");
        /*button.addActionListener(new EventHandler(){ // 그냥 클래스 선언

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("그냥클래스테스트");
            }
        });*/

        // 익명클래스에서 함수를 오버라이드 하는 이유가 뭘까?
        button.addActionListener(new ActionListener() { //구현 인터페이스 이름으로 호출하는 익명클래스
           @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("잉명클래스 테스트");
            }
        });
    }

}

class EventHandler implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("action event!");
    }
}
