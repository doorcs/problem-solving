SELECT
    ID,
    EMAIL,
    FIRST_NAME,
    LAST_NAME
FROM
    DEVELOPERS
WHERE
    SKILL_CODE & (
        SELECT
            SUM(CODE)
        FROM
            SKILLCODES
        WHERE
            NAME IN ('Python', 'C#')
    ) > 0 -- 0인지 아닌지 비교할 때 `val = 0` 이나 `val > 0`를 쓰는 습관을 들이자
ORDER BY
    ID ASC;

-- 첫 풀이
--
-- SELECT
--     ID,
--     EMAIL,
--     FIRST_NAME,
--     LAST_NAME
-- FROM
--     DEVELOPERS
-- WHERE
--     SKILL_CODE & (
--         SELECT
--             CODE
--         FROM
--             SKILLCODES
--         WHERE
--             NAME = 'Python'
--     ) != 0
--     OR SKILL_CODE & (
--         SELECT
--             CODE
--         FROM
--             SKILLCODES
--         WHERE
--             NAME = 'C#'
--     ) != 0
-- ORDER BY
--     ID ASC;
