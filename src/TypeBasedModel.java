import java.util.ArrayList;

public class TypeBasedModel implements ModelInterface {

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

        int depth = 0;

        for (int rowCounter = 0; rowCounter < rows.size(); rowCounter++) {
            String currentRow = rows.get(rowCounter);

            if (currentRow.indexOf("DIRECTORY END") != -1) {

                depth--;

                result.append("EOD" + depth + "] ");

            } else if (currentRow.indexOf("File Size:") != -1) {

                result.append("(F) ");

            } else if (currentRow.indexOf("-") != -1) {

                result.append("[D" + depth + " ");

                depth++;
            }

        }

        result.append("}");

        return result.toString();

    }

}
