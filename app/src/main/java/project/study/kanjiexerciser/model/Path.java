package project.study.kanjiexerciser.model;

public class Path {
    private String pathId;
    private int strokeNumber;
    private String drawing; //corresponds to attribute 'd'

    private Path(Builder builder) {
        pathId = builder.pathId;
        strokeNumber = builder.strokeNumber;
        drawing = builder.drawing;
    }

    public String getPathId() {
        return pathId;
    }

    public int getStrokeNumber() {
        return strokeNumber;
    }

    public String getDrawing() {
        return drawing;
    }

    public static final class Builder {
        private String pathId;
        private int strokeNumber;
        private String drawing;

        public Builder() {
        }

        public Builder pathId(String val) {
            pathId = val;
            return this;
        }

        public Builder strokeNumber(int val) {
            strokeNumber = val;
            return this;
        }

        public Builder drawing(String val) {
            drawing = val;
            return this;
        }

        public Path build() {
            return new Path(this);
        }
    }
}
