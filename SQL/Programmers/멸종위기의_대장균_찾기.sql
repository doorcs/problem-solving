WITH RECURSIVE CTE AS (
    SELECT
        ID,
        1 AS GENERATION
    FROM
        ECOLI_DATA
    WHERE
        PARENT_ID IS NULL

    UNION ALL

    SELECT
        E.ID,
        GENERATION + 1 AS GENERATION
    FROM
        CTE
        JOIN ECOLI_DATA AS E ON CTE.ID = E.PARENT_ID
)

SELECT
    COUNT(ID) AS COUNT,
    GENERATION
FROM
    CTE
WHERE
    -- 재귀 CTE에 모든 개체의 ID와 세대 정보가 들어있으니, 이걸 활용하면 조금 더 효율적인 쿼리를 짤 수 있다
    -- `내 ID`가 `PARENT_ID` 목록에 없다 == 자식이 없다!
    ID NOT IN (
        SELECT
            PARENT_ID
        FROM
            ECOLI_DATA
        WHERE
            PARENT_ID IS NOT NULL
    )
GROUP BY
    GENERATION
ORDER BY
    GENERATION ASC;

-- 첫 풀이:

-- WITH RECURSIVE CTE AS (
--     SELECT
--         ID,
--         1 AS GENERATION
--     FROM
--         ECOLI_DATA
--     WHERE
--         PARENT_ID IS NULL

--     UNION ALL

--     SELECT
--         E.ID,
--         GENERATION + 1 AS GENERATION
--     FROM
--         CTE
--         JOIN ECOLI_DATA AS E ON CTE.ID = E.PARENT_ID
-- )

-- SELECT
--     COUNT(E1.ID) AS COUNT,
--     GENERATION
-- FROM
--     ECOLI_DATA AS E1
--     LEFT JOIN ECOLI_DATA AS E2 ON E1.ID = E2.PARENT_ID
--     JOIN CTE ON E1.ID = CTE.ID
-- WHERE
--     E2.ID IS NULL
-- GROUP BY
--     GENERATION
-- ORDER BY
--     GENERATION ASC;
