package com.study.communitypractice2.entity;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    @NotEmpty
    private String userid;

    @Column(length = 10, nullable = false)
    @NotEmpty
    private String nickname;

    @Column(length = 30, nullable = false)
    @NotEmpty
    private String title;

    @Column(nullable = false)
    @NotEmpty
    private String content;

    @Column(nullable = true, updatable = false)
    @CreatedDate
    private LocalDateTime time;

    @PrePersist
    public void time() {
        this.time = LocalDateTime.now();
    }

}
