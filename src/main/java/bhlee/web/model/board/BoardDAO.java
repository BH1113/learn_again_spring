package bhlee.web.model.board;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardDAO {
    public abstract int add(BoardDTO boardDTO);
    public abstract List<BoardDTO> getBoardList(int rowCount, int page);
    public abstract BoardDTO getBoardByPk(int pk);
    public abstract int totalCount();
}
