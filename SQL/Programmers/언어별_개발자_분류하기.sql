WITH CTE AS (
    SELECT
        (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End') AS FE,
        (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python') AS PY,
        (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#') AS CS
)

SELECT
    CASE
        WHEN SKILL_CODE & FE > 0 AND SKILL_CODE & PY > 0 THEN 'A'
        WHEN SKILL_CODE & CS > 0 THEN 'B'
        WHEN SKILL_CODE & FE > 0 THEN 'C'
    END AS GRADE,
    ID,
    EMAIL
FROM
    DEVELOPERS
    CROSS JOIN CTE
WHERE
    SKILL_CODE & FE > 0
    OR SKILL_CODE & CS > 0
ORDER BY
    GRADE ASC,
    ID ASC;

-- 두번째 풀이

-- WITH CTE AS (
--     SELECT
--         CASE
--             WHEN SKILL_CODE & (
--                 SELECT
--                     SUM(CODE)
--                 FROM
--                     SKILLCODES
--                 WHERE
--                     CATEGORY = 'Front End'
--             ) > 0 AND SKILL_CODE & (
--                 SELECT
--                     CODE
--                 FROM
--                     SKILLCODES
--                 WHERE
--                     NAME = 'Python'
--             ) > 0 THEN 'A'
--             WHEN SKILL_CODE & (
--                 SELECT
--                     CODE
--                 FROM
--                     SKILLCODES
--                 WHERE
--                     NAME = 'C#'
--             ) > 0 THEN 'B'
--             WHEN SKILL_CODE & (
--                 SELECT
--                     SUM(CODE)
--                 FROM
--                     SKILLCODES
--                 WHERE
--                     CATEGORY = 'Front End'
--             ) > 0 THEN 'C'
--         END AS GRADE,
--         ID,
--         EMAIL
--     FROM
--         DEVELOPERS
-- )

-- SELECT
--     *
-- FROM
--     CTE
-- WHERE
--     GRADE IS NOT NULL
-- ORDER BY
--     GRADE ASC,
--     ID ASC;

-- 첫 풀이:

-- SELECT
--     CASE
--         WHEN SKILL_CODE & (
--             SELECT
--                 SUM(CODE)
--             FROM
--                 SKILLCODES
--             WHERE
--                 CATEGORY = 'Front End'
--         ) > 0 AND SKILL_CODE & (
--             SELECT
--                 CODE
--             FROM
--                 SKILLCODES
--             WHERE
--                 NAME = 'Python'
--         ) > 0 THEN 'A'
--         WHEN SKILL_CODE & (
--             SELECT
--                 CODE
--             FROM
--                 SKILLCODES
--             WHERE
--                 NAME = 'C#'
--         ) > 0 THEN 'B'
--         WHEN SKILL_CODE & (
--             SELECT
--                 SUM(CODE)
--             FROM
--                 SKILLCODES
--             WHERE
--                 CATEGORY = 'Front End'
--         ) > 0 THEN 'C'
--     END AS GRADE,
--     ID,
--     EMAIL
-- FROM
--     DEVELOPERS
-- WHERE
--     CASE
--         WHEN SKILL_CODE & (
--             SELECT
--                 SUM(CODE)
--             FROM
--                 SKILLCODES
--             WHERE
--                 CATEGORY = 'Front End'
--         ) > 0 AND SKILL_CODE & (
--             SELECT
--                 CODE
--             FROM
--                 SKILLCODES
--             WHERE
--                 NAME = 'Python'
--         ) > 0 THEN 'A'
--         WHEN SKILL_CODE & (
--             SELECT
--                 CODE
--             FROM
--                 SKILLCODES
--             WHERE
--                 NAME = 'C#'
--         ) > 0 THEN 'B'
--         WHEN SKILL_CODE & (
--             SELECT
--                 SUM(CODE)
--             FROM
--                 SKILLCODES
--             WHERE
--                 CATEGORY = 'Front End'
--         ) > 0 THEN 'C'
--     END IS NOT NULL
-- ORDER BY
--     GRADE ASC,
--     ID ASC;
