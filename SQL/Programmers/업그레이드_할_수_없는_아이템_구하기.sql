SELECT
    ITEM_ID,
    ITEM_NAME,
    RARITY
FROM
    ITEM_INFO
WHERE
    ITEM_ID NOT IN (
        SELECT DISTINCT
            PARENT_ITEM_ID
        FROM
            ITEM_TREE
        WHERE
            PARENT_ITEM_ID IS NOT NULL -- 이게 없으면 다 망가진다!! 항상 NULL 처리 조심
    )
ORDER BY
    ITEM_ID DESC;
