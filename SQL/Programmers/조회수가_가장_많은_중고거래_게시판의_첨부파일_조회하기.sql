SELECT
    CONCAT(
        '/home/grep/src/',
        F.BOARD_ID,
        '/',
        F.FILE_ID,
        F.FILE_NAME,
        F.FILE_EXT
    ) AS FILE_PATH
FROM
    USED_GOODS_BOARD AS B
    JOIN USED_GOODS_FILE AS F ON B.BOARD_ID = F.BOARD_ID
WHERE
    B.VIEWS = (
        SELECT
            MAX(VIEWS)
        FROM
            USED_GOODS_BOARD
    )
ORDER BY
    F.FILE_ID DESC;

-- 첫 풀이 (CONCAT이 파라미터를 여러 개 받을 수 있는지 몰랐음...)
--
-- SELECT
--     CONCAT(CONCAT(CONCAT(CONCAT(CONCAT('/home/grep/src/', B.BOARD_ID), '/'), F.FILE_ID), F.FILE_NAME), F.FILE_EXT) AS FILE_PATH
-- FROM
--     USED_GOODS_BOARD AS B
--     JOIN USED_GOODS_FILE AS F ON B.BOARD_ID = F.BOARD_ID
-- WHERE
--     B.VIEWS = (
--         SELECT
--             MAX(VIEWS)
--         FROM
--             USED_GOODS_BOARD
--     )
-- ORDER BY
--     F.FILE_ID DESC;
