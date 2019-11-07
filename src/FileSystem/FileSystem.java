package FileSystem;

import java.util.*;

/**
 * Created by amit on 21/2/19.
 */
public class FileSystem {

    class File {
        boolean isFile;
        HashMap<String, File> files = new HashMap<>();
        String contains = "";
    }

    File root;

    FileSystem() {
        root = new File();
    }

    public List<String> ls(String path) {
        File t = root;
        List<String> files = new ArrayList<>();
        if (!path.equals("/")) {
            String[] d = path.split("/");
            for (int i = 1; i < d.length; i++) {
                t = t.files.get(d[i]);
            }
            if (t.isFile) {
                files.add(d[d.length - 1]);
                return files;
            }
        }
        List<String> files_res = new ArrayList<>(t.files.keySet());
        Collections.sort(files_res);
        return files_res;
    }

    public void mkdir(String path) {
        File t = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            if (!t.files.containsKey(d[i])) {
                t.files.put(d[i], new File());
            }
            t = t.files.get(d[i]);

        }
    }

    public void addContenttoFile(String path, String content) {

        File t = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            t = t.files.get(d[i]);
        }

        if (!t.files.containsKey(d[d.length - 1])) {
            t.files.put(d[d.length - 1], new File());
        }
        t = t.files.get(d[d.length - 1]);
        t.isFile = true;
        t.contains += content;
    }

    public String readContent(String path) {
        File t = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            t = t.files.get(d[i]);
        }
        return t.files.get(d[d.length - 1]).contains;
    }
}
