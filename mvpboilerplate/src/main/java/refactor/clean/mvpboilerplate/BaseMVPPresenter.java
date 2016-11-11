package refactor.clean.mvpboilerplate;

import refactor.clean.mvpboilerplate.interfaces.BaseMVPPresenterInterface;
import refactor.clean.mvpboilerplate.interfaces.BaseMVPViewInterface;


/**
 * Created by Jose on 14/10/2016.
 */

public class BaseMVPPresenter <T extends BaseMVPViewInterface>
        implements BaseMVPPresenterInterface<T> {
    public T view;

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }


}
