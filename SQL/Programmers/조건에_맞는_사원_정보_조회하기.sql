SELECT
    SUM(G.SCORE) AS SCORE,
    E.EMP_NO,
    E.EMP_NAME,
    E.POSITION,
    E.EMAIL
FROM
    HR_EMPLOYEES AS E
    JOIN HR_GRADE AS G ON E.EMP_NO = G.EMP_NO
WHERE
    G.YEAR = 2022
GROUP BY
    E.EMP_NO, -- `E.EMP_NO`만 써도 정답 처리가 되지만, `ONLY_FULL_GROUP_BY` 설정 고려 + 공부하는 입장이니 최대한 원칙대로 작성
    E.EMP_NAME,
    E.POSITION,
    E.EMAIL
ORDER BY
    SCORE DESC
LIMIT
    1;

-- 문제가 좀 별로다..
--
-- 주어진 테이블은 `HR_DEPARTMENT`, `HR_EMPLOYEES`, `HR_GRADE` 3개인데
-- 이중 `HR_DEPARTMENT`는 쓸 일이 없다
