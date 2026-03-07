<details>
  <summary>기본적인 SQL 문법 (CRUD)</summary>

---

- `SELECT`문의 구조 및 실행 순서

```sql
SELECT
    d.dname AS dept,
    AVG(e.salary) AS average_salary
    -- `AS`를 통해 테이블명, 칼럼명, 집계함수 등에 별칭(alias)을 줄 수 있다
FROM
    employee AS e
    JOIN department AS d ON e.dno = d.dno
    -- SQL에는 할당문이 없기 때문에 동등성 비교에 `==`가 아닌 `=` 사용
WHERE
    e.position = 'Manager'
    -- 문자열은 single quote 로 감싸기
    AND e.eno IS NOT NULL
    -- null과의 비교는 `=`, `!=` 대신 `IS NULL`, `IS NOT NULL` 사용
GROUP BY
    d.dname
HAVING
    AVG(e.salary) > 7000
    -- GROUP BY로 묶인 그룹에서 필터링 수행
    -- `GROUP BY에 명시된 칼럼` 또는 `집계함수` 만 올 수 있다!
ORDER BY
    average_salary DESC,
    d.dno ASC
    -- 내림차순으로 정렬하려면 `DESC`, 생략 시 기본값은 `ASC`
    -- 칼럼명이나 alias 대신 SELECT문에서 선택된 순서(1, 2, ...)를 사용할 수도 있다
    -- ... ORDER BY 2 DESC ...
LIMIT
    3;

-------------------------------------------------------------------------------

`FROM (&& JOIN)` -> `WHERE` -> `GROUP BY` -> `HAVING` -> `SELECT` -> `ORDER BY` -> `LIMIT`
```

- `INSERT`문의 구조 ( `INSERT INTO` )

```sql
INSERT INTO
    brand (category_id, brand_id, name, imalge_url)
    -- 괄호와 칼럼명은 생략 가능하지만, 이럴 경우 테이블에 존재하는 모든 칼럼을 순서대로 적어줘야 함
    -- INSERT INTO brand VALUES (), (), ...;
VALUES
    (1, 1, '버거킹', 'https://nochigima.s3.ap-northeast-2.amazonaws.com/...'),
    (1, 2, '맥도날드', 'https://nochigima.s3.ap-northeast-2.amazonaws.com/...');
    -- 만약 INSERT문에서 명시되지 않은 칼럼이 테이블에 존재한다면 null이 들어간다
```

- `UPDATE`문의 구조

```sql
UPDATE product
SET
    discount_value = 15,
    start_at = '2026-01-01',
    end_at = '2026-01-11'
    -- 여러 칼럼을 동시에 수정해줄 수도 있다
WHERE
    id = 68;
    -- !!조건을 생략할 수도!! 있다 (테이블 내 모든 레코드를 동시에 업데이트)
```

- `DELETE`문의 구조 ( `DELETE FROM` )

```sql
DELETE FROM promotion
WHERE
    end_at >= '2025-01-01' AND end_at < '2026-01-01';
    -- !!조건을 생략할 수도!! 있다 (테이블 스키마는 유지하되 모든 레코드를 삭제)
```

</details>
<details>
  <summary>기억해둬야 할 함수 (MySQL)</summary>

---

- `COALESCE(val1, val2, ...)`
  - 왼쪽부터 차례대로 확인해서, `NULL`이 아닌 첫번째 값을 리턴
    - `COALESCE(NULL, NULL, 3)` -> `3`
    - `COALESCE(NULL, 2, 3)` -> `2`

---

- `YEAR()`, `MONTH()`, `DAY()`, `HOUR()`, `MINUTE()`, `SECOND()`
  - 리턴값을 정수형으로 줘서 정렬 기준으로 써도 안전!
- `DATE_FORMAT(date, '%Y-%m-%d %h:%i:%s`)
  - 각각 연, 월, 일, 시, 분, 초 -> `2026-03-07 11:02:35`
  - `분`의 경우, `%m`은 `월`에서 사용중이기 때문에 minute의 두번째 글자인 `%i`
- `DATEDIFF(end, start)`
  - 자바의 `Integer.compare(o1, o2)` 처럼 첫번째 파라미터에서 두번째 파라미터를 뺀 결과를 정수형으로 리턴 <!-- 엄밀히 따지자면 Integer.compare()의 리턴값은 `음수(-1)`, `0`, `양수(+1)`이지만 빼는 방향은 같다 -->
  - 일수를 계산하려면 **_<ins>1을 더해줘야함!!</ins>_** -> `DATEDIFF(end, start) + 1`

---

- `REPLACE(str, 'from', 'to')`
  - `REPLACE(DISCOUNT_RATE, '%', '')` 처럼 세번째 파라미터로 빈 문자열을 줘서 문자를 지울 수도 있다
- `SUBSTRING(str, startIdx, length)`
  - 세번째 파라미터는 끝나는 인덱스가 아니라 **_<ins>추출할 문자열의 길이</ins>_** !!
  - 세번째 파라미터를 생략하면 시작 인덱스부터 문자열 끝까지 잘라서 리턴
- `CONCAT(val1, val2, ...)`
  - MySQL 기준, 파라미터를 여러 개 받을 수 있다! -> `CONCAT(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2)`
- `CONVERT(str, SIGNED)` 또는 `CONVERT(str, UNSIGNED)`
  - 문자열을 숫자로 바꿔야 할 경우 사용 -> `CONVERT(REPLACE(val, '%', ''), UNSIGNED) / 100`

---

- `SUM()`, `MIN()`, `MAX()`, `AVG()`
  - 기본 집계함수
- `COUNT(*)` 또는 `COUNT(col)`
  - COUNT(\*)의 경우 단순히 레코드 수를 세기 때문에 `NULL`도 카운팅한다!!
  - `NULL`을 빼고 카운팅해야 하는 경우 카운팅할 칼럼명을 명시적으로 적어주기
- `ROUND(val, decimals)`
  - 두번째 파라미터는 반올림 후 **_<ins>소수점 아래에 남길 자릿수</ins>_**
    - `ROUND(123.456, 2)` -> `123.46`
    - `ROUND(123.456, 0)` -> `123`
  - 두번째 파라미터에 음수를 쓰면 정수부에서 반올림한다
    - `ROUND(123.456, -1)` -> `120`

</details>

---

- 특정 DBMS에 종속적인 문법보다 `표준 SQL 문법`을 우선적으로 고려하기 ( `IFNULL` -> `COALESCE` )
- 키워드와 함수는 모두 `UPPERCASE`로 쓰기 ( `SELECT`, `MIN`, `MAX`, ... )
- 테이블명과 칼럼명은 `snake_case`로 쓰려고 하되, 대문자로 주어질 경우 그대로 쓰기
- 별칭을 적극적으로 활용하고, `AS` 키워드를 생략하지 않기
- Quote 컨벤션 잘 지키기

  ```sql
  -- Single Quote: 문자열, 날짜 리터럴, 이진 리터럴
  -- 비교 조건으로 사용되는 경우처럼 '값'일 땐 한글도 Single Quote로 감싸준다!
  'DONE', '과자', '2026-01-23', b'101101', ...

  -- Double Quote: 특수 식별자 ( `A-Za-z0-9_` 범위를 벗어날 경우 )
  -- 이름이 키워드랑 겹치거나, 공백을 포함하거나, 특수문자를 포함하거나, 한글인 경우
  "order", "TOTAL SALES", "average-cost", "이름", ...

  -- Backtick도 특수 식별자를 감싸는 문법이긴 하지만, MySQL 전용!! ( Double Quote 쓰되, 알아만 두자 )
  `TOTAL SALES`, `이름`, ...
  ```

- `ORDER BY` 절에서는 가급적 계산식을 그대로 다시 쓰는 습관 들이기
  - `DATE_FORMAT()`이나 `CONCAT()`처럼 문자열을 리턴하는 함수의 경우, `SELECT 순서`나 `별칭`을 쓰면 정렬이 망가질 수 있다
