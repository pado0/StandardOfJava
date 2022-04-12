package com.pado2;

/*
컬렉션?
데이커 군을 저장하는 클래스들을 표준화한 걸계

종류
1) List : 순서가 있는 데이터 집합. 중복을 혀용.
- vector는 기존 컬랙션 호환을 위해 남겨둔 것으로 사용하지 말자. ArrayList를 사용해라..!

2) set : 순서가 없는 데이터 집합. 중복 미허용.
3) map : 키, 벨류 쌍으로 이루어진 데이터 집합. 순서는 없으며 키는 중복 미허용, 값은 중복 허용
*/

import java.util.*;

public class Ch11_1_collection_framework {
    public static void main(String[] args) {
        // ArrayList
        ArrayList<Integer> list1 = new ArrayList<>(0); // 크기가 10인 어레이리스트
        list1.add(1); // 박싱 제거해도 똑같음
        list1.add(2);
        list1.add(4);
        list1.add(3);
        list1.add(5);
        
        ArrayList<Integer> list2 = new ArrayList<Integer>(list1.subList(1, 4));
        for (Object o : list2) {
            System.out.println("o2 = " + o);
        }

        // list1이 list2를 포함하는지
        System.out.println(list1.containsAll(list2));

        // 정렬
        //Collections.sort(list1); // 이런식으로 해야하나...
        //Collections.sort(list2);

        // 자바 8부터 정렬
        list1.sort(Comparator.naturalOrder());
        for (Object o : list1) {
            System.out.println("o1 = " + o);
        }

        // 내림차순
        list1.sort(Comparator.reverseOrder());
        for (Object o : list1) {
            System.out.println("o1 = " + o);
        }
        
        // c++ 벡터처럼 생성 후 add 할 순 없나?
        // 크기선언 안해줘도 되는데 왜 자꾸 하라는겨
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(2);
        list3.add(2);
        list3.add(2);
        for (Integer integer : list3) {
            System.out.println("integer = " + integer);
        }
        
        // 스택, 큐 기본
        Stack st = new Stack();
        Queue q = new LinkedList();
        
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st.peek());
        System.out.println(st.pop());


        q.offer(2);
        q.offer(5);
        q.offer(1);
        System.out.println(q.peek());
        System.out.println(q.poll());
        
        // 우선순위 큐, 우선순위가 가장 높은것 부터 꺼낸다
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.offer(1);
        priorityQueue.offer(4);
        priorityQueue.offer(5);
        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue);
            priorityQueue.poll();
        }

        //Iterator
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator it = list.iterator();

        while (it.hasNext()) {
            System.out.println("iter " + it.next());
        }

        // Iteratior map
        Map m = new HashMap();
        m.put("a", "a word");
        m.put("b", "b word");
        m.put("c", "c word");

        Iterator iterator2 = m.keySet().iterator();

        while (iterator2.hasNext()) {
            System.out.println(m.get(iterator2.next()));
        }

        //
        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(10);
        System.out.println(set);

    }
}
