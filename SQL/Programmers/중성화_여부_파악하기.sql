SELECT
    ANIMAL_ID,
    NAME,
    CASE
        WHEN SEX_UPON_INTAKE LIKE '%Neutered%' THEN 'O'
        WHEN SEX_UPON_INTAKE LIKE '%Spayed%' THEN 'O'
        ELSE 'X'
    END AS '중성화'
FROM
    ANIMAL_INS;

-- CASE
--     WHEN {조건1} THEN {값1}
--     WHEN {조건2} THEN {값2}
--     ...
--     ELSE {값} -- Optional
-- END AS {별칭}
