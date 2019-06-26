package com.proj_board.article.controller;

import com.proj_board.article.domain.ArticleDto;
import com.proj_board.article.service.ArticleService;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/article")
public class ArticleController {

  private static final Logger logger = (Logger) LoggerFactory.getLogger(ArticleController.class);

  private final ArticleService articleService;

  @Inject
  public ArticleController(ArticleService articleService) {
    this.articleService = articleService;
  }

  // 등록 페이지 이동
  @RequestMapping(value = "/write", method = RequestMethod.GET)
  public String writeGet() {
    logger.info("write GET...");
    return "/article/write";
  }

  // 등록 처리
  // RedirectAttributes 객체의 addFlashAttribute() 를 이용해 처리가 성공적으로 이루어 진 것을 알리기 위해,
  // regSuccess 메시지를 String 객체로 전달한다.
  @RequestMapping(value = "/write", method = RequestMethod.GET)
  public String writePOST(ArticleDto articleDto,
      RedirectAttributes redirectAttributes) throws Exception {

    logger.info("write POST...");
    logger.info(articleDto.toString());
    articleService.create(articleDto);
    redirectAttributes.addFlashAttribute("msg", "regSuccess");

    return "redirect:/article/list";
  }

  // 목록 페이지 이동
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list(Model model) throws Exception {
    logger.info("list...");
    model.addAttribute("articles", articleService.listAll());

//    ModelAndView andView = new ModelAndView("/article/list");
//    andView.addObject("list", articleService.listAll());
//    return andView;

    return "/article/list";
  }

  // 조회 페이지 이동.
  // (articleNo)를 파라미터로 읽어서 int articleNo 에 넣고,
  @RequestMapping(value = "/read", method = RequestMethod.GET)
  public String read(@RequestParam("articleNo") int articleNo,
      Model model) throws Exception {

    logger.info("read...");
    model.addAttribute("article", articleService.read(articleNo));

    return "/article/read";
  }

  // 수정
  @RequestMapping(value = "/modify", method = RequestMethod.GET)
  public String modifyGET(@RequestParam("articleNo") int articleNo,
      Model model) throws Exception {

    logger.info("modifyGET...");
    model.addAttribute("article", articleService.read(articleNo));

    return "/article/modify";
  }

  // 수정 처리
  @RequestMapping(value = "/modify", method = RequestMethod.GET)
  public String modifyPOST(ArticleDto articleDto,
      RedirectAttributes redirectAttributes) throws Exception {

    logger.info("modifyPOST...");
    articleService.update(articleDto);
    redirectAttributes.addFlashAttribute("msg", "modSuccess");

    return "redirect:/article/list";
  }

  // 삭제
  @RequestMapping(value = "/remove", method = RequestMethod.GET)
  public String remove(@RequestParam("articleNo") int articleNo,
      RedirectAttributes redirectAttributes) throws Exception {

    logger.info("remove...");
    articleService.delete(articleNo);
    redirectAttributes.addFlashAttribute("msg", "delSuccess");

    return "redirect:/article/list";
  }

}
