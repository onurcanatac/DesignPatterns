import java.util.ArrayList;

public class TypeIndicationDecorator extends IndicationDecorator {

    // constructors

    public TypeIndicationDecorator(FileSystemNode fileNode) {
        super(fileNode);
    }

    // methods

    @Override
    public String getInfo() {
        return indicateType(fileNode.getInfo());
    }

    public String indicateType(String infoString) {
        ArrayList<String> rows = new ArrayList<>();

        // put the rows of the info to an arraylist

        while (infoString.indexOf("\n") != -1) {
            int newlineIndex = infoString.indexOf("\n");
            String row = infoString.substring(0, newlineIndex);
            rows.add(row);

            infoString = infoString.substring(newlineIndex + 1);
        }

        // make necessary changes on rows using the arraylist

        for (int rowCounter = 0; rowCounter < rows.size(); rowCounter++) {
            String currentRow = rows.get(rowCounter);

            if (currentRow.indexOf("DIRECTORY END") != -1) {

                currentRow = "(!) " + currentRow;
                rows.set(rowCounter, currentRow);

            } else if (currentRow.indexOf("File Size:") != -1) {
                currentRow = "(f) " + currentRow;
                rows.set(rowCounter, currentRow);
            } else if (currentRow.indexOf("-") != -1) {

                currentRow = "(d) " + currentRow;
                rows.set(rowCounter, currentRow);
            }

        }

        // translate the arraylist back to string format

        String result = "";

        for (int rowCounter = 0; rowCounter < rows.size(); rowCounter++) {
            result = result + rows.get(rowCounter) + "\n";
        }

        return result;

    }

}
