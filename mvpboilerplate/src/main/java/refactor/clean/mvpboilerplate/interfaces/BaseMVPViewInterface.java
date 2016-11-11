package refactor.clean.mvpboilerplate.interfaces;

import refactor.clean.mvpboilerplate.BaseMVPPresenter;

public interface BaseMVPViewInterface<T extends BaseMVPPresenter> {
    T createPresenter();
}
