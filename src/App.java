public class App {
    private Madlib myMadlib;
    private InputOutput io = new InputOutput();

    /**
     * Where the program begins!
     */
    public void start() {
        myMadlib = readMadlib("madlib.txt");
        promptForAnswers();
        io.output(myMadlib.getFullStory());
    }

    /**
     * Read the file with the madlib and create a Madlib object
     * @return a new Madlib objct
     */
    public Madlib readMadlib(String filename) {
        Madlib m = new Madlib();
        try {
            io.openFile(filename);
        } catch (Exception e) {
            io.output(e.toString());
            return m;
        }
        
        while (io.fileHasNextLine()) {
            String nl = io.getNextLine();
            m.addStoryPiece(nl);
            if (io.fileHasNextLine()) {
                String q = io.getNextLine();
                m.addQuestion(q);
            }
        }

        return m;
    }

    public void promptForAnswers() {
        for (int i = 0; i < myMadlib.getNumQuestions(); i++) {
            io.output(myMadlib.getQuestion(i));
            String s = io.input();
            myMadlib.addAnswer(s);
        }
    }





    public static void main(String[] args) throws Exception {
        new App().start();
    }
}
