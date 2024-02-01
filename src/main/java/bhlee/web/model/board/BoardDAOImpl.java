package bhlee.web.model.board;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class BoardDAOImpl implements BoardDAO {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int add(BoardDTO boardDTO) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement psmt = con.prepareStatement(
                        "INSERT INTO board (title, writer, board_detail, create_at, update_at) VALUES (?, ?, ?, ?, ?)",
                        new String[]{"id"}
                );
                psmt.setString(1, boardDTO.getTitle());
                psmt.setString(2, boardDTO.getWriter());
                psmt.setString(3, boardDTO.getBoard_detail());
                psmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
                psmt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
                return psmt;
            }
        }, keyHolder);
        Number number = keyHolder.getKey();
        return number.intValue();
    }

    @Override
    public List<BoardDTO> getBoardList(int rowCount, int page) {
        int offset = (page-1) * rowCount;
        List<BoardDTO> boardList = (List<BoardDTO>) jdbcTemplate.query(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement psmt = con.prepareStatement(
                                "SELECT pk, writer, title, create_at FROM board ORDER BY create_at DESC LIMIT ? OFFSET ?"
                        );
                        psmt.setInt(1, rowCount);
                        psmt.setInt(2, offset);
                        return psmt;
                    }
                }, new RowMapper<BoardDTO>() {
                    public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        BoardDTO boardDTO = new BoardDTO();
                        boardDTO.setPk(rs.getInt("pk"));
                        boardDTO.setWriter(rs.getString("writer"));
                        boardDTO.setTitle(rs.getString("title"));
                        boardDTO.setCreate_at(rs.getTimestamp("create_at").toLocalDateTime());
                        return boardDTO;
                    }
                });
        return boardList;
    }

    @Override
    public BoardDTO getBoardByPk(int pk) {
        BoardMapper boardMapper = new BoardMapper();
        BoardDTO boardDTO = (BoardDTO) jdbcTemplate.query(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement psmt = con.prepareStatement(
                                "SELECT * FROM board WHERE pk = ?"
                        );
                        psmt.setInt(1, pk);
                        return psmt;
                    }
                }, boardMapper);
        return boardDTO;
    }

    @Override
    public int totalCount() {
        return jdbcTemplate.query(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement psmt = con.prepareStatement(
                                "SELECT COUNT(*) FROM board"
                        );
                        return psmt;
                    }
                }, new ResultSetExtractor<Integer>() {
                    @Override
                    public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                        rs.next();
                        return rs.getInt(1);
                    }
                });
    }
}
