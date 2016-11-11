package refactor.clean.mvpboilerplate;

import android.content.Context;
import android.view.View;

import refactor.clean.mvpboilerplate.interfaces.BaseMVPViewInterface;

public abstract class BaseMVPView <T extends BaseMVPPresenter>
        extends View
        implements BaseMVPViewInterface {
    public T presenter;
    public BaseMVPView(Context context) {
        super(context);
        presenter = (T) this.createPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        presenter.detachView();
    }

    @Override
    public abstract T createPresenter();
}
