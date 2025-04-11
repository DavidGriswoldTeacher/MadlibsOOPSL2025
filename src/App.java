public class App {
    // A controller (App) needs a connection to both our model (Madlib)
    // and our view (io)
    private Madlib myMadlib;
    private InputOutput io = new InputOutput();

    /**
     * Where the program begins! This is where I outlined the structure of my program.
     */
    public void start() {
        // read the madlib from the file into my madlib object
        myMadlib = readMadlib("madlib.txt");
        promptForAnswers();

        // print the new madlib to the terminal
        io.output(myMadlib.getFullStory());

        // these three lines print the madlib to a text file
        io.openWriteFile("last_full_madlib.txt");
        io.writeToFile(myMadlib.getFullStory());
        io.closeWriteFile();
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
    /**
     * Ask the user for the answers to the madlib questions, and
     * save them into the Madlib object
     */
    public void promptForAnswers() {
        for (int i = 0; i < myMadlib.getNumQuestions(); i++) {
            io.output(myMadlib.getQuestion(i));
            String s = io.input();
            myMadlib.addAnswer(s);
        }
    }

    /**
     * The required main method. All it does is run the start method!
     */
    public static void main(String[] args) throws Exception {
        new App().start();
    }
}
