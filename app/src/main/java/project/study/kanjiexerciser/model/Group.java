package project.study.kanjiexerciser.model;

import java.util.List;

import lombok.Getter;
import lombok.experimental.Builder;

@Getter @Builder
public class Group {
    private String groupId;
    private List<Group> groups;
    private List<Path> paths;
}
