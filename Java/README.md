- `BufferedReader`, `StringTokenizer`를 활용한 입력 처리

  ```java
  public class Main {

      public static void main(String[] args) throws IOException { // throws IOException 필수!!
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

          // 문자열
          String str = br.readLine();

          // 정수
          int i = Integer.parseInt(br.readLine()); // Long.parseLong()도 있다!

          // 공백으로 구분된 입력
          // StringTokenizer st = new StringTokenizer(br.readLine());
          var st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());

          // 공백이 아닌 구분자 처리
          st = new StringTokenizer(br.readLine(), ",");

          // `br.close()`를 호출하지 않아도 정답 처리에 지장 없음!!! (PS 전용..)
      }
  }
  ```

- `StringBuilder`를 활용한 출력 처리

  ```java
  // StringBuilder sb = new StringBuilder();
  var sb = new StringBuilder();

  for (int i = 0; i < 3; i++) {
      sb.append(i).append('\n'); // append() 메서드를 여러번 체이닝할 수 있음
  }

  // 마지막에 추가되는 공백이나 개행문자 제거가 필요할 경우:
  sb.deleteCharAt(sb.length()-1);

  char[] arr = new char[]{'g', 'n', 'i', 'r', 't', 's'}; // string 역순

  var reversed = new StringBuilder();
  for (char c : arr) reversed.append(c);
  reversed.reverse(); // reverse() 메서드를 활용해 들어온 순서를 뒤집어줄 수 있음

  // append() 메서드에 `다른 StringBuilder 객체`도 넘겨줄 수 있다
  // 이거 진짜 중요!!!!!
  sb.append('\n').append(reversed);

  System.out.println(sb); // sout으로 출력할 때는 sb.toString() 메서드 호출 생략 가능
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
  li.get(인덱스);
  li.add(값);
  li.add(인덱스, 값);
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
  mp.getOrDefault(키, 기본값);
  mp.entrySet();
  mp.keySet();
  mp.values();
  mp.containsKey(키);
  mp.remove(키);
  mp.get(키);

  // 셋 (Set)
  s.add(값);
  s.contains(값);
  s.remove(값);

  // `offer()`, `poll()`도 좋지만 빠른 디버깅을 위해 예외를 터트리는 메서드 사용 (PS)
  ```

- `long` 타입 사용시 주의점
  - 자바는 `숫자 리터럴`에 `L` 접미사를 붙여주지 않으면 `int` 취급!

  ```java
  long wrong = 1_000_000_000 * 1_000_000_000;
  // 이러면 int * int 라서 오버플로우 발생!! (wrong == -1486618624)

  long right = 1_000_000_000L * 1_000_000_000;
  // 한쪽에 `L`을 붙여서 long 리터럴로 만들어줘야 오버플로우가 안 생김

  long error = 2_147_483_648;
  // int 범위를 넘어서는 리터럴을 `L` 접미사 없이 사용하면 컴파일 에러!
  // error: integer number too large
  ```

  - 배열 크기, `Collection`의 인덱스, 크기 관련 메서드는 모두 파라미터로 `int`를 받고 `int`를 리턴!!

  ```java
  Queue.size();                   // 컬렉션의 size()는 항상 `int`형 값을 return
  String.length();                // String의 length()도 마찬가지

  long[] arr = new long[(int)3L]; // 배열 크기는 int형만 가능, long이라면 (int) 명시적 캐스팅 필요
  // long[] err = new long[3L];   // 컴파일 오류

  List.get(3);                    // 인덱스는 int형이어야한다!
  String.charAt(7);               // 인덱스는 int형이어야한다!
  String.substring(2, 3);         // 인덱스는 int형이어야한다!
  ```
