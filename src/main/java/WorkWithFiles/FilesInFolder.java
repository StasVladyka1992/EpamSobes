package WorkWithFiles;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesInFolder {
    public static void main(String[] args) {
        String path = "E:\\project";
        File folder = new File(path);

        for (File f:folder.listFiles()) {
            Pattern pt = Pattern.compile(".txt");
            Matcher m = pt.matcher(f.getName());
            while (m.find()){
                System.out.println(f.getName() +" лежит в " +f.getPath());
                System.out.println(m.group());
            }
        }
    }
}
