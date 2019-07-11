package com.proj_board.article.persistance;

import com.proj_board.article.domain.ArticleDto;
import java.util.List;

public interface ArticleDao {

  void create(ArticleDto articleDto) throws Exception;
  ArticleDto read(Integer articleNo) throws Exception;
  void update(ArticleDto articleDto) throws Exception;
  void delete(Integer articleNo) throws Exception;
  List<ArticleDto> listAll() throws Exception;

  // 페이징 처리와 관련된 메서드 추가
  List<ArticleDto> listPaging(int page) throws Exception;

}


