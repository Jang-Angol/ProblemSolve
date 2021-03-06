-- 없어진 기록 찾기 (left join)
SELECT ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.NAME 
FROM ANIMAL_OUTS 
LEFT JOIN ANIMAL_INS ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID 
WHERE ANIMAL_INS.ANIMAL_ID IS NULL;
-- 있었는데요 없었습니다 (outer join)
SELECT ANIMAL_OUTS.ANIMAL_ID, ANIMAL_OUTS.NAME 
FROM ANIMAL_OUTS 
INNER JOIN ANIMAL_INS ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID 
WHERE ANIMAL_OUTS.DATETIME < ANIMAL_INS.DATETIME 
ORDER BY ANIMAL_INS.DATETIME;
-- 오랜 기간 보호한 동물(1)
SELECT ANIMAL_INS.NAME, ANIMAL_INS.DATETIME 
FROM ANIMAL_INS 
LEFT JOIN ANIMAL_OUTS ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID 
WHERE ANIMAL_OUTS.ANIMAL_ID IS NULL 
ORDER BY ANIMAL_INS.DATETIME LIMIT 3;