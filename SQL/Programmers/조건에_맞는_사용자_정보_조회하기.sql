SELECT
    USER_ID,
    NICKNAME,
    CONCAT(
        CITY,
        ' ',
        STREET_ADDRESS1,
        ' ',
        STREET_ADDRESS2
    ) AS "전체주소",
    CONCAT(
        SUBSTRING(TLNO, 1, 3),
        '-',
        SUBSTRING(TLNO, 4, 4),
        '-',
        SUBSTRING(TLNO, 8)
    ) AS "전화번호"
FROM
    USED_GOODS_USER
WHERE
    USER_ID IN (
        SELECT
            WRITER_ID
        FROM
            USED_GOODS_BOARD
        GROUP BY
            WRITER_ID
        HAVING
            COUNT(*) >= 3
    )
ORDER BY
    USER_ID DESC;

-- 첫 풀이 (서브쿼리 내 불필요한 JOIN 사용, 외부 쿼리에서도 불필요한 GROUP BY 사용)
--
-- SELECT
--     USER_ID,
--     NICKNAME,
--     CONCAT(
--         CITY,
--         ' ',
--         STREET_ADDRESS1,
--         ' ',
--         STREET_ADDRESS2
--     ) AS "전체주소",
--     CONCAT(
--         SUBSTRING(TLNO, 1, 3),
--         '-',
--         SUBSTRING(TLNO, 4, 4),
--         '-',
--         SUBSTRING(TLNO, 8)
--     ) AS "전화번호"
-- FROM
--     USED_GOODS_USER
-- WHERE
--     USER_ID IN (
--         SELECT
--             U.USER_ID
--         FROM
--             USED_GOODS_BOARD AS B
--             JOIN USED_GOODS_USER AS U ON B.WRITER_ID = U.USER_ID
--         GROUP BY
--             U.USER_ID
--         HAVING
--             COUNT(BOARD_ID) >= 3
--     )
-- GROUP BY
--     USER_ID
-- ORDER BY
--     USER_ID DESC;
