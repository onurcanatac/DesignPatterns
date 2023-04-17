public class File extends FileSystemNode {

    // properties

    String fileName;
    String extension;
    int fileSize;

    // constructors

    public File(String fileName, String extension, int fileSize) {
        this.fileName = fileName;
        this.extension = extension;
        this.fileSize = fileSize;
    }

    // methods

    public String getInfo() {

        return fileName + "." + extension + " | File Size: " + fileSize + " kb\n";
    }
}
