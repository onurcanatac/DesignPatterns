public class IndicationDecorator extends FileSystemNode {

    // properties

    protected FileSystemNode fileNode;

    // constructors

    public IndicationDecorator(FileSystemNode fileNode) {
        this.fileNode = fileNode;
    }

    // methods

    public String getInfo() {
        return fileNode.getInfo();
    }
}
