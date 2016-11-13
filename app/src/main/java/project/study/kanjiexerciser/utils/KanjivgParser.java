package project.study.kanjiexerciser.utils;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import project.study.kanjiexerciser.main.KanjiExerciserApplication;
import project.study.kanjiexerciser.model.Group;
import project.study.kanjiexerciser.model.Kanji;
import project.study.kanjiexerciser.model.Path;

public class KanjivgParser {

    private static final String KANJIVG_XML = ParserConfig.KANJI_ASSET_FILE_NAME;
    private static KanjivgParser mInstance;

    public List<Kanji> getKanjiList() {
        return kanjiList;
    }

    private static List<Kanji> kanjiList;
    private static final String ns = null;

    private KanjivgParser(){
        try {
            InputStream is =
                    KanjiExerciserApplication
                            .getInstance()
                            .getApplicationContext()
                            .getAssets()
                            .open(KANJIVG_XML);

            kanjiList = parse(is);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static KanjivgParser getInstance(){
        if(mInstance == null)
            mInstance = new KanjivgParser();
        return mInstance;
    }

    private List parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readKanjivg(parser);
        } finally {
            in.close();
        }
    }

    private List readKanjivg(XmlPullParser parser) throws XmlPullParserException, IOException {
        List entries = new ArrayList();

        parser.require(XmlPullParser.START_TAG, ns, "kanjivg");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("kanji")) {
                entries.add(readKanji(parser));
            } else {
                skip(parser);
            }
        }
        return entries;
    }

    private Kanji readKanji(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "kanji");
        Group g = null;
        String kanjiId = parser.getAttributeValue(ns, "id");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG)
                continue;

            String name = parser.getName();
            if (name.equals("g"))
                g = readGroup(parser);
            else
                skip(parser);
        }
        return Kanji
                .builder()
                .kanjiId(kanjiId)
                .rootGroup(g)
                .build();
    }

    private Group readGroup(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "g");
        List<Path> paths = new ArrayList<>();
        List<Group> groups = new ArrayList<>();
        String groupId = parser.getAttributeValue(ns, "id");

        while(parser.next() != XmlPullParser.END_TAG || !parser.getName().equals("g")){
            if(parser.getEventType() != XmlPullParser.START_TAG)
                continue;
            String name = parser.getName();

            if(name.equals("path"))
                paths.add(readPath(parser));
            else if(name.equals("g"))
                groups.add(readGroup(parser));
            else
                skip(parser);
        }
        parser.require(XmlPullParser.END_TAG, ns, "g");

        return Group.builder()
                .groupId(groupId)
                .groups(groups.isEmpty() ? null : groups)
                .paths(paths.isEmpty() ? null : paths)
                .build();
    }

    private Path readPath(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "path");
        String pathId = parser.getAttributeValue(ns, "id");
        int strokeNumber = Integer.valueOf(pathId.split("s")[1]);

        return Path.builder()
                .pathId(pathId)
                .drawing(parser.getAttributeValue(ns, "d"))
                .strokeNumber(strokeNumber)
                .build();
    }

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
