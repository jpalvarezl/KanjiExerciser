package refactor.clean.mvpboilerplate.interfaces;

public interface BaseMVPPresenterInterface <T extends BaseMVPViewInterface> {
    BaseMVPViewInterface view = null;
    void attachView(T View);
    void detachView();
}
