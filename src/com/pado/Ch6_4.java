package com.pado;

public class Ch6_4 {
    public static void main(String[] args) {
        // 오버로딩: 같은 이름을 갖는 메서드, 매개변수 개수나 타입이 다름.
        // ex. System.out.println() > char, int 등등이 다 올 수 있다.
        MyMath3 mm3 = new MyMath3();
        System.out.println(mm3.add(10, 20));
        System.out.println(mm3.add(29, 0.5));

        int[] arr = {10, 23, 12, 3, 2};
        System.out.println(mm3.add(arr));

        // 가변인자를 가진 함수 호출
        System.out.println(concatenate(" ", "100", "200"));
        System.out.println(concatenate("!", new String[] {"asdf", "Asdf" ,"asdf"}));
    }
    // 가변인자
    //{타입}... {변수명} // ex int...a 형태로 사용
    static String concatenate(String delim, String... args){
        String result = "";
        for(String str : args){
            result +=str + delim; // 구분자를 중간에 끼워 출력
        }
        return result;
    }

}


// 오버로딩 기초
class MyMath3{
    int add(int a, int b){
        System.out.println("int: ");
        return a+b;
    }

    double add(int a, double b) {
        System.out.println("double: ");
        return a+ b;
    }

    int add (int[] arr){
        int sum =0 ;
        for(int i=0;i<arr.length ; i++){
            sum += arr[i];
        }
        return sum;
    }
}