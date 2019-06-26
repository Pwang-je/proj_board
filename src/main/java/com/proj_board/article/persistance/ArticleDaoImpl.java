package com.proj_board.article.persistance;

import com.proj_board.article.domain.ArticleDto;
import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDaoImpl implements ArticleDao {

  private static final String NAMESPACE = "com.proj_board.mappers.article.ArticleMapper";

  private final SqlSession sqlSession;

  @Inject
  public ArticleDaoImpl(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public void create(ArticleDto articleDto) throws Exception {
    sqlSession.insert(NAMESPACE + ".create", articleDto);
  }

  @Override
  public ArticleDto read(Integer articleNo) throws Exception {
    return sqlSession.selectOne(NAMESPACE + ".read", articleNo);
  }

  @Override
  public void update(ArticleDto articleDto) throws Exception {
    sqlSession.update(NAMESPACE + ".update", articleDto);
  }

  @Override
  public void delete(Integer articleNo) throws Exception {
    sqlSession.delete(NAMESPACE + ".delete", articleNo);
  }

  @Override
  public List<ArticleDto> listAll() throws Exception {
    return sqlSession.selectList(NAMESPACE + ".listAll");
  }

}
