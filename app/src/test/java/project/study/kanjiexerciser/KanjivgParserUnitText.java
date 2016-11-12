package project.study.kanjiexerciser;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import project.study.kanjiexerciser.utils.KanjivgParser;
import project.study.kanjiexerciser.utils.ParserConfig;

import static org.junit.Assert.assertEquals;
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class KanjivgParserUnitText {

    @Before
    public void setup(){
    }

    @Test
    public void load_singleKanji() throws Exception {
        //ParserConfig.KANJI_ASSET_FILE_NAME = ParserConfig.KANJI_ASSET_FILE_NAME_TEST1;

        KanjivgParser parser = KanjivgParser.getInstance();
        List kanjiList = parser.getKanjiList();

        assertEquals(1, kanjiList.size());
    }
}
