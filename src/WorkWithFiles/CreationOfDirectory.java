package WorkWithFiles;

import java.io.File;

public class CreationOfDirectory {


    public void createFolderInSourceFolderOfProject(String folderName){
        File dir = new File(folderName);
        if (!dir.exists()){
                dir.mkdir();
        }
    }

    public void createFolderWherever (String path){
        File dir = new File(path);
        if (!dir.exists()){
            dir.mkdirs();
        }

    }

    public static void main(String[] args) {
        new CreationOfDirectory().createFolderInSourceFolderOfProject("new folder");

        new CreationOfDirectory().createFolderWherever("E:\\project\\folder1\\folder2");


    }

}
