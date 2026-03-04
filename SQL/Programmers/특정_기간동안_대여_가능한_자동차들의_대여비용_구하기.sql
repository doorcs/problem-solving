WITH DISCOUNT AS (
    SELECT
        CAR_TYPE,
        DISCOUNT_RATE
    FROM
        CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE
        DURATION_TYPE = '30일 이상' -- 대여 기간이 30일로 고정이기 때문에, `30일 대여 시 할인율`만 따로 빼두고 사용
)

SELECT
    C.CAR_ID,
    C.CAR_TYPE,
    ROUND(C.DAILY_FEE * 30 / 100 * (100 - D.DISCOUNT_RATE), 0) AS FEE -- 대여 기간이 고정이니 DATEDIFF()로 계산할 필요가 없다..
FROM
    CAR_RENTAL_COMPANY_CAR AS C
    JOIN DISCOUNT AS D ON C.CAR_TYPE = D.CAR_TYPE
WHERE
    ROUND(C.DAILY_FEE * 30 / 100 * (100 - D.DISCOUNT_RATE), 0) BETWEEN 500000 AND 1999999
    AND C.CAR_TYPE IN ('세단', 'SUV')
    AND C.CAR_ID NOT IN (
        SELECT
            CAR_ID
        FROM
            CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE
            START_DATE <= '2022-11-30' -- 기간 처리 집중!! 잘못 생각하기 쉽다
            AND END_DATE >= '2022-11-01' -- 실전에선 종이에 구간 그려두고 보기
    )
ORDER BY
    FEE DESC,
    C.CAR_TYPE ASC,
    C.CAR_ID DESC;

-- 첫 풀이 ( 대여일수가 30일로 고정인데 `ROUND()` 안에서 불필요한 `DATEDIFF()` 함수 사용 )

-- WITH DISCOUNT AS (
--     SELECT
--         CAR_TYPE,
--         DISCOUNT_RATE
--     FROM
--         CAR_RENTAL_COMPANY_DISCOUNT_PLAN
--     WHERE
--         DURATION_TYPE = '30일 이상' -- 대여 기간이 30일로 고정이기 때문에, `30일 대여 시 할인율`만 따로 빼두고 사용
-- )

-- SELECT
--     C.CAR_ID,
--     C.CAR_TYPE,
--     ROUND(
--         C.DAILY_FEE * (DATEDIFF('2022-11-30', '2022-11-01') + 1) / 100 * (100 - D.DISCOUNT_RATE), 0
--     ) AS FEE
-- FROM
--     CAR_RENTAL_COMPANY_CAR AS C
--     JOIN DISCOUNT AS D ON C.CAR_TYPE = D.CAR_TYPE
-- WHERE
--     ROUND(
--         C.DAILY_FEE * (DATEDIFF('2022-11-30', '2022-11-01') + 1) / 100 * (100 - D.DISCOUNT_RATE), 0
--     ) BETWEEN 500000 AND 1999999
--     AND C.CAR_TYPE IN ('세단', 'SUV')
--     AND C.CAR_ID NOT IN (
--         SELECT
--             CAR_ID
--         FROM
--             CAR_RENTAL_COMPANY_RENTAL_HISTORY
--         WHERE
--             DATE(START_DATE) <= '2022-11-30' -- 기간 처리 집중!! 잘못 생각하기 쉽다
--             AND DATE(END_DATE) >= '2022-11-01' -- 실전에선 종이에 구간 그려두고 보기
--     )
-- ORDER BY
--     FEE DESC,
--     C.CAR_TYPE ASC,
--     C.CAR_ID DESC;
