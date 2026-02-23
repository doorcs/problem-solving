SELECT
    I.ID,
    N.FISH_NAME,
    I.LENGTH
FROM
    FISH_INFO AS I
    JOIN FISH_NAME_INFO AS N ON I.FISH_TYPE = N.FISH_TYPE
WHERE
    (I.FISH_TYPE, I.LENGTH) IN (
        SELECT
            FISH_TYPE,
            MAX(LENGTH)
        FROM
            FISH_INFO
        GROUP BY
            FISH_TYPE
    )
ORDER BY
    1 ASC;

-- 첫 풀이 (서브쿼리에 불필요한 JOIN이 있음)
--
-- SELECT
--     I.ID,
--     N.FISH_NAME,
--     I.LENGTH
-- FROM
--     FISH_INFO AS I
--     JOIN FISH_NAME_INFO AS N ON I.FISH_TYPE = N.FISH_TYPE
-- WHERE
--     (N.FISH_NAME, I.LENGTH) IN (
--         SELECT
--             N.FISH_NAME,
--             MAX(I.LENGTH) AS MAX_LENGTH
--         FROM
--             FISH_INFO AS I
--             JOIN FISH_NAME_INFO AS N ON I.FISH_TYPE = N.FISH_TYPE
--         GROUP BY
--             N.FISH_NAME
--     )
-- ORDER BY
--     1 ASC;
