package com.pado;

public class Ch6_3 {

    public static void main(String[] args) {
        System.out.println(Card.height + " " + Card.width);

        Card c1 = new Card();
        c1.kind = "Heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "dia";
        c2.number = 10;

        System.out.println(c1.kind + " " + c1.number + " " + c1.width);
        System.out.println(c2.kind + " " + c2.number + " " + c2.width);

        c1.width = 110;

        // static이 붙은 변수는 클래스 변수로, 클래스가 메모리에 올라갈 때 생성되어 종료될 때 까지 유지된다.
        // !!! 객체를 생성하지 않고도 호출 가능하다
        // !!! 모든 인스턴스가 공통 값을 갖는다.
        // public static으로 선언하면 전역변수의 성격을 갖는다.
        System.out.println(c1.kind + " " + c1.number + " " + c1.width);
        System.out.println(c2.kind + " " + c2.number + " " + c2.width);

        // 메소드 테스트
        MyMath mm = new MyMath();
        long result = mm.add(1, 2);
        System.out.println(result);

        // 참조형 매개변수.
        Data d = new Data();
        d.x = 100;
        System.out.println(d.x);
        change(d); // 객체 참조변수를 넘겨야 인스턴스 내부 값에 접근에 값을 바꿀 수 있다.
        System.out.println(d.x);

        //매개변수가 배열이면 참조형 매개변수이다 (주소값을 넘기니까)
        int[] arr = new int[]{3, 2, 1, 6, 5, 4};
        printArr(arr);
        sortArr(arr);
        printArr(arr);

        //리턴값이 참조형 (객체주소를 반환)
        Data d2 = new Data();
        d2.x = 1111;
        Data d3 = copy(d2);
        System.out.println("d2: " + d2.x);
        System.out.println(d3.x);

        // 클래스 메서드와 인스턴스 매서트
        // 클래스 메서드 : 인스턴스를 생성하지 않고도 사용할 수 있는, 인스턴스와 관계 없는 메서드를 클래스 메서드라 한다
        // 모든 인스턴스에 공통인 메서드에서 사용한다
        // 클래스 메서드는 인스턴스 변수를 사용할 수 없다.(인스턴스 변수 없이 클래스 메서드를 사용할 수 있어서, 인스턴스가 없을 수 있는 오류 발생 방지)
        // 인스턴스 변수 값 초기화 안했는데 ,,?
        System.out.println(MyMath2.sAdd(1,2));
        MyMath2 mm2 = new MyMath2();
        mm2.a = 200;
        mm2.b = 300;
        System.out.println(mm2.add());

    }

    // 배열을 파라미터로 하는 함수, 참조변수처럼 내부 값 변경 가능
   static void sortArr(int[] arr){
        for(int i=0 ; i <arr.length-1 ; i++){
            for(int j=0 ; j<arr.length-1 ; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    // 어레이를 파라미터로 하는 함수
    static void printArr(int[] arr){
        for(int i=0 ; i < arr.length ; i++){
            System.out.println(arr[i]);
        }
    }

    // 참조변수를 파라미터로 하는 함수
    static void change(Data d){
        d.x = 10;

    }

    // 참조변수를 리턴하는 함수
    static Data copy(Data d){
        Data tmp = new Data();
        tmp.x = d.x;
        return tmp;
    }


}

// 인스턴스변수 기초
class Card{
    String kind;
    int number;
    static int width = 100;
    static int height = 250;
}

// 함수 기초
class MyMath{
    long add(long a, long b){
        long result =  a + b;
        return result;
    }

}

class Data{ int x;}

// 인스턴스 함수 기초
class MyMath2{
    int a, b;

    int add(){return a+b;}
    // static int sAdd(){return a+b;} // 이렇게 인스턴스 변수를 받아서는 사용할 수없다. 인스턴스 변수가 없을수도 있기 떄문
    static int sAdd(int a, int b){return a+b;}

}