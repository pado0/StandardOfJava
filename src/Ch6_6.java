// 변수의 초기화
/*
* 1. 인스턴스 변수는 초기화하지 않아도 0으로 초기화됨
* 2. 멤버변수는 명시적 초기화 / 생성자 / 초기화 블록(쓰는거 한번도 못봤음)의 방식으로 초기화 가능
* */
public class Ch6_6 {
    public static void main(String[] args) {
        Document d1 = new Document();
        Document d2 = new Document("hyo문서");
        Document d3 = new Document();
        Document d4 = new Document();

    }
}

class Document{
    static int count = 0;
    String name;

    Document(){
        this("제목없음 " + ++count);
    }

    Document(String title){
        System.out.println(title + " 이 생성되었습니다.");
    }
}
