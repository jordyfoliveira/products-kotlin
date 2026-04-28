ALTER TABLE products
ALTER COLUMN updated_at DROP NOT NULL;

UPDATE products
SET updated_at = NULL
WHERE updated_at::text LIKE '%T%';