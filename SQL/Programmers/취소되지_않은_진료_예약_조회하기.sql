SELECT
    A.APNT_NO,
    P.PT_NAME,
    A.PT_NO,
    A.MCDP_CD,
    D.DR_NAME,
    A.APNT_YMD
FROM
    APPOINTMENT AS A
    JOIN PATIENT AS P ON A.PT_NO = P.PT_NO -- JOIN이 여러 개일땐 각 JOIN마다 ON 절을 써주기
    JOIN DOCTOR AS D ON A.MDDR_ID = D.DR_ID
WHERE
    A.MCDP_CD = 'CS'
    AND DATE(A.APNT_YMD) = '2022-04-13'
    AND A.APNT_CNCL_YN = 'N'
ORDER BY
    A.APNT_YMD ASC;

-- 첫 풀이 (
--     각 JOIN마다 ON절을 명시해주지 않음,
--     예약 당일 이후에 취소된 건까지 포함하는건 너무 overthinking,
--     DATE() 함수로 해결할 수 있는데 괜히 복잡하게 DATEDIFF()를 사용함
-- )
--
-- SELECT
--     A.APNT_NO,
--     P.PT_NAME,
--     A.PT_NO,
--     A.MCDP_CD,
--     D.DR_NAME,
--     A.APNT_YMD
-- FROM
--     APPOINTMENT AS A
--     JOIN PATIENT AS P
--     JOIN DOCTOR AS D ON A.PT_NO = P.PT_NO AND A.MDDR_ID = D.DR_ID
-- WHERE
--     A.MCDP_CD = 'CS'
--     AND DATEDIFF(A.APNT_YMD, '2022-04-13') = 0
--     AND (
--         A.APNT_CNCL_YN = 'N'
--         OR DATEDIFF(A.APNT_CNCL_YMD, '2022-04-13') > 0
--     )
-- ORDER BY
--     6 ASC;
