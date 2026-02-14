SELECT
    U.USER_ID,
    U.NICKNAME,
    SUM(PRICE) AS TOTAL_SALES -- 'TOTAL_SALES' (X)
FROM
    USED_GOODS_BOARD AS B
    JOIN USED_GOODS_USER AS U ON B.WRITER_ID = U.USER_ID
WHERE
    B.STATUS = 'DONE'
GROUP BY
    U.USER_ID
HAVING
    SUM(PRICE) >= 700000
ORDER BY
    SUM(PRICE) ASC;

-- 테이블명, 칼럼명, Alias 등의 식별자는 가급적 quote 없이 작성하는게 표준이다!!
--
-- Single Quote: 문자열, 날짜 리터럴 ( 'DONE', '과자', '2026-01-23', ... )
--               (비교 조건으로 사용되는 경우처럼 '값'일 땐 한글도 Single Quote로 감싸준다)
--
-- Double Quote: 특수 식별자 >> ( "order", "TOTAL SALES", "average-cost", "이름", ... )
--               (이름이 키워드랑 겹치거나, 공백을 포함하거나, 특수문자를 포함하거나, 한글인 경우)
--
-- Backtick도 특수 식별자를 감싸는 문법이긴 하지만, MySQL 전용! >> `TOTAL SALES`, `이름`, ...
