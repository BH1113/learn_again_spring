package bhlee.web.model.board;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class BoardMapper implements RowMapper<BoardDTO> {
    @Override
    public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoard_detail(rs.getString("board_detail"));
        boardDTO.setTitle(rs.getString("title"));
        boardDTO.setWriter(rs.getString("writer"));
        boardDTO.setPk(rs.getInt("pk"));
        boardDTO.setCreate_at(rs.getTimestamp("create_at").toLocalDateTime());
        return boardDTO;
    }
}
