package com.proj_board.article.service;

import com.proj_board.article.domain.ArticleDto;
import java.util.List;

public interface ArticleService {

  void create(ArticleDto articleDto) throws Exception;
  ArticleDto read(Integer articleNo) throws Exception;
  void update(ArticleDto articleDto) throws Exception;
  void delete(Integer articleNo) throws Exception;
  List<ArticleDto> listAll() throws Exception;


}
