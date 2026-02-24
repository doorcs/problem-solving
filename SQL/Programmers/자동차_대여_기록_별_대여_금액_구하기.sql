SELECT
    H.HISTORY_ID,
    ROUND(
        (DATEDIFF(H.END_DATE, H.START_DATE) + 1) * C.DAILY_FEE * (
            100 - CONVERT(
                COALESCE(REPLACE(D.DISCOUNT_RATE, '%', ''), 0),
                UNSIGNED
            )
        ) / 100,
        0
    ) AS FEE
FROM
    CAR_RENTAL_COMPANY_CAR AS C
    JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H ON C.CAR_ID = H.CAR_ID
    LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS D ON C.CAR_TYPE = D.CAR_TYPE
    AND (
        CASE
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 90 THEN '90일 이상'
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 30 THEN '30일 이상'
            WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 7 THEN '7일 이상'
        END
    ) = D.DURATION_TYPE
WHERE
    C.CAR_TYPE = '트럭'
ORDER BY
    2 DESC,
    1 DESC;

-- 첫 풀이 (
--     MySQL의 문자열 -> 정수형 암시적 캐스팅에 의존,
--     불필요한 GROUP BY 사용
-- )
--
-- SELECT
--     H.HISTORY_ID,
--     ROUND(
--         (DATEDIFF(H.END_DATE, H.START_DATE) + 1) * C.DAILY_FEE * (100 - COALESCE(D.DISCOUNT_RATE, 0)) / 100,
--         0
--     ) AS FEE
-- FROM
--     CAR_RENTAL_COMPANY_CAR AS C
--     JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS H ON C.CAR_ID = H.CAR_ID
--     LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS D ON C.CAR_TYPE = D.CAR_TYPE
--     AND (
--         CASE
--             WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 90 THEN '90일 이상'
--             WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 30 THEN '30일 이상'
--             WHEN DATEDIFF(H.END_DATE, H.START_DATE) + 1 >= 7 THEN '7일 이상'
--         END
--     ) = D.DURATION_TYPE
-- WHERE
--     C.CAR_TYPE = '트럭'
-- GROUP BY
--     H.HISTORY_ID
-- ORDER BY
--     2 DESC,
--     1 DESC;
