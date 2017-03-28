package project.study.kanjiexerciser.model;

public class Kanji {
    private String kanjiId;
    private Group rootGroup;

    private Kanji(Builder builder) {
        kanjiId = builder.kanjiId;
        rootGroup = builder.rootGroup;
    }

    public String getKanjiId() {
        return kanjiId;
    }

    public Group getRootGroup() {
        return rootGroup;
    }


    public static final class Builder {
        private String kanjiId;
        private Group rootGroup;

        public Builder() {
        }

        public Builder kanjiId(String val) {
            kanjiId = val;
            return this;
        }

        public Builder rootGroup(Group val) {
            rootGroup = val;
            return this;
        }

        public Kanji build() {
            return new Kanji(this);
        }
    }
}
