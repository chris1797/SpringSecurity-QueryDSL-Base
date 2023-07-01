package com.security.demo.service;

import com.security.demo.domain.Article;
import com.security.demo.repository.ArticleQueryRepository;
import com.security.demo.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleQueryRepository articleQueryRepository;


    @Override
    @Transactional
    public void deleteArticle(Long article_idx) {
        articleRepository.deleteById(article_idx);
    }

    @Override
    @Transactional
    public Article getArticleDetail(Long article_idx) {
        Article article = articleRepository.findById(article_idx)
                .orElseThrow(() -> new NullPointerException("This article does not exist."));
        return article;
    }

    @Override
    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }

    @Override
    @Transactional
    public Long writeArticle(Article article) {
        return articleRepository.save(article).getArticle_idx();
    }


}
