package bhlee.web.model.board;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardDAO {
    public abstract int add(BoardDTO boardDTO);
    public abstract List<BoardDTO> getBoards(int rowCount, int page);
    public abstract BoardDTO getBoard(int pk);
    public abstract int totalCount();

}
