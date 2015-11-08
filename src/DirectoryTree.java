import java.io.File;

/**
 * Created by alvin2 on 11/8/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */
public class DirectoryTree
{

    public static void printFiles(String path) {
        File f = new File(path);
        File[] fileArray = f.listFiles();

        for (File file : fileArray) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                printFiles(path+"/"+file.getName());
            }
        }
    }


    public static void main(String[] args) {
        printFiles("/Users/alvin2/Desktop/Finances");
    }
}
