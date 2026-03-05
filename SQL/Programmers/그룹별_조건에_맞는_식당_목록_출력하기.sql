WITH CTE AS (
    SELECT
        MEMBER_ID,
        COUNT(REVIEW_ID) AS CNT
    FROM
        REST_REVIEW
    GROUP BY
        MEMBER_ID
)

SELECT
    P.MEMBER_NAME,
    R.REVIEW_TEXT,
    DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM
    MEMBER_PROFILE AS P
    JOIN REST_REVIEW AS R ON P.MEMBER_ID = R.MEMBER_ID
    -- JOIN REST_REVIEW AS R USING(MEMBER_ID)
WHERE
    R.MEMBER_ID IN (
        SELECT
            MEMBER_ID
        FROM
            CTE
        WHERE
            CNT = (SELECT MAX(CNT) FROM CTE)
    )
ORDER BY
    R.REVIEW_DATE ASC,
    R.REVIEW_TEXT ASC;

-- 첫 풀이

-- SELECT
--     P.MEMBER_NAME,
--     R.REVIEW_TEXT,
--     DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
-- FROM
--     MEMBER_PROFILE AS P
--     JOIN REST_REVIEW AS R USING(MEMBER_ID)
--     -- JOIN REST_REVIEW AS R ON P.MEMBER_ID = R.MEMBER_ID
-- WHERE
--     MEMBER_ID IN ( -- JOIN 할 때 `USING()`을 쓰면 `P.MEMBER_ID` 나 `R.MEMBER_ID` 대신 `MEMBER_ID`로 쓸 수 있다
--         SELECT
--             MEMBER_ID
--         FROM
--             REST_REVIEW
--         GROUP BY
--             MEMBER_ID
--         HAVING
--             COUNT(REVIEW_ID) = (
--                 SELECT
--                     COUNT(REVIEW_ID)
--                 FROM
--                     REST_REVIEW
--                 GROUP BY
--                     MEMBER_ID
--                 ORDER BY
--                     COUNT(REVIEW_ID) DESC
--                 LIMIT 1
--             )
--     )
-- ORDER BY
--     R.REVIEW_DATE ASC,
--     R.REVIEW_TEXT ASC;
