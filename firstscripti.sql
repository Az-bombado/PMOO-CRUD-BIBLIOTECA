-- Visualização das tabelas

select * from autores
select * from livro
select * from usuario
select * from emprestimo

-- updats rapidos

UPDATE usuario
SET permissao = 'LEITOR'
WHERE id IN (4, 5, 6);

-- primeiro adm para logar e criar um novo usuario 

insert into usuario (email, nome, senha, permissao, dtype)
values ('Admin_Ti_boss@gmail.com', 'Leon', 'Admin123', 'Administrador', 'Administrador')

-- colonizando a tabela livros (50 livros diversos)

INSERT INTO livro (isbn, nome, autores, lancamento) VALUES
('9788535902778', 'Dom Casmurro', 'Machado de Assis', '1899-01-01'),
('9788525406958', 'Memórias Póstumas de Brás Cubas', 'Machado de Assis', '1881-01-01'),
('9788535914849', 'O Cortiço', 'Aluísio Azevedo', '1890-01-01'),
('9788503012303', 'Capitães da Areia', 'Jorge Amado', '1937-01-01'),
('9788535920505', 'Vidas Secas', 'Graciliano Ramos', '1938-01-01'),
('9788535922189', 'São Bernardo', 'Graciliano Ramos', '1934-01-01'),
('9788535930269', 'Iracema', 'José de Alencar', '1865-01-01'),
('9788535930276', 'Senhora', 'José de Alencar', '1875-01-01'),
('9788520931127', 'A Hora da Estrela', 'Clarice Lispector', '1977-01-01'),
('9788520931134', 'Perto do Coração Selvagem', 'Clarice Lispector', '1943-01-01'),

('9780061120084', 'To Kill a Mockingbird', 'Harper Lee', '1960-07-11'),
('9780451524935', '1984', 'George Orwell', '1949-06-08'),
('9780451526342', 'Animal Farm', 'George Orwell', '1945-08-17'),
('9780743273565', 'The Great Gatsby', 'F. Scott Fitzgerald', '1925-04-10'),
('9780316769488', 'The Catcher in the Rye', 'J. D. Salinger', '1951-07-16'),
('9780141439518', 'Pride and Prejudice', 'Jane Austen', '1813-01-28'),
('9780140449136', 'The Odyssey', 'Homer', '1996-11-01'),
('9780140449181', 'The Iliad', 'Homer', '1998-05-01'),
('9780141439600', 'Jane Eyre', 'Charlotte Brontë', '1847-10-16'),
('9780141439556', 'Wuthering Heights', 'Emily Brontë', '1847-12-01'),

('9780544003415', 'The Hobbit', 'J. R. R. Tolkien', '1937-09-21'),
('9780618640157', 'The Fellowship of the Ring', 'J. R. R. Tolkien', '1954-07-29'),
('9780618640188', 'The Two Towers', 'J. R. R. Tolkien', '1954-11-11'),
('9780618640195', 'The Return of the King', 'J. R. R. Tolkien', '1955-10-20'),
('9780553386790', 'A Game of Thrones', 'George R. R. Martin', '1996-08-06'),

('9780439708180', 'Harry Potter and the Sorcerers Stone', 'J. K. Rowling', '1997-06-26'),
('9780439064873', 'Harry Potter and the Chamber of Secrets', 'J. K. Rowling', '1998-07-02'),
('9780439136365', 'Harry Potter and the Prisoner of Azkaban', 'J. K. Rowling', '1999-07-08'),
('9780439139601', 'Harry Potter and the Goblet of Fire', 'J. K. Rowling', '2000-07-08'),
('9780439358071', 'Harry Potter and the Order of the Phoenix', 'J. K. Rowling', '2003-06-21'),

('9780062315007', 'Sapiens', 'Yuval Noah Harari', '2011-01-01'),
('9780062464316', 'Homo Deus', 'Yuval Noah Harari', '2015-01-01'),
('9780307387899', 'The Road', 'Cormac McCarthy', '2006-09-26'),
('9780307277671', 'The Kite Runner', 'Khaled Hosseini', '2003-05-29'),
('9781594631931', 'The Book Thief', 'Markus Zusak', '2005-03-14'),

('9780060850524', 'Brave New World', 'Aldous Huxley', '1932-01-01'),
('9780140283334', 'Lord of the Flies', 'William Golding', '1954-09-17'),
('9780141182803', 'Crime and Punishment', 'Fyodor Dostoevsky', '1866-01-01'),
('9780140449266', 'War and Peace', 'Leo Tolstoy', '1869-01-01'),
('9780140449273', 'Anna Karenina', 'Leo Tolstoy', '1878-01-01'),

('9780553213119', 'Dracula', 'Bram Stoker', '1897-05-26'),
('9780486282114', 'Frankenstein', 'Mary Shelley', '1818-01-01'),
('9780141439518', 'Sense and Sensibility', 'Jane Austen', '1811-01-01'),
('9780142437230', 'Moby Dick', 'Herman Melville', '1851-10-18'),
('9780142437247', 'The Scarlet Letter', 'Nathaniel Hawthorne', '1850-03-16'),

('9780134685991', 'Effective Java', 'Joshua Bloch', '2018-01-06'),
('9780132350884', 'Clean Code', 'Robert C. Martin', '2008-08-01'),
('9780201633610', 'Design Patterns', 'Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides', '1994-10-21'),
('9780134494166', 'Clean Architecture', 'Robert C. Martin', '2017-09-20'),
('9781491950357', 'Building Microservices', 'Sam Newman', '2015-02-20');