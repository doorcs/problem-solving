WITH RECURSIVE CTE AS (
    SELECT
        0 AS HOUR

    UNION ALL

    SELECT
        HOUR+1 AS HOUR
    FROM
        CTE
    WHERE
        HOUR < 23
) -- `변수 사용`보다 `재귀 CTE 사용`이 권장되는 방식임

SELECT
    CTE.HOUR AS HOUR,
    COUNT(O.ANIMAL_ID) AS COUNT -- 여기서 COUNT(*) 하면 NULL도 카운팅하기 때문에 오답!!!!!!!! 칼럼 지정 필수
FROM
    CTE
    LEFT JOIN ANIMAL_OUTS AS O ON CTE.HOUR = HOUR(O.DATETIME) -- 0에서 23까지를 무조건 살리기 위해 LEFT JOIN
GROUP BY
    CTE.HOUR
ORDER BY
    1 ASC;
