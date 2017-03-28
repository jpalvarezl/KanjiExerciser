package project.study.kanjiexerciser.model;

import java.util.List;

public class Group {
    private String groupId;
    private List<Group> groups;
    private List<Path> paths;

    private Group(Builder builder) {
        groupId = builder.groupId;
        groups = builder.groups;
        paths = builder.paths;
    }

    public String getGroupId() {
        return groupId;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public static final class Builder {
        private String groupId;
        private List<Group> groups;
        private List<Path> paths;

        public Builder() {
        }

        public Builder groupId(String val) {
            groupId = val;
            return this;
        }

        public Builder groups(List<Group> val) {
            groups = val;
            return this;
        }

        public Builder paths(List<Path> val) {
            paths = val;
            return this;
        }

        public Group build() {
            return new Group(this);
        }
    }
}
