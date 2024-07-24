package org.landvibe.ass1.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.landvibe.ass1.domain.model.Book;
import org.landvibe.ass1.domain.repository.BookRepository;
import org.landvibe.ass1.infrastructure.persistence.entity.BookEntity;
import org.landvibe.ass1.infrastructure.persistence.entity.BookMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JdbcBookRepository implements BookRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Book> findBookById(Long id) {
        List<BookEntity> entityBooks = jdbcTemplate.query("SELECT * FROM book WHERE id = ?", new Object[]{id}, new BookEntityRowMapper());
        return entityBooks.isEmpty() ? Optional.empty() : Optional.of(BookMapper.toDomain(entityBooks.get(0)));
    }

    @Override
    public List<Book> findAllBooks(){
        List<BookEntity> entityBooks = jdbcTemplate.query("SELECT * FROM book", new BookEntityRowMapper());
        List<Book> books = new ArrayList<>();
        entityBooks.forEach(bookEntity -> books.add(BookMapper.toDomain(bookEntity)));
        return books;
    }

    @Override
    public int save(Book book){
        BookEntity bookEntity = BookMapper.toEntity(book);
        return jdbcTemplate.update("Insert Into book (title) values (?)", bookEntity.getTitle());
    }

    @Override
    public int update(String title, Long id){
        return jdbcTemplate.update("UPDATE book SET title = ? WHERE id = ?", title, id);
    }

    private static class BookEntityRowMapper implements RowMapper<BookEntity> {
        @Override
        public BookEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return BookEntity.builder()
                    .id(rs.getLong("id"))
                    .title(rs.getString("title"))
                    .build();
        }
    }
}
