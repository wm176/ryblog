package com.yinruiyang.ryblog.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createTime;
    
}