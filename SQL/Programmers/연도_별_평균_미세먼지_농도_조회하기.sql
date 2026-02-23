SELECT
    YEAR(YM) AS YEAR, -- EXTRACT(YEAR FROM YM)
    ROUND(AVG(PM_VAL1), 2) AS PM10,
    ROUND(AVG(PM_VAL2), 2) AS "PM2.5"
FROM
    AIR_POLLUTION
WHERE
    LOCATION2 = '수원'
GROUP BY
    YEAR(YM)
ORDER BY
    1 ASC;

-- ROUND(값, 반올림 후 소수점 아래에 남길 자릿수)
--
-- `a-zA-Z0-9_` 범위를 벗어나는 식별자는 Backtick(``) 또는 Double Quote("")로 감싸줘야 함!
-- ( `영문`, `숫자`, `언더스코어|언더바|로대시` )
