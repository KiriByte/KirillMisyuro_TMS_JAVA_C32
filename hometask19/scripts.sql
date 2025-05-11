-- 1) Создание произвольной таблицы
CREATE TABLE IF NOT EXISTS app_user(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    datebirth DATE
);

-- 3) Вставка записи
INSERT INTO app_user(first_name, last_name, datebirth)
VALUES
    ('jane', 'doe', '2000-01-01'),
    ('hoshimi', 'miyabi', '2010-01-01'),
    ('asaba', 'harumasa', '2001-01-01'),
    ('anby', 'demara', '2002-01-01'),
    ('astra', 'yao', '2005-01-01');

-- title: All Users
SELECT * FROM app_user;

-- 4) Обновление записи
UPDATE app_user
SET datebirth = datebirth + INTERVAL '1 year'
WHERE age(datebirth) > INTERVAL '20 years';

-- title: Users after update
SELECT * FROM app_user;

-- 5) Получение определенной колонки записей в бд
-- title: last_name ends 'a'
SELECT first_name, last_name FROM app_user
WHERE last_name LIKE '%a';

-- 6) Удаление всех записей
DELETE FROM app_user;

-- title: empty table
SELECT * FROM app_user;

-- 2) Удаление данной таблицы
DROP TABLE IF EXISTS app_user;