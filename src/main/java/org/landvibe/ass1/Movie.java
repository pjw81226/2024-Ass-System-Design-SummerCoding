package org.landvibe.ass1;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@Document(indexName="movies")
public class Movie {
    private int id;
    private String title;
    private String genres;
}
