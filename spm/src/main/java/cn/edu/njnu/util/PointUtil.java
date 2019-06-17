package cn.edu.njnu.util;

import cn.edu.njnu.vo.ExamPaper;

import java.util.List;

public class PointUtil {

    public static Float verifyAnswer(List<ExamPaper> paper) {
        float point = 0;
        for (ExamPaper examPaper : paper) {
            List<String> answer = examPaper.getAnswer();
            List<String> correctAnswer = examPaper.getCorrectAnswer();
            if (isAnswerRight(answer, correctAnswer))
                point += examPaper.getPoint();
        }
        return point;
    }

    private static boolean isAnswerRight(List<String> answer, List<String> correctAnswer) {
        if(answer==null||correctAnswer==null) return false;
        if(answer.size()!=correctAnswer.size()) return false;
        for (String s : correctAnswer) {
            if(!answer.contains(s)) return false;
        }
        return true;
    }
}
