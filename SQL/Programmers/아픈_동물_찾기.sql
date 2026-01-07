SELECT
    ANIMAL_ID,
    name
FROM
    ANIMAL_INS
WHERE
    INTAKE_CONDITION = 'Sick'
ORDER BY
    ANIMAL_ID;

-- ORDER BY에서 ASC, DESC를 생략하면 기본값은 ASC (오름차순)
-- SQL에서는 문자열에 "" 대신 ''를 쓰는게 표준!! (ANSI SQL)
