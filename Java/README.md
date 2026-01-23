- `BufferedReader`, `StrintTokenizer`를 활용한 입력 처리

```java
public class Main {

    public static void main(String[] args) throws IOException { // throws IOException 필수!!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열
        String str = br.readLine();

        // 정수
        int i = Integer.parseInt(br.readLine()); // Long.parseLong()도 있다!

        // 공백으로 구분된 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 공백이 아닌 구분자 처리
        st = new StrintTokenizer(br.readLine(), ",");

        // `br.close()`를 호출하지 않아도 정답 처리에 지장 없음!!! (PS 전용..)
    }
}
```

- `StringBuilder`를 활용한 출력 처리

```java
StringBuilder sb = new StringBuilder();

for (int i = 0; i < 3; i++) {
    sb.append(i).append('\n'); // append() 메서드를 여러번 체이닝할 수 있음
}

System.out.println(sb) // sb.toString() 메서드 호출은 생략 가능
```

- 자료구조별 구현체

```java
List<Integer> li = new ArrayList<>(); // 거의 항상 ArrayList가 LinkedList보다 빠르다

Queue<Integer> q = new ArrayDeque<>(); // LinkedList보다 ArrayDeque가 빠르다

Deque<Integer> dq = new ArrayDeque<>();

Deque<Integer> stk = new ArrayDeque<>(); // push(), pop(), peek()만 써서 스택처럼 활용할 수 있다

PriorityQueue<Integer> pq = new PriorityQueue<>();

Map<String, Integer> mp = new HashMap<>(); // 정렬이 필요할 경우 TreeMap 사용

Set<Integer> s = new HashSet<>(); // 정렬이 필요할 경우 TreeSet 사용
```

- 자료구조별 메서드 정리

```java
// 자료구조 공통
.size();
.isEmpty();

// 리스트 (List)
li.add(값);
li.add(인덱스, 값);
li.get(인덱스);
li.set(인덱스, 수정할 값);
li.remove(인덱스);
li.contains(값);

// 큐 (Queue)
q.add(값);
q.peek();
q.remove();

// 덱 (Deque)
dq.addFirst(값);
dq.addLast(값);
dq.peekFirst();
dq.peekLast();
dq.removeFirst();
dq.removeLast();

// 스택 (Deque로 만들어도 호출 가능)
stk.push(값);
stk.peek();
stk.pop();

// 우선순위 큐 (PriorityQueue)
pq.add(값);
pq.peek();
pq.remove();

// 맵 (Map)
mp.put(키, 값);
mp.get(키);
mp.getOrDefault(키, 기본값);
mp.containsKey(키);
mp.remove(키);
mp.keySet();
mp.values();
mp.entrySet();

// 셋 (Set)
s.add(값);
s.remove(값);
s.contains(값);

// `offer()`, `poll()`도 좋지만 빠른 디버깅을 위해 예외를 터트리는 메서드 사용 (PS)
```
