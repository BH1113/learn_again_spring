package bhlee.web.model.board;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/dispatcher.xml"})
public class BoardDAOTest {

    @Autowired
    private BoardDAO boardDAO;

    @Test
    @Transactional
    @Rollback
    public void testAddSuccess() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoard_detail("Test");
        boardDTO.setWriter("Test writer_6");
        boardDTO.setTitle("test Title_6");
        int result = boardDAO.add(boardDTO);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void testAddFailed() {
        BoardDTO boardDTO = new BoardDTO();
        try {
            int result = boardDAO.add(boardDTO);
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    @Transactional
    @Rollback
    public void testSelectSuccess() {
        int beforeAdd = boardDAO.totalCount();
        if (beforeAdd > 25) {
            beforeAdd = 25;
        } else {
            beforeAdd+=1;
        }
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoard_detail("Test");
        boardDTO.setWriter("Test writer");
        boardDTO.setTitle("test Title");

        boardDAO.add(boardDTO);
        List<BoardDTO> boards = boardDAO.getBoardList(25, 1);

        Assert.assertEquals(beforeAdd, boards.size());
    }

    @Test
    @Transactional
    @Rollback
    public void testSelectFailed() {
        try {
            List<BoardDTO> boards = boardDAO.getBoardList(25, -1);
        } catch (Exception e) {
            Assert.assertEquals(BadSqlGrammarException.class, e.getClass());
        }
    }

    @Test
    @Transactional
    @Rollback
    public void testTotalCount() {
        int beforeAdd = boardDAO.totalCount();
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoard_detail("Test");
        boardDTO.setWriter("Test writer");
        boardDTO.setTitle("test Title");
        boardDAO.add(boardDTO);

        int result = boardDAO.totalCount();
        Assert.assertEquals(beforeAdd+1, result);
    }
}