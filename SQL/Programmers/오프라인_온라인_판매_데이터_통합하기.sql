SELECT
    DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE,
    PRODUCT_ID,
    USER_ID,
    SALES_AMOUNT
FROM
    ONLINE_SALE
WHERE
    SALES_DATE BETWEEN '2022-03-01' AND '2022-03-31'

UNION ALL

SELECT
    DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE,
    PRODUCT_ID,
    NULL AS USER_ID, -- UNION을 하려면 `칼럼 수`와 `각 칼럼의 이름`이 같아야 한다. 다르다면 AS 키워드와 별칭 활용!
    SALES_AMOUNT
FROM
    OFFLINE_SALE
WHERE
    SALES_DATE BETWEEN '2022-03-01' AND '2022-03-31'
ORDER BY
    SALES_DATE ASC,
    PRODUCT_ID ASC,
    USER_ID ASC;

-- 첫 풀이 (
--     날짜 조건을 BETWEEN으로 처리할 수 있는데 YEAR(), MONTH()를 써서 비효율적임,
--     불필요한 GROUP BY 사용,
-- )
--
-- SELECT
--     DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE,
--     PRODUCT_ID,
--     USER_ID,
--     SALES_AMOUNT
-- FROM
--     ONLINE_SALE
-- WHERE
--     YEAR(SALES_DATE) = 2022
--     AND MONTH(SALES_DATE) = 3
-- GROUP BY
--     1,
--     2,
--     3,
--     4
--
-- UNION ALL
--
-- SELECT
--     DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE,
--     PRODUCT_ID,
--     NULL AS USER_ID,
--     SALES_AMOUNT
-- FROM
--     OFFLINE_SALE
-- WHERE
--     YEAR(SALES_DATE) = 2022
--     AND MONTH(SALES_DATE) = 3
-- GROUP BY
--     1,
--     2,
--     3,
--     4
-- ORDER BY
--     1 ASC,
--     2 ASC,
--     3 ASC;
