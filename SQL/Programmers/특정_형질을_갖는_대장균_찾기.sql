SELECT
    COUNT(ID) AS COUNT
FROM
    ECOLI_DATA
WHERE
    (GENOTYPE & b'0010') = 0
    -- AND (
    --     (GENOTYPE & b'0001') != 0
    --     OR (GENOTYPE & b'0100') != 0
    -- );
    AND (GENOTYPE & b'0101') != 0;

-- 이진 리터럴은 b'000010101' 형태로 나타낸다!
-- B'000010101' 이나 0b000010101 도 가능
