package bhlee.web.service.classes;

import bhlee.web.model.board.BoardDTO;
import bhlee.web.util.classes.Paging;

import java.util.List;

public class BoardList {
    private List<BoardDTO> boardDTOList;
    private Paging paging;
    public BoardList(List<BoardDTO> boardDTOList, Paging paging) {
        this.paging = paging;
        this.boardDTOList = boardDTOList;
    }
    public List<BoardDTO> getBoardDTOList() {
        return boardDTOList;
    }
    public Paging getPaging() {
        return paging;
    }
}
