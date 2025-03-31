public class Madlib {
    
    private String[] questions;
    private String[] answers;
    private String[] storyPieces;
    private int numQuestions = 0;
    private int numAnswers = 0;
    private int numStoryPieces = 0;

    public Madlib() {
        questions = new String[100];
        answers = new String[100];
        storyPieces = new String[101];
    }

    public void addQuestion(String q) {
        questions[numQuestions] = q;
        numQuestions++;
    }

    public void addAnswer(String a) {
        answers[numAnswers] = a;
        numAnswers++;
    }

    public void addStoryPiece(String sp) {
        storyPieces[numStoryPieces] = sp;
        numStoryPieces++;
    }
}
