package com.yinruiyang.ryblog.entity;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createTime;
    private List<Tag> tags = new ArrayList<>();
}