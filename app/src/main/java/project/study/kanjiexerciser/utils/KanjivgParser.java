package project.study.kanjiexerciser.utils;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import project.study.kanjiexerciser.main.KanjiExerciserApplication;
import project.study.kanjiexerciser.model.Kanji;

public class KanjivgParser {

    private static KanjivgParser mInstance;

    public List<Kanji> getKanjiList() {
        return kanjiList;
    }

    private static List<Kanji> kanjiList;
    private static final String ns = null;

    private KanjivgParser(){
        try {
            InputStream is = KanjiExerciserApplication
                    .getInstance()
                    .getApplicationContext()
                    .getAssets()
                    .open("kanjivg.xml");

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
            // Starts by looking for the entry tag
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
        String g = null;
        String path = null;
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("g")) {
                //g = readG(parser);//todo must do so recursively
            } else if (name.equals("path")) {
                //path = readPath(parser);//todo recursive
            } else {
                skip(parser);
            }
        }
        return new Kanji(g, path);
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
