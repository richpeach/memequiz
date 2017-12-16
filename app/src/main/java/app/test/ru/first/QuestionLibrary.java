package app.test.ru.first;

public class QuestionLibrary {

    private int mQuestions[] = {
            R.drawable.dno,
            R.drawable.dratyti,
            R.drawable.fiasko,
            R.drawable.garold,
            R.drawable.jdyn,
            R.drawable.misterdydez,
            R.drawable.respect,
            R.drawable.tyt
    };

    private String mChoices [][] = {
            {"Dno", "Stem", "Flower"},
            {"Fruit", "Leaves", "Dratyti"},
            {"Bark", "Fiasko", "Roots"},
            {"Garold", "Leaves", "Stem"},
            {"Jdyn", "Ne jdun", "Basya"},
            {"Jdyn", "Mistrdydez", "Basya"},
            {"Jdyn", "Ne jdun", "Respect"},
            {"Jdyn", "Tut", "Basya"}
    };



    private int mCorrectAnswers[] = {0, 2, 1, 0, 0, 1, 2, 1};

    public String getChoice(int a, int index) {
        String choice0 = mChoices[a][index];
        return choice0;
    }

    public int getCorrectAnswer(int a) {
        return mCorrectAnswers[a];
    }

    public int getQuestionImageId(int questionIndex) {
        return mQuestions[questionIndex];
    }
}