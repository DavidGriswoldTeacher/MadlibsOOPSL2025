public class Madlib {
    // These variables define the key data that represents a madlib
    private String[] questions = new String[100];
    private String[] answers = new String[100];
    private String[] storyPieces = new String[101];
    // there is one more story piece than question, for the final little bit.

    // these three variables keep track of how much we have added so far
    private int numQuestions = 0;
    private int numAnswers = 0;
    private int numStoryPieces = 0;

    /**
     * Adds a question to the end of the question list
     * @param q
     */
    public void addQuestion(String q) {
        questions[numQuestions] = q;
        numQuestions++;
    }

    /**
     * Add an answer to the end of the answer list
     * @param a
     */
    public void addAnswer(String a) {
        answers[numAnswers] = a;
        numAnswers++;
    }

    /**
     * Add a story piece to the end of the list of story pieces
     */
    public void addStoryPiece(String sp) {
        storyPieces[numStoryPieces] = sp;
        numStoryPieces++;
    }

    public int getNumQuestions() { 
        return numQuestions;
    }

    /**
     * 
     * @param i The index of which question to return
     * @return the question at the specified index
     */
    public String getQuestion(int i) {
        return questions[i];
    }

    /**
     * Builld the entire completed story and return it as a single string
     * @return
     */
    public String getFullStory() {
        String story = storyPieces[0];
        for (int i = 0; i < numQuestions; i++) {
            story = story + answers[i];
            story = story + storyPieces[i+1];
        }
        return story;
    }
}
