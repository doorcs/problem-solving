SELECT
    COUNT(I.ID) AS FISH_COUNT,
    N.FISH_NAME AS FISH_NAME
FROM
    FISH_INFO AS I
    JOIN FISH_NAME_INFO AS N ON I.FISH_TYPE = N.FISH_TYPE
GROUP BY
    N.FISH_NAME
ORDER BY
    1 DESC;

-- 길이가 10 아래면 `FISH_INFO`의 LENGTH 칼럼에 `NULL`이 들어간다고 해서
-- 처음 풀 땐 `WHERE I.LENGTH IS NOT NULL`을 넣었었는데 오답 처리됨..
--
-- 길이가 10 아래인것도 카운팅해야하니까 IS NOT NULL로 걸러버리면 안 되는듯
-- 근데 그럴거면 길이를 왜 NULL로 저장해두는건지 이해가 잘 안된다
