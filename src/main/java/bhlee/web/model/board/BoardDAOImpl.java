package bhlee.web.model.board;


import com.mysql.cj.xdevapi.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public int add(BoardVO boardVO) {
        return 1;
    }
}
