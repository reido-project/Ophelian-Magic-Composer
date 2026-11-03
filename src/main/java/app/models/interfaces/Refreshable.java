package app.models.interfaces;

public interface Refreshable {
    void refresh();
    void setGlobalRefresh(Runnable globalRefresh);
}
