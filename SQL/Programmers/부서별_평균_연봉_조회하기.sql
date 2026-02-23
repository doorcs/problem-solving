SELECT
    D.DEPT_ID,
    D.DEPT_NAME_EN,
    ROUND(AVG(E.SAL), 0) AS AVG_SAL -- ROUND(값, 반올림 후에 남길 소수점 자릿수)
FROM
    HR_DEPARTMENT AS D
    JOIN HR_EMPLOYEES AS E ON D.DEPT_ID = E.DEPT_ID
GROUP BY
    D.DEPT_ID,
    D.DEPT_NAME_EN
ORDER BY
    3 DESC;

-- ORDER BY에서 정확한 값 대신 `SELECT절에서 나온 순서`를 쓰는건 SQL 표준이지만, GROUP BY에서는 아니다! (MySQL에서 지원하긴 함)
