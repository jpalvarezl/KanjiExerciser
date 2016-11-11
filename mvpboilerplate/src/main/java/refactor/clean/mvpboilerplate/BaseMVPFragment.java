package refactor.clean.mvpboilerplate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import refactor.clean.mvpboilerplate.interfaces.BaseMVPViewInterface;

public abstract class BaseMVPFragment<T extends BaseMVPPresenter>
        extends Fragment
        implements BaseMVPViewInterface {
    public T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = (T) this.createPresenter();
        presenter.attachView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public abstract T createPresenter();
}
