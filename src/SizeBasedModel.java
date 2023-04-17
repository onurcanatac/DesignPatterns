import java.util.ArrayList;

public class SizeBasedModel implements ModelInterface {

    @Override
    public String displayMemoryRepresentation(String infoString) {

        ArrayList<String> rows = new ArrayList<>();

        // put the rows of the info to an arraylist

        while (infoString.indexOf("\n") != -1) {
            int newlineIndex = infoString.indexOf("\n");
            String row = infoString.substring(0, newlineIndex);
            rows.add(row);

            infoString = infoString.substring(newlineIndex + 1);
        }

        // make necessary changes on the result string by examining the indices of the
        // arraylist

        StringBuilder result = new StringBuilder();

        result.append("{ ");

        for (int rowCounter = 0; rowCounter < rows.size(); rowCounter++) {
            String currentRow = rows.get(rowCounter);

            if (currentRow.indexOf("DIRECTORY END") != -1) {

                result.append("] ");

            } else if (currentRow.indexOf("File Size:") != -1) {

                int separationIndex = currentRow.indexOf("|") + 1;

                String temp = currentRow.substring(separationIndex);

                // 11 is the no of chars in "File Size: "
                int indexOfSize = temp.indexOf("File Size:") + 11;

                int indexLast = temp.indexOf("kb") - 1;

                String fileSize = temp.substring(indexOfSize, indexLast);

                result.append("(" + fileSize + ") ");

            } else if (currentRow.indexOf("-") != -1) {

                result.append("[ ");
            }

        }

        result.append("}");

        return result.toString();
    }

}
