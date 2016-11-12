package project.study.kanjiexerciser.main;

import android.app.Application;

import project.study.kanjiexerciser.utils.ParserConfig;

/**
 * Created by Jose on 11/11/2016.
 */

public class KanjiExerciserApplication extends Application {
    private static KanjiExerciserApplication mInstance;

    public static KanjiExerciserApplication getInstance(){
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        ParserConfig.KANJI_ASSET_FILE_NAME = ParserConfig.KANJI_ASSET_DEFAULT_FILE_NAME;
    }
}
