package project.study.kanjiexerciser.main;

import android.app.Application;

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
    }
}
