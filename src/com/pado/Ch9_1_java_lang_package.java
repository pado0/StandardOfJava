package com.pado;

import java.util.Date;

/**
 java.lang 패키지
 - 자바 프로그래밍에 기본이 되는 클래스라, Import 없이도 사용 가능
 */
public class Ch9_1_java_lang_package {
    public static void main(String[] args) throws CloneNotSupportedException {

        // equals(Object obj) : 참조변수에 저장된 주소값이 같은지 판단. 값을 비교하고싶으면 오버라이딩 필요
        System.out.println("==equals==");
        Value v1 = new Value(1);
        Value v2 = new Value(2);
        System.out.println(v1.equals(v2)); // false, 값 같아도 같은 참조변수 주소값을 가져야 true. 지금은 오버라이딩 되어있어 값을 비교하게 됨.

        v1 = v2;
        System.out.println(v1.equals(v2)); //true


        // hashCode() : 해시함수를 구현함. 찾고자 하는 값을 입력하면 저장된 위치를 알려주는 해시코드를 반환
        System.out.println("==hashcode==");
        String str1 = new String("ABC"); //이거랑
        String str2 = "ABC"; // 이게 뭐가 다른지 이따가 확인

        System.out.println(str1.equals(str2));
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode()); //str1과 같은 값을 반환하도록 오버라이딩 되어있다. 값이 같으므로.
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2)); // 객체의 주소값으로 해싱하기 때문에 서로 다른 값, 다른 객체임을 알 수 있다.

        // toString() : 인스턴스 정보를 문자열로 반환. 오버라이딩 안하면 클래스 이름 + 16진수 해시코드가 반환됨.
        System.out.println("==toString==");
        Value v3 = new Value(10);
        System.out.println(v3.toString());

        Date today = new Date();
        System.out.println(today.toString()); // Date같은 객체는 날짜를 스트링으로 변환해내도록 미리 오버라이딩 되어있음
        System.out.println(today); // toString() 생략가능

        // clone() : 자기 자신을 복제하여 새로운 인스턴스 생성. 임시로 저장해놨다가 원래대로 값을 돌리는데에 사용됨
        // Cloneable interface를 구현 해야만 호출할 수 있음. 인스턴스 변수 값만을 복제해서, 변수에 참조 인스턴스 변수가 있다면 완벽 복제가 안되고 원래 값에 영향을 끼침을 주의.
        System.out.println("==clone==");
        Value v4 = new Value(20);
        Value v5 = (Value) v4.clone();
        System.out.println(v4); // 오버라이딩 되어있어 toString() 생략가능
        System.out.println(v5);
        System.out.println(v4.equals(v5)); // 주소값 비교하면 false

        // getClass() : 자신이 속한 클래스의 Class 객체를 반환. Class 객체는 클래스의 모든 정보를 담고있고, 클래스로더에 의해 메모리에 올라갈때 자동으로 생성됨.
        // 클래스 파일을 읽어 사용하기 편한 형태로 저장해놓은 것.
        System.out.println("==getClass==");
        Class obj = new Value(6).getClass();
        System.out.println(obj.getName());
        System.out.println(obj.toGenericString());

        // String 클래스
        // char[]을 인스턴스 변수로 갖고 사용하는 것임
        // String a= "abc"; vs String a = new String("abc") // 전자는 값이 같으면 같은 주소값을, 후자는 값이 같아도 다른 주소값을 갖는다.
        System.out.println("==String Class==");
        String a = "a";
        System.out.println(a);

        //리터럴로 저장하는 방식. 값이 같으면 모든 참조변수가 같은 메모리 리터럴을 참조하게 된다. 어차피 값 바꿀 수없으니..!
        a="asdf"; // 인스턴스가 갖고있는 문자열은 변경할 수 없다. 이 경우는 다른 주소값으로 값이 재생성되어는 것이다.
        System.out.println(a);

        String str3 = new String("abc");
        String str4 = new String("abc");
        System.out.println(str3.equals(str4)); // 저장된 값 자체는 같으므로 true
        System.out.println(str3 == str4); // 참조변수는 다르므로 false

        // string 형변환
        int i = 100;
        String str5 = i + "";// 100이 "100"으로 변환
        String str6 = String.valueOf(i); // 100이 "100"으로 변환
        System.out.println(str5);

        int i1 = Integer.valueOf(str5);// "100"이 100으로 변환
        System.out.println(i1);

        // string Buffer : 버퍼를 정해놔서, + 연산해도 새 메모리를 참조하지 않는다.
        // string builder : 스트링 버퍼가 멀티스레드 동기화시 성능이 저하되어, 스레드 동기화만 뺸 것이다.

    }
}

class Value implements Cloneable{
    int value;

    public Value(int value) {
        this.value = value;
    }

    public boolean equals(Object obj){
        if(obj !=null && obj instanceof Value) return this.value == ((Value) obj).value;
        else return false;
    }

    @Override
    public String toString() {
        return "Value{" +
                "value=" + value +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}