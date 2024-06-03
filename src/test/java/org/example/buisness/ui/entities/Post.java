package org.example.buisness.ui.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Post {
    private String title;
    private String author;
    private String category;
    private String tag;
    private String comment;
    private String date;

}
