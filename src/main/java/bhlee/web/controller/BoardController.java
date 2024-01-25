package bhlee.web.controller;

import bhlee.web.model.board.BoardDAOImpl;
import bhlee.web.model.board.BoardDTO;
import bhlee.web.model.board.BoardDAO;
import bhlee.web.service.BoardService;
import bhlee.web.service.classes.BoardList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;
@Slf4j
@Controller
public class BoardController {

    private BoardDAO boardDAO;
    private BoardService boardService = new BoardService();

    public void setBoardDAO(BoardDAOImpl boardDAO) {this.boardDAO = boardDAO;}
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model) {
        return "index";
    }
    @RequestMapping(value = "/board-list", method = RequestMethod.GET)
    @ResponseBody
    public BoardList getBoard() {
        BoardList ret = boardService.getBoards(boardDAO, 1);
        return ret;
    }


}
