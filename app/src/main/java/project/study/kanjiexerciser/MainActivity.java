package project.study.kanjiexerciser;

import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.ImageView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import refactor.clean.mvpboilerplate.BaseMVPActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseMVPActivity<MainActivityPresenter> {
    @ViewById(R.id.svg_kanji_image)
    ImageView kanjiImageView;

    @ViewById(R.id.kanji_to_render)
    EditText character;

    @Click(R.id.render_button)
    void onRenderClick(){
        presenter.onRenderClick();
    }

    String getCharacter(){
        return character.getText().toString();
    }

    void setCharacter(String newCharacter){
        character.setText(newCharacter);
    }

    void setKanjiImage(Drawable kanjiImageDrawable){
        kanjiImageView.setImageDrawable(kanjiImageDrawable);
    }

    @Override
    public MainActivityPresenter createPresenter() {
        return new MainActivityPresenter();
    }
}
