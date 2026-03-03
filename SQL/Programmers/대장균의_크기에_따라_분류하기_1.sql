SELECT
    ID,
    CASE
        WHEN SIZE_OF_COLONY > 1000 THEN 'HIGH' -- 1000 초과
        WHEN SIZE_OF_COLONY BETWEEN 101 AND 1000 THEN 'MEDIUM' -- 100 초과 1000 이하 (101부터 1000까지)
        WHEN SIZE_OF_COLONY <= 100 THEN 'LOW' -- 100 이하
    END AS SIZE
    -- CASE
    --     WHEN SIZE_OF_COLONY > 1000 THEN 'HIGH'
    --     WHEN SIZE_OF_COLONY > 100  THEN 'MEDIUM' -- 위에서 1000초과가 모두 걸러졌기 때문에 자동으로 100초과 1000이하가 됨
    --     ELSE 'LOW'
    -- END AS SIZE
    --
    -- CASE문의 조건은 위에서부터 순차적으로 평가되기 때문에 이렇게 작성할 수도 있다
FROM
    ECOLI_DATA
ORDER BY
    ID ASC;

-- `val BETWEEN A AND B` == `val >= A AND val <= B`
--
-- 1. 반드시 A가 B보다 `작거나 같아`야 한다. 순서 주의!!! ( 작은거 먼저 적기 )
-- 2. A와 B 값이 모두 범위에 포함된다!
--
-- `val BETWEEN 0 AND 3` -> `val = 0 OR val = 1 OR val = 2 OR val = 3`
--
-- `val BETWEEN 3 AND 0` -> 항상 공집합 ( `x >= 3 && x <= 0`을 만족하는 x는 없다 )
--
--
-- + BETWEEN으로 날짜 비교 시 주의해야 할 포인트:
--
-- WHERE created_at BETWEEN '2026-03-01' AND '2026-03-31'
-- 위처럼 쓰면 뒤쪽에 오는'2026-03-31'가 '2026-03-31 00:00:00'로 해석되어 3월 31일 하루 중 00:00:00 이후의 값이 빠질 수도 있다!!!!!!!
--
-- 따라서, WHERE created_at >= '2026-03-01' AND created_at < '2026-04-01' 처럼 쓰는게 안전하다
--
-- WHERE DATE(created_at) BETWEEN '2026-03-01' AND '2026-03-31' 도 논리적으로는 괜찮지만, DATE()때문에 인덱스를 못 써서 느리다
