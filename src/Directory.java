import java.util.ArrayList;

public class Directory extends FileSystemNode {

    // properties

    String directoryName;
    ArrayList<FileSystemNode> fileNodes;

    ModelInterface model;

    // constructors

    public Directory(String directoryName) {
        this.directoryName = directoryName;

        fileNodes = new ArrayList<FileSystemNode>();
    }

    // methods

    public String getInfo() {
        String infoString = "- " + directoryName + "\n";

        for (int i = 0; i < fileNodes.size(); i++) {
            infoString += (fileNodes.get(i)).getInfo();
        }

        infoString += "- DIRECTORY END | " + directoryName + "\n";

        return infoString;
    }

    public void addElement(FileSystemNode fileNode) {
        fileNodes.add(fileNode);
    }

    public void adjustMemoryRepresentation(boolean isSizeBased) {

        if (isSizeBased) {
            model = new SizeBasedModel();
        }

        else {
            model = new TypeBasedModel();
        }

    }

    public String applyMemoryRepresentation() {

        return model.displayMemoryRepresentation(this.getInfo());
    }
}
