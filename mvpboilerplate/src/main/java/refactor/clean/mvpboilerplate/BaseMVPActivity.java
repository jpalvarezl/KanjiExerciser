package refactor.clean.mvpboilerplate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import refactor.clean.mvpboilerplate.interfaces.BaseMVPViewInterface;


/**
 * Created by Jose on 14/10/2016.
 */

public abstract class BaseMVPActivity <T extends BaseMVPPresenter>
        extends AppCompatActivity
        implements BaseMVPViewInterface {
    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = this.createPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public abstract T createPresenter();
}
