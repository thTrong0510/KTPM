/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import org.junit.jupiter.api.Test;
import daihocmo.service.QuestionService;
import java.util.List;
import daihocmo.pojo.Question;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;

public class QuestionTestSuite {

    @Test
    public void test() throws SQLException {
        QuestionService s = new QuestionService();
        List<Question> questions = s.getQuestion(2);
        Assertions.assertEquals(questions.size(), 2);

//           questions.forEach(s - > System.out.println(s));
    }
}
