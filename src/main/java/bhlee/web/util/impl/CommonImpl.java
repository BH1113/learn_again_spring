package bhlee.web.util.impl;

import bhlee.web.util.Common;
import bhlee.web.util.classes.Paging;

public class CommonImpl implements Common {
    @Override
    public Paging pageCal(int _currentPage, int _totalCount, int _rowCount, int _maxPageViewCount) {
        Paging paging = new Paging();
        int startPage, endPage;

        // 전체 갯수 % 페이지당 갯수가 0 보다 크면 페이지 1추가, 아니면 추가없음
        int addPage = 1;
        if (_totalCount >= _rowCount && _totalCount % _rowCount == 0) {
            addPage = 0;
        }

        int currentPage = _currentPage;
        int totalPage = _totalCount / _rowCount + addPage;

        int size = _maxPageViewCount;
        int halfSize = (int) Math.floor(size / 2);

        startPage = currentPage - halfSize;
        endPage = currentPage + halfSize;

        if (startPage <= 0) {
            endPage -= (startPage - 1);
            startPage = 1;
        }

        if (endPage > totalPage) {
            endPage = totalPage;
            if (endPage - size + 1 > 0) {
                startPage = endPage - size + 1;
            } else {
                startPage = 1;
            }
        }

        if (startPage == 1) {
            paging.setStartFromFirstPage(true);
        }

        int[] pages = new int[endPage-startPage+1];
        int idx = 0;
        for (int i = startPage; i <= endPage; ++i) {
            pages[idx++] = i;

            if (i == currentPage) {
                paging.setPrevNum(currentPage - halfSize - 1);
                paging.setNextNum(currentPage + halfSize + 1);
                System.out.println(paging.getNextNum());
                System.out.println(currentPage);
                if (currentPage == 1) {
                    paging.setNextNum(currentPage + size);
                }
                int remainPage = endPage - currentPage;
                if (remainPage < halfSize) {
                    paging.setPrevNum(currentPage - size + remainPage);
                }
            }
        }
        if (endPage == totalPage) {
            paging.setEndAtLastPage(true);
        }
        paging.setPages(pages);
        paging.setCurrentPage(currentPage);
        return paging;
    }
}
