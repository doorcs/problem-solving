SELECT
    C.ID
FROM
    ECOLI_DATA AS A -- 1세대
    JOIN ECOLI_DATA AS B ON A.ID = B.PARENT_ID -- 2세대
    JOIN ECOLI_DATA AS C ON B.ID = C.PARENT_ID -- 3세대
WHERE
    A.PARENT_ID IS NULL -- 1세대 조건 (부모가 NULL)
ORDER BY
    C.ID ASC;

-- 첫 풀이 (CTE, 서브쿼리..)
--
-- WITH FIRST AS (
--     SELECT
--         ID
--     FROM
--         ECOLI_DATA
--     WHERE
--         PARENT_ID IS NULL
-- ), SECOND AS (
--     SELECT
--         ID
--     FROM
--         ECOLI_DATA
--     WHERE
--         PARENT_ID IN (SELECT * FROM FIRST)
-- )
--
-- SELECT
--     ID
-- FROM
--     ECOLI_DATA
-- WHERE
--     PARENT_ID IN (SELECT * FROM SECOND)
-- ORDER BY
--     ID ASC;
