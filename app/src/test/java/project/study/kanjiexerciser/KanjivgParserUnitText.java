package project.study.kanjiexerciser;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import project.study.kanjiexerciser.model.Kanji;
import project.study.kanjiexerciser.model.Path;
import project.study.kanjiexerciser.utils.KanjivgParser;
import project.study.kanjiexerciser.utils.ParserConfig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class KanjivgParserUnitText {
    private Kanji singleKanji;

    @Before
    public void setup() {
        ParserConfig.KANJI_ASSET_FILE_NAME = ParserConfig.KANJI_ASSET_FILE_NAME_TEST1;
        KanjivgParser parser = KanjivgParser.getInstance();
        List kanjiList = parser.getKanjiList();
        singleKanji = (Kanji) kanjiList.get(0);
    }

    @Test
    public void load_singleKanji() throws Exception {
        assertNotNull(singleKanji);
        assertNotNull(singleKanji.getKanjiId());
        assertEquals(singleKanji.getKanjiId(), "kvg:kanji_00021");
    }

    @Test
    public void rootGroupLoaded() throws Exception {
        assertNotNull(singleKanji.getRootGroup());
        assertEquals(singleKanji.getRootGroup().getGroupId(), "kvg:00021");
    }

    @Test
    public void loadPaths() throws Exception {
        assertEquals(singleKanji.getRootGroup().getPaths().size(), 2);

        List<Path> paths = singleKanji.getRootGroup().getPaths();

        Path pathS1 = paths.get(0);
        Path pathS2 = paths.get(1);

        assertEquals(pathS1.getPathId(), "kvg:00021-s1");
        assertEquals(pathS2.getPathId(), "kvg:00021-s2");

        assertEquals(pathS1.getDrawing(), "M54.5,15.79c0,6.07-0.29,55.49-0.29,60.55");
        assertEquals(pathS2.getDrawing(), "M54.5,88 c -0.83,0 -1.5,0.67 -1.5,1.5 0,0.83 0.67,1.5 1.5,1.5 0.83,0 1.5,-0.67 1.5,-1.5 0,-0.83 -0.67,-1.5 -1.5,-1.5");
    }
}