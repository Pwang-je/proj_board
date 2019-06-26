package com.proj_board.article.service;

import com.proj_board.article.domain.ArticleDto;
import com.proj_board.article.persistance.ArticleDao;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

  private final ArticleDao articleDao;

  @Inject
  public ArticleServiceImpl(ArticleDao articleDao) {
    this.articleDao = articleDao;
  }

  @Override
  public void create(ArticleDto articleDto) throws Exception {
    articleDao.create(articleDto);
  }

  @Override
  public ArticleDto read(Integer articleNo) throws Exception {
    return articleDao.read(articleNo);
  }

  @Override
  public void update(ArticleDto articleDto) throws Exception {
    articleDao.update(articleDto);
  }

  @Override
  public void delete(Integer articleNo) throws Exception {
    articleDao.delete(articleNo);
  }

  @Override
  public List<ArticleDto> listAll() throws Exception {
    return articleDao.listAll();
  }
}
