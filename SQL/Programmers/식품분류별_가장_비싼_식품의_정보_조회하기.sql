SELECT
    CATEGORY,
    PRICE AS MAX_PRICE,
    PRODUCT_NAME
FROM
    FOOD_PRODUCT
WHERE
    (CATEGORY, PRICE) IN (
        SELECT
            CATEGORY,
            MAX(PRICE)
        FROM
            FOOD_PRODUCT
        WHERE
            CATEGORY IN ('과자', '국', '김치', '식용유')
        GROUP BY
            CATEGORY
    )
ORDER BY
    MAX_PRICE DESC;

-- `GROUP BY`를 사용할 경우, SELECT절에는 `GROUP BY에 포함된 칼럼` 또는 `집계함수(SUM, AVG, ...)`만 올 수 있다!!!!!
--
-- 따라서 아래처럼 쓸 수는 없음 (오답 풀이)
--
-- SELECT
--     CATEGORY,
--     MAX(PRICE) AS 'MAX_PRICE',
--     PRODUCT_NAME
-- FROM
--     FOOD_PRODUCT
-- WHERE
--     CATEGORY IN ('과자', '국', '김치', '식용유')
-- GROUP BY
--     CATEGORY
-- ORDER BY
--     MAX(PRICE) DESC;
