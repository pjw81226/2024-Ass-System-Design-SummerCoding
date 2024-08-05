package org.landvibe.ass1;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieESRepository extends ElasticsearchRepository<Movie, String> {
    List<Movie> findByTitle(String title);
}
