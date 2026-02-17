SELECT
    O.ANIMAL_ID,
    O.ANIMAL_TYPE,
    O.NAME
FROM
    ANIMAL_OUTS AS O
    JOIN ANIMAL_INS AS I ON O.ANIMAL_ID = I.ANIMAL_ID
WHERE
    (
        O.SEX_UPON_OUTCOME LIKE '%Spayed%'
        OR O.SEX_UPON_OUTCOME LIKE '%Neutered%'
    )
    AND I.SEX_UPON_INTAKE LIKE '%Intact%';

-- WHERE
--     I.SEX_UPON_INTAKE LIKE '%Intact%'
--     AND (
--         O.SEX_UPON_OUTCOME LIKE '%Spayed%'
--         OR O.SEX_UPON_OUTCOME LIKE '%Neutered%'
--     );
