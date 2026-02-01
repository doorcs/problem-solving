SELECT
    ANIMAL_ID,
    NAME,
    DATE_FORMAT(DATETIME, '%Y-%m-%d') AS '날짜' -- DATE_FORMAT() 같은 함수까지 기억해야할까..?
FROM
    ANIMAL_INS;

-- 첫 풀이 (문제에서 의도한 방향이 아닌 듯 함)

-- SELECT
--     ANIMAL_ID,
--     NAME,
--     SUBSTRING(DATETIME, 1, 10) AS '날짜'
-- FROM
--     ANIMAL_INS;
