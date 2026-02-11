SELECT
    ORDER_ID,
    PRODUCT_ID,
    DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS 'OUT_DATE',
    CASE
        WHEN OUT_DATE <= '2022-05-01' THEN '출고완료'
        WHEN OUT_DATE > '2022-05-01' THEN '출고대기'
        ELSE '출고미정'
    END AS '출고여부'
FROM
    FOOD_ORDER
ORDER BY
    ORDER_ID ASC;

-- `DATE_FORMAT()`은 표준 SQL이 아니다.. DBMS마다 다른 함수를 사용함:
--
-- MySQL:      DATE_FORMAT(OUT_DATE, '%Y-%m-%d')
-- SQLite:     STRFTIME('%Y-%m-%d', OUT_DATE)
-- PostgreSQL: TO_CHAR(OUT_DATE, 'YYYY-MM-DD')
--
-- 2026-02-11 13:14:15 기준 ( '%Y-%m-%d %h:%i:%s' )
--
-- [연]
-- %Y : 2026
-- %y : 26
--
-- [월]
-- %M : February
-- %m : 02
--
-- [일]
-- %d : 11
--
-- [시]
-- %H : 13 (24시간제)
-- %h : 01 (12시간제)
--
-- [분]
-- %i : 14 <<< `%M`, `%m`은 이미 사용중이기 때문에 m`i`nute의 두번째 글자인 i를 사용!
--
-- [초]
-- %s : 15
--
-- [오전/오후]
-- %p : PM
