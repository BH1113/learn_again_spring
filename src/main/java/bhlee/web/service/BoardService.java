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
    public BoardList getBoards(BoardDAO boardDAO, int page) {
        List<BoardDTO> getAll = boardDAO.getBoards(rowCount, 1);
        int totalCount = boardDAO.totalCount();
        Paging paging = common.pageCal(page, totalCount, rowCount, maxPageViewCount);
        BoardList retList = new BoardList(getAll, paging);
        return retList;
    }
}
