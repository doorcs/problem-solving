SELECT
    COUNT(ID) AS FISH_COUNT,
    MAX(LENGTH) AS MAX_LENGTH,
    FISH_TYPE
FROM
    FISH_INFO
WHERE
    FISH_TYPE IN (
        SELECT
            FISH_TYPE
        FROM
            FISH_INFO
        GROUP BY
            FISH_TYPE
        HAVING
            AVG(COALESCE(LENGTH, 10)) >= 33
    )
GROUP BY
    FISH_TYPE
ORDER BY
    3 ASC;

-- 이 풀이가 가능한 이유: 문제에 물고기 LENGTH에 `NULL만 있는 경우는 없다`는 조건이 있음
