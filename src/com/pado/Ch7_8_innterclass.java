package com.pado;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
내부클래스: 클래스 안에 클래스를 선언하는 것.
- 인스턴스 클래스 : 외부 클래스의 인스턴스 멤버처럼 다뤄진다.
- 스태틱 클래스 : 외부 클래스의 static 멤버처럼 다뤄짐.
- 지역 클래스 : 선언된 영역 내부에서만 사용 가능
- 익명클래스 : 클래스 선언과 객체 생성을 동시에 하는 이름 없는 클래스

익명클래스 : 내부 클래스 중 이름이 없는 클래스/ new 구현인터페이스 이름(){}  / new 조상클래스 이름(){} 형식으로 사용
객체의 선언과 생성을 동시에 해서 단 한번만 사용된다. 별도 참조변수에 선언하지 않음.
-> 조상클래스나 인터페이스로 클래스 명을 대신해줌. 부모 인터페이스나 클래스의 구현체와 유사하므로 오버라이드 해준다.
-> 익명클래스가 내부클래스인 이유는 클래스 안에서 클래스를 선언하는 것과 동일하기 때문.

static:
static 변수는 static 클래스 안에서만 선언할 수 있다.
스태틱 멤버는 인스턴스 멤버에 직접 접근할 수 없다.
인스턴스 멤버는 스태틱 멤버에 접근할 수 있다.
 */

public class Ch7_8_innterclass {
    public static void main(String[] args) {
        Button button = new Button();
        // button.addActionListener(new EventHandler()); // 이렇게 할 수도 있지만
        button.addActionListener(new ActionListener() { // EventHandler를 굳이 만들어 상속받지 않아도 익명클래스로 일회용 클래스 생성 가능
            // 옛날에는 일회용 클래스인걸 이해 못했는데, 지금 보니 클래스를 따로 안만들고 한 번 만 생성해줬네.
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}

class EventHandler implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("액션 리스너를 상속받은 이벤트 리스너");
    }
}