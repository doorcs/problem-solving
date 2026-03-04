SELECT
    ID,
    EMAIL,
    FIRST_NAME,
    LAST_NAME
FROM
    DEVELOPERS
WHERE
    (SKILL_CODE & (
        SELECT
            SUM(CODE) AS CODE
        FROM
            SKILLCODES
        WHERE
            CATEGORY = 'Front End'
    )) > 0 -- `!= 0` 또는 `<> 0` 도 가능
ORDER BY
    ID ASC;
