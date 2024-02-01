package bhlee.web.controller;

import bhlee.web.model.board.BoardDAOImpl;
import bhlee.web.model.board.BoardDAO;
import bhlee.web.model.board.BoardDTO;
import bhlee.web.service.BoardService;
import bhlee.web.service.classes.BoardList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class BoardController {

    private BoardDAO boardDAO;
    private BoardService boardService = new BoardService();

    public void setBoardDAO(BoardDAOImpl boardDAO) {this.boardDAO = boardDAO;}
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String entries(Model model) {
        return "index";
    }
    @RequestMapping(value = "/board-list", method = RequestMethod.GET)
    @ResponseBody
    public BoardList getBoardList(@RequestParam("page") int selPage) {
        return boardService.getBoardsList(boardDAO, selPage);
    }

    @RequestMapping(value ="/board-content", method = RequestMethod.POST)
    @ResponseBody
    public boolean insertBoard(@RequestBody BoardDTO boardDTO) {
        boardService.insertBoard(boardDAO,boardDTO.getTitle(), boardDTO.getWriter(), boardDTO.getBoard_detail());
        return true;
    }
    // 테스트 시 CORS 에러 발생하여 method.options 응답하기 위해 이용
}
