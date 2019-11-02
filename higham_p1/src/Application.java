public class Application{

    public static void main(String[] args){

        DuplicateRemover duplicateRemover = new DuplicateRemover();

        duplicateRemover.remove("src/problem1.txt");

        duplicateRemover.write("src/unique_words.txt");
    }
}
