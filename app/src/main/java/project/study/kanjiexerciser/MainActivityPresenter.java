package project.study.kanjiexerciser;

import android.text.TextUtils;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGBuilder;

import java.io.IOException;

import refactor.clean.mvpboilerplate.BaseMVPPresenter;

public class MainActivityPresenter extends BaseMVPPresenter<MainActivity_>{
    public void onRenderClick() {
        String character = view.getCharacter();
        if(!TextUtils.isEmpty(character)) {
            String assetFileName = "0" + Integer.toHexString((int) character.toCharArray()[0]) + ".svg";
            SVG svg = getSVG(assetFileName);
            if(svg != null)
                view.setKanjiImage(svg.getDrawable());
        }
    }

    private SVG getSVG(String assetFileName) {
        SVG svg = null;
        try {
            svg = new SVGBuilder()
                    .readFromAsset(view.getAssets(), assetFileName)
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return svg;
        }
    }
}
