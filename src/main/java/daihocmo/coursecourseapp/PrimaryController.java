package daihocmo.coursecourseapp;

import daihocmo.service.QuestionService;
import daihocmo.pojo.Question;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

public class PrimaryController implements Initializable {

    @FXML
    private RadioButton rdoA;
    @FXML
    private RadioButton rdoB;
    @FXML
    private RadioButton rdoC;
    @FXML
    private RadioButton rdoD;

    @FXML
    private Text txtA;
    @FXML
    private Text txtB;
    @FXML
    private Text txtC;
    @FXML
    private Text txtD;
     @FXML
    private Text question;
    private List<Question> questions;

    private int currentIndex = 0;

//    @FXML
//    private void switchToSecondary() throws IOException {
//        App.setRoot("secondary");
//    }
    public void handlerEvent(ActionEvent e) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Hello World", ButtonType.OK);
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        QuestionService s = new QuestionService();
        try {
            this.questions = s.getQuestion(4);
            this.loadQuestion();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadQuestion() throws SQLException {
        Question q = this.questions.get(this.currentIndex);
        if (q.getChoices() == null) {
            QuestionService s = new QuestionService();
            q.setChoices(s.getChoice(q.getId()));
        }
        
        this.question.setText(q.getContent());

        this.txtA.setText(q.getChoices().get(0).getContent());
        this.txtB.setText(q.getChoices().get(1).getContent());
        this.txtC.setText(q.getChoices().get(2).getContent());
        this.txtD.setText(q.getChoices().get(3).getContent());

    }
    
    public void nextHandler(ActionEvent e) throws SQLException {
        if(this.currentIndex < this.questions.size() - 1) {
            this.currentIndex++;
        }
        else 
            this.currentIndex = 0;
        this.loadQuestion();
    }
    
    public void previoutHandler(ActionEvent e) throws SQLException {
        if(this.currentIndex > 0) {
            this.currentIndex--;
        }
        
        this.loadQuestion();
    }
}
