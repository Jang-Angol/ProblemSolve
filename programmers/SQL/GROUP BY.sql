-- 고양이와 개는 몇마리 있을까
SELECT ANIMAL_TYPE, COUNT(ANIMAL_ID) as count 
FROM ANIMAL_INS 
WHERE ANIMAL_TYPE = "Cat" OR ANIMAL_TYPE = "Dog" 
GROUP BY ANIMAL_TYPE 
ORDER BY ANIMAL_TYPE;
-- 동명 동물 수 찾기
SELECT NAME, COUNT(ANIMAL_ID) as count 
FROM ANIMAL_INS 
GROUP BY NAME 
HAVING COUNT(NAME) > 1 
ORDER BY NAME;
-- 입양 시각 구하기(1)
select date_format(datetime, '%H') as 'HOUR', count('HOUR') as count
from animal_outs
group by HOUR
having HOUR between 9 and 20
order by HOUR