package com.study.communitypractice2.repository;

import com.study.communitypractice2.entity.Article;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ArticleRepositoryTest {

    @Autowired
    ArticleRepository repository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testArticle() {
        Article article = new Article(null, "aaa", "hi", "realA", "Hello", null);

        repository.save(article);
        Article findArticle = repository.findByTitle(article.getTitle());


        assertEquals(findArticle.getId(), article.getId());
        assertEquals(findArticle.getUserid(), article.getUserid());
        assertEquals(findArticle, article);
    }

}