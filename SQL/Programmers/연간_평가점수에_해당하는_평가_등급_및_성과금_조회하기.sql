SELECT
    E.EMP_NO,
    E.EMP_NAME,
    CASE
        WHEN AVG(SCORE) >= 96 THEN 'S'
        WHEN AVG(SCORE) >= 90 THEN 'A'
        WHEN AVG(SCORE) >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    E.SAL * (
        CASE
            WHEN AVG(SCORE) >= 96 THEN 0.2 -- SAL에 {20, 15, 10}을 곱하고 100으로 나눠주는 대신에 소수 리터럴 사용
            WHEN AVG(SCORE) >= 90 THEN 0.15
            WHEN AVG(SCORE) >= 80 THEN 0.1 -- 실전에서 안 떠오르면 일단 주어진 수치 그대로 곱하고 100으로 나눠주기
            ELSE 0
        END
    ) AS BONUS
FROM
    HR_EMPLOYEES AS E
    JOIN HR_GRADE AS G ON E.EMP_NO = G.EMP_NO
GROUP BY
    E.EMP_NO,
    E.EMP_NAME
ORDER BY
    E.EMP_NO ASC;

-- `GROUP BY`를 쓸 때는 CASE문을 못 쓰는줄 알았는데, `WHEN`, `THEN`을 올바르게 쓰면 문제 없다!!
--
-- `WHEN` 조건에 칼럼이 직접 참조되지 않고 지금처럼 집계함수에 감싸져 있으면 갠춘
-- `THEN`절에서도 직접 칼럼 참조가 없고 모두 리터럴(값)이므로 갠춘
--
-- 첫 풀이 (CTE)
--
-- WITH AVG_SCORE AS (
--     SELECT
--         EMP_NO,
--         AVG(SCORE) AS SCORE
--     FROM
--         HR_GRADE
--     GROUP BY
--         EMP_NO
-- ), GRADE AS (
--     SELECT
--         EMP_NO,
--         CASE
--             WHEN SCORE >= 96 THEN 'S'
--             WHEN SCORE >= 90 THEN 'A'
--             WHEN SCORE >= 80 THEN 'B'
--             ELSE 'C'
--         END AS GRADE,
--         CASE
--             WHEN SCORE >= 96 THEN 20
--             WHEN SCORE >= 90 THEN 15
--             WHEN SCORE >= 80 THEN 10
--             ELSE 0
--         END AS BONUS
--     FROM
--         AVG_SCORE
-- )
--
-- SELECT
--     E.EMP_NO,
--     E.EMP_NAME,
--     G.GRADE,
--     (E.SAL * G.BONUS / 100) AS BONUS
-- FROM
--     HR_EMPLOYEES AS E
--     JOIN GRADE AS G ON E.EMP_NO = G.EMP_NO
-- GROUP BY
--     E.EMP_NO,
--     E.EMP_NAME
-- ORDER BY
--     E.EMP_NO ASC;
