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
    private List kanjiList;

    @Before
    public void setup(){
        ParserConfig.KANJI_ASSET_FILE_NAME = ParserConfig.KANJI_ASSET_FILE_NAME_TEST1;
        KanjivgParser parser = KanjivgParser.getInstance();
        kanjiList = parser.getKanjiList();
    }

    @Test
    public void load_singleKanji() throws Exception {
        assertEquals(1, kanjiList.size());
    }
}
