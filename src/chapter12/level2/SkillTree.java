package chapter12.level2;

import java.util.Arrays;

/*
페이지 488
 */
public class SkillTree {
    public int solution(String skill, String[] skillTrees) {
        return (int) Arrays.stream(skillTrees)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(skill::startsWith)
                .count();
    }

    public static void main(String[] args) {
        SkillTree st = new SkillTree();
        String[] skillTrees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(st.solution("CBD", skillTrees));
    }
}
