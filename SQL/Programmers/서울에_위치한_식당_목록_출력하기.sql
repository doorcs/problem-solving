SELECT
    I.REST_ID,
    I.REST_NAME,
    I.FOOD_TYPE,
    I.FAVORITES,
    I.ADDRESS,
    ROUND(AVG(R.REVIEW_SCORE), 2) AS SCORE -- ROUND(값, 반올림 후 남길 자릿수)
FROM
    REST_INFO AS I
    JOIN REST_REVIEW AS R ON I.REST_ID = R.REST_ID
WHERE
    I.ADDRESS LIKE '서울%' -- '%서울%' 이 아니다!!!
GROUP BY
    I.REST_ID
ORDER BY
    ROUND(AVG(R.REVIEW_SCORE), 2) DESC,
    I.FAVORITES DESC;

-- 소수점 세 번째 자리에서 반올림 -> 결과에는 소수점 두 자리까지 있어야하므로 `ROUND(val, 2)`
