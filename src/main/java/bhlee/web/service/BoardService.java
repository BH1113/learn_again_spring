package bhlee.web.service;

import bhlee.web.model.board.BoardDAO;
import bhlee.web.model.board.BoardDTO;
import bhlee.web.service.classes.BoardList;
import bhlee.web.util.Common;
import bhlee.web.util.classes.Paging;
import bhlee.web.util.impl.CommonImpl;

import java.util.List;

public class BoardService {
    protected Common common = new CommonImpl();
    protected final int rowCount = 25;
    protected final int maxPageViewCount = 5;
    public BoardList getBoardsList(BoardDAO boardDAO, int page) {
        List<BoardDTO> getAll = boardDAO.getBoardList(rowCount, page);
        int totalCount = boardDAO.totalCount();
        Paging paging = common.pageCal(page, totalCount, rowCount, maxPageViewCount);
        return new BoardList(getAll, paging);
    }

    public void insertBoard(BoardDAO boardDAO, String title, String writer, String board_detail) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle(title);
        boardDTO.setWriter(writer);
        boardDTO.setBoard_detail(board_detail);
        boardDAO.add(boardDTO);
    }
}
