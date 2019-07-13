package com.proj_board.article;

import com.proj_board.article.domain.ArticleDto;
import com.proj_board.article.persistance.ArticleDao;
import java.util.List;
import org.slf4j.Logger;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/spring-config/applicationContext.xml"})
public class ArticleDAOTest {

  private static final Logger logger = LoggerFactory.getLogger(ArticleDAOTest.class);

  @Inject
  private ArticleDao articleDao;

  @Test
  public void testCreate() throws Exception {
//    ArticleDto articleDto = new ArticleDto();
//    articleDto.setTitle("새로운 글 작성 테스트 제목임");
//    articleDto.setContent("내용 테스트");
//    articleDto.setWriter("새로운 글 작성자");

    for (int i = 1; i <= 1000; i++) {
      ArticleDto articleDto = new ArticleDto();
      articleDto.setTitle(i + "번째 글 제목");
      articleDto.setContent(i + "번째 글 내용");
      articleDto.setWriter("user0" + (i%10));

      articleDao.create(articleDto);
    }
//    articleDao.create(articleDto);
  }

  @Test
  public void testRead() throws Exception {
    logger.info(articleDao.read(1).toString());
  }

  @Test
  public void testUpdate() throws Exception {
    ArticleDto articleDto = new ArticleDto();
    articleDto.setArticleNo(1);
    articleDto.setTitle("글 수정 테스트 제목임");
    articleDto.setContent("글 수정 테스트");
    articleDao.update(articleDto);
  }

  @Test
  public void testDelete() throws Exception {
    articleDao.delete(1);
  }

  // paging control sql test;
  @Test
  public void testListPaging() throws Exception {

    int page = 3;

    List<ArticleDto> articleDtosList = articleDao.listPaging(page);

    for(ArticleDto articleDto : articleDtosList) {
      logger.info(articleDto.getArticleNo() + ":" + articleDto.getTitle());
    }
  }

}
