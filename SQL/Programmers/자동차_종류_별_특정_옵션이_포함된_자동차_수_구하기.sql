SELECT
    CAR_TYPE,
    COUNT(*) AS 'CARS'
FROM
    CAR_RENTAL_COMPANY_CAR
WHERE
    OPTIONS LIKE '%통풍시트%'
    OR OPTIONS LIKE '%열선시트%'
    OR OPTIONS LIKE '%가죽시트%'
GROUP BY
    CAR_TYPE
ORDER BY
    CAR_TYPE ASC;

-- 이렇게는 안 된다 (`OR`이나 `AND`는 조건식 단위로 연결해주기 때문)
--
-- WHERE
--     OPTIONS LIKE '%통풍시트%' OR '%열선시트%' OR '%가죽시트%'
--
-- 이렇게도 안 된다 (`IN`은 값이 완전히 일치할 때만 사용 가능하기 때문)
--
-- WHERE
--     OPTIONS IN ('%통풍시트%', '%열선시트%', '%가죽시트%')
