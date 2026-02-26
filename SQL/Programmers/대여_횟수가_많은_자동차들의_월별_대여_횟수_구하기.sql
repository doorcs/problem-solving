SELECT
    MONTH(START_DATE) AS MONTH,
    CAR_ID,
    COUNT(*) AS RECORDS
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE
    START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
    AND CAR_ID IN (
        SELECT
            CAR_ID
        FROM
            CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE
            START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
        GROUP BY
            CAR_ID
        HAVING
            COUNT(*) >= 5
    )
GROUP BY
    MONTH(START_DATE),
    CAR_ID
ORDER BY
    1 ASC,
    2 DESC;

-- 아래 오답 쿼리처럼 서브쿼리 없이 `GROUP BY MONTH, CAR_ID` 이후 HAVING을 적용하면
-- `8월`, `9월`, `10월` 각각 5회 이상 대여된 자동차인지를 확인해버린다
--
-- 8월에 2번,
-- 9월에 2번,
-- 10월에 1번 대여된 자동차가 있다면 필터링됨... (그래서 오답)
--
-- 문제 요구사항은 (8월+9월+10월) 전체 기간동안 5번 이상 대여된 자동차를 찾고, 그 자동차들의 월별 대여 횟수를 구하는것!!
--
-- 처음 작성한 오답 쿼리:
--
-- SELECT
--     MONTH(START_DATE) AS MONTH,
--     CAR_ID,
--     COUNT(*) AS RECORDS
-- FROM
--     CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- WHERE
--     START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
-- GROUP BY
--     MONTH(START_DATE),
--     CAR_ID
-- HAVING
--     COUNT(*) >= 5
-- ORDER BY
--     1 ASC,
--     2 DESC;
