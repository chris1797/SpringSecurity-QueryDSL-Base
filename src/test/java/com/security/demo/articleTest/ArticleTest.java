package com.security.demo.articleTest;

import com.security.demo.common.role.Role;
import com.security.demo.domain.Article;
import com.security.demo.domain.Member;
import com.security.demo.repository.ArticleQueryRepository;
import com.security.demo.repository.ArticleRepository;
import com.security.demo.repository.MemberQueryRepository;
import com.security.demo.repository.MemberRepository;
import com.security.demo.service.ArticleService;
import com.security.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.security.demo.common.role.Role.REALTOR;
import static com.security.demo.common.role.Role_withdraw.ACTIVE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional(rollbackFor = Exception.class)
public class ArticleTest {

    @InjectMocks
    ArticleService articleService;

    @Mock
    private ArticleRepository articleRepository;


    @After
    public void afterTest() throws Exception {
        articleRepository.deleteAllInBatch();
    }


    @Test
    @Transactional
    @DisplayName("리스트 테스트")
    public void getArticleListTest() {
        List<Article> list = articleService.getAllArticle();

        assertEquals(list.get(0).getTitle(), "text");
    }
}