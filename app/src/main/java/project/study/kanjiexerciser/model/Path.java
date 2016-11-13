package project.study.kanjiexerciser.model;

import lombok.Getter;
import lombok.experimental.Builder;

@Getter @Builder
public class Path {
    private String pathId;
    private int strokeNumber;
    private String drawing; //corresponds to attribute 'd'
}
