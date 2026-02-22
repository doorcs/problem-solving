SELECT
    EXTRACT(YEAR FROM S.SALES_DATE) AS YEAR, -- YEAR(), MONTH()는 표준 SQL 문법이 아니다
    EXTRACT(MONTH FROM S.SALES_DATE) AS MONTH, -- 근데 코테는 그냥 MySQL 기준으로 준비하는게 맞나 싶기도..
    I.GENDER,
    COUNT(DISTINCT I.USER_ID) AS USERS
FROM
    USER_INFO AS I
    JOIN ONLINE_SALE AS S ON I.USER_ID = S.USER_ID
WHERE
    I.GENDER IS NOT NULL
GROUP BY
    1,
    2,
    3
ORDER BY
    1 ASC,
    2 ASC,
    3 ASC;

-- 첫 풀이:
--
-- SELECT
--     YEAR(S.SALES_DATE) AS YEAR,
--     MONTH(S.SALES_DATE) AS MONTH,
--     I.GENDER,
--     COUNT(DISTINCT I.USER_ID) AS USERS
-- FROM
--     USER_INFO AS I
--     JOIN ONLINE_SALE AS S ON I.USER_ID = S.USER_ID
-- WHERE
--     I.GENDER IS NOT NULL
-- GROUP BY
--     1,
--     2,
--     3
-- ORDER BY
--     1 ASC,
--     2 ASC,
--     3 ASC;
--
-- YEAR(), MONTH() 함수는 정수를 반환
-- DATE_FORMAT(val, '%Y') 이나 DATE_FORMAT(val, '%m 또는 %c') 은 문자열을 반환
-- 바로 출력하는거라면 상관없지만, 이 문제처럼 정렬이 들어갈 경우 문자열은 뭔가 문제가 생길 수도 있다!
