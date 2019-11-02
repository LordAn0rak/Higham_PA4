public class Application {

    public static void main(String[] args){

        DuplicateCounter duplicateCounter = new DuplicateCounter();

        duplicateCounter.count("src/problem2.txt");

        duplicateCounter.write("src/unique_word_counts.txt");
    }
}
