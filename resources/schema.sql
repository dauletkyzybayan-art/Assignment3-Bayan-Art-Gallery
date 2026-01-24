CREATE TABLE artworks1 (
  art_id INT PRIMARY KEY,
  art_name VARCHAR(50) NOT NULL,
  art_author VARCHAR(100) NOT NULL,
  art_date VARCHAR(20) NOT NULL,
  art_price NUMERIC(10,2) NOT NULL,
  art_status VARCHAR(1) DEFAULT 'F'
);

CREATE TABLE customers1 (
  customer_id INT PRIMARY KEY,
  customer_name VARCHAR(50) NOT NULL,
  customer_balance NUMERIC(10,2) DEFAULT 0
);

CREATE TABLE sales1 (
  sale_id INT PRIMARY KEY,
  art_id INT NOT NULL,
  customer_id INT NOT NULL,
  sale_date DATE NOT NULL,
  sale_price NUMERIC(10,2) NOT NULL
);

INSERT INTO artworks1 VALUES
(1, 'Starry Night', 'Vincent van Gogh', '1889-06-01', 1500000.00),
(2, 'Mona Lisa', 'Leonardo da Vinci', '1503-01-01', 7800000.00),
(3, 'The Scream', 'Edvard Munch', '1893-01-01', 2300000.00),
(4, 'Guernica', 'Pablo Picasso', '1937-01-01', 3100000.00),
(5, 'The Kiss', 'Gustav Klimt', '1908-01-01', 1800000.00),
(6, 'Girl with a Pearl Earring', 'Johannes Vermeer', '1665-01-01', 1200000.00),
(7, 'The Last Supper', 'Leonardo da Vinci', '1498-01-01', 5000000.00),
(8, 'American Gothic', 'Grant Wood', '1930-01-01', 900000.00),
(9, 'The Birth of Venus', 'Sandro Botticelli', '1486-01-01', 2600000.00),
(10, 'Water Lilies', 'Claude Monet', '1916-01-01', 1400000.00);

INSERT INTO customers1 VALUES
(1, 'Alikhan Nurzhanov', 5000000.00),
(2, 'Aigerim Tulegenova', 2500000.00),
(3, 'Nursultan Kassymov', 1800000.00),
(4, 'Daniyar Seitov', 3200000.00),
(5, 'Aruzhan Mukhamedova', 900000.00),
(6, 'Erlan Abdrakhmanov', 4100000.00),
(7, 'Zhanel Omarova', 1500000.00),
(8, 'Timur Sagyndykov', 600000.00),
(9, 'Assel Kenzhebaeva', 2750000.00),
(10, 'Bekzat Aliev', 3500000.00);