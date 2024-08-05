package org.landvibe.ass1;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovieRDBRepository {
    private final JdbcTemplate jdbcTemplate;


    public List<Movie> getMovieByTitle(String title) {
        String sql = "SELECT * FROM movies WHERE title LIKE ?";
        String searchTitle = "%" + title + "%";
        return jdbcTemplate.query(sql, new Object[]{searchTitle}, new MovieRowMapper());
    }

    class MovieRowMapper implements RowMapper<Movie> {
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie movie = new Movie();
            movie.setId(rs.getInt("id"));
            movie.setTitle(rs.getString("title"));
            movie.setGenres(rs.getString("genres"));
            return movie;
        }
    }
}
