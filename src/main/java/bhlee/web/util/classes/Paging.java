package bhlee.web.util.classes;

public class Paging {
    private boolean startFromFirstPage;
    private boolean endAtLastPage;
    private int prevNum;
    private int nextNum;
    private int currentPage;
    private int[] pages;

    public void setStartFromFirstPage(boolean startFromFirstPage) {
        this.startFromFirstPage = startFromFirstPage;
    }

    public void setEndAtLastPage(boolean endAtLastPage) {
        this.endAtLastPage = endAtLastPage;
    }

    public void setPrevNum(int prevNum) {
        this.prevNum = prevNum;
    }

    public void setNextNum(int nextNum) {
        this.nextNum = nextNum;
    }

    public void setPages(int[] pages) {
        this.pages = pages;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isStartFromFirstPage() {
        return startFromFirstPage;
    }

    public boolean isEndAtLastPage() {
        return endAtLastPage;
    }

    public int getPrevNum() {
        return prevNum;
    }

    public int getNextNum() {
        return nextNum;
    }

    public int[] getPages() {
        return pages;
    }

    public int getCurrentPage() {
        return currentPage;
    }
}
