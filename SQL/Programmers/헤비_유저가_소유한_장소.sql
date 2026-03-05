SELECT
    ID,
    NAME,
    HOST_ID
FROM
    PLACES
WHERE
    HOST_ID IN (
        SELECT
            HOST_ID
        FROM
            PLACES
        GROUP BY
            HOST_ID
        HAVING
            COUNT(ID) > 1
    )
ORDER BY
    ID ASC;

-- CTE와 JOIN시 USING을 활용한 다른 풀이

-- WITH CTE AS (
--     SELECT
--         HOST_ID
--     FROM
--         PLACES
--     GROUP BY
--         HOST_ID
--     HAVING
--         COUNT(ID) > 1
-- )

-- SELECT
--     ID,
--     NAME,
--     HOST_ID
-- FROM
--     PLACES
--     JOIN CTE USING (HOST_ID)
-- ORDER BY
--     ID ASC;
