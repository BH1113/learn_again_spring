package bhlee.web.util;

import bhlee.web.util.classes.Paging;

public interface Common {
    public abstract Paging pageCal(int _currentPage, int _totalCount, int _rowCount, int _maxPageViewCount);
}
