package project.study.kanjiexerciser.model;

import java.util.List;

import lombok.Getter;
import lombok.experimental.Builder;

/**
 * Created by Jose on 11/11/2016.
 */

@Getter @Builder
public class Kanji {
    private String kanjiId;
    private Group rootGroup;
}
