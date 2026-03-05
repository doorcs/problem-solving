SELECT
    CART_ID
FROM
    CART_PRODUCTS
WHERE
    NAME = 'Milk'

INTERSECT

SELECT
    CART_ID
FROM
    CART_PRODUCTS
WHERE
    NAME = 'Yogurt'

ORDER BY CART_ID ASC;

-- SELECT
--     CART_ID
-- FROM
--     CART_PRODUCTS
-- WHERE
--     NAME IN ('Milk', 'Yogurt')
-- GROUP BY
--     CART_ID
-- HAVING
--     COUNT(DISTINCT NAME) > 1 -- HAVING 절에 올 수 있는것: `GROUP BY에 명시된 칼럼` 또는 `집계함수`
-- ORDER BY
--     CART_ID ASC;

-- `RANK -> COLONY_RANK` 정답 쿼리

-- WITH CTE AS (
--     SELECT
--         ID,
--         RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS COLONY_RANK,
--         COUNT(*) OVER () AS CNT
--     FROM
--         ECOLI_DATA
-- )

-- SELECT
--     ID,
--     CASE
--         WHEN COLONY_RANK <= (CNT / 4) THEN 'CRITICAL'
--         WHEN COLONY_RANK <= (CNT / 4 * 2) THEN 'HIGH'
--         WHEN COLONY_RANK <= (CNT / 4 * 3) THEN 'MEDIUM'
--         ELSE 'LOW'
--     END AS COLONY_NAME
-- FROM
--     CTE
-- ORDER BY
--     ID ASC;

-- 처음 작성한 오답 쿼리 (RANK() 함수로 계한 별칭을 RANK로 둬서.. 문법 오류)

-- WITH CTE AS (
--     SELECT
--         ID,
--         RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS RANK,
--         COUNT(*) OVER () AS CNT
--     FROM
--         ECOLI_DATA
-- )

-- SELECT
--     ID,
--     CASE
--         WHEN RANK <= (CNT / 4) THEN 'CRITICAL'
--         WHEN RANK <= (CNT / 4 * 2) THEN 'HIGH'
--         WHEN RANK <= (CNT / 4 * 3) THEN 'MEDIUM'
--         ELSE 'LOW'
--     END AS COLONY_NAME
-- FROM
--     CTE
-- ORDER BY
--     ID ASC;
