CREATE TABLE Book
(
    id     UUID PRIMARY KEY,
    title  VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    genre  VARCHAR(255),
    isbn   VARCHAR(255),
    status VARCHAR(255)
);

CREATE TABLE Member
(
    id      UUID PRIMARY KEY,
    name    VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    phone   VARCHAR(50),
    email   VARCHAR(255)
);

CREATE TABLE Loan
(
    id        UUID PRIMARY KEY,
    book_id   UUID,
    member_id UUID,
    loan_date date,
    due_date  date,
    status    VARCHAR(255),
    FOREIGN KEY (book_id) REFERENCES Book (id) ON DELETE CASCADE,
    FOREIGN KEY (member_id) REFERENCES Member (id) ON DELETE CASCADE
);
