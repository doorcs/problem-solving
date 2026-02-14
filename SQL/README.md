<details>
  <summary>기본적인 SQL 문법 (CRUD)</summary>

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
ORDER BY
    average_salary DESC
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

---

- 특정 DBMS에 종속적인 문법보다 `표준 SQL 문법`을 우선적으로 고려하기 ( `IFNULL` -> `COALESCE` )
- 키워드와 함수는 모두 `UPPERCASE`로 쓰기 ( `SELECT`, `MIN`, `MAX`, ... )
- 테이블명과 칼럼명은 `snake_case`로 쓰려고 하되, 대문자로 주어질 경우 그대로 쓰기
- 별칭을 적극적으로 활용하고, `AS` 키워드를 생략하지 않기
- Quote 컨벤션 잘 지키기

  ```sql
  -- Single Quote: 문자열, 날짜 리터럴
  -- 비교 조건으로 사용되는 경우처럼 '값'일 땐 한글도 Single Quote로 감싸준다!
  'DONE', '과자', '2026-01-23', ...

  -- Double Quote: 특수 식별자
  -- 이름이 키워드랑 겹치거나, 공백을 포함하거나, 특수문자를 포함하거나, 한글인 경우
  "order", "TOTAL SALES", "average-cost", "이름", ...

  -- Backtick도 특수 식별자를 감싸는 문법이긴 하지만, MySQL 전용!! ( Double Quote 쓰되, 알아만 두자 )
  `TOTAL SALES`, `이름`, ...
  ```
