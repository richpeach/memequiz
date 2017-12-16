package app.test.ru.first;

public class QuestionLibrary {

    private String mQuestions [] = {
            "fiasko",
            "dratyti",
            "respect",
            "The _______ holds the plant upright."

    };


    private String mChoices [][] = {
            {"", "Stem", "Flower"},
            {"Fruit", "Leaves", "Seeds"},
            {"Bark", "Flower", "Roots"},
            {"Flower", "Leaves", "Stem"}
    };



    private String mCorrectAnswers[] = {"Roots", "Leaves", "Flower", "Stem"};




    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice(int a, int index) {
        String choice0 = mChoices[a][index];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}