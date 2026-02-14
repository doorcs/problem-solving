SELECT
    I.ANIMAL_ID,
    I.NAME
FROM
    ANIMAL_INS AS I
    JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE
    I.DATETIME > O.DATETIME
ORDER BY
    I.DATETIME ASC;

-- 날짜가 빠르다? 느리다?
-- 정수형으로 변환했을 때, 수가 작은 게 더 빠르다
--
-- '2026-01-23'이 '2026-01-24'보다 빠르다
--
-- '연-월-일'까지 같다면, '11:23:45'가 '15:43:21'보다 빠르다
