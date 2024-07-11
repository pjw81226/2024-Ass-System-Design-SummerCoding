package org.landvibe.ass1.infrastructure.persistence.entity;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookEntity {
    private Long id;
    private String title;
}
    /*
    jdbc 이용 할거라 굳이 있어야 하나 싶긴함.
    Domain 과 거의 동일
    그냥 계층 연습 겸 ,,,
     */