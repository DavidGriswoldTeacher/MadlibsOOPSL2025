public class App {
    private Madlib myMadlib;
    private InputOutput io = new InputOutput();

    /**
     * Where the program begins!
     */
    public void start() {
        myMadlib = readMadlib("madlibe.txt");
        // promptForAnswers();
        // printMadlib();
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
            io.output(nl);
        }

        return m;
    }







    
    public static void main(String[] args) throws Exception {
        new App().start();
    }
}
