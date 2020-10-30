package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class CSVReader {

    private static final String DELEIMETER = ",";

    public void readCSV() {
        final String csvFile = "path/to/csv/file";
        try {
            final File file = new File(csvFile);
            final InputStream fileInputStream = new FileInputStream(file);
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            readCSVUsingMap(bufferedReader);
            readCSVLineByLine(bufferedReader);

            bufferedReader.close();

        }
        catch(IOException ex) {
            System.out.println("Exception:: "+ex.getMessage());
            ex.printStackTrace();
        }

        return csvDataList;
    }

    public void readCSVUsingMap(BufferedReader bufferedReader){
        // https://dzone.com/articles/how-to-read-a-big-csv-file-with-java-8-and-stream
        csvDataList = bufferedReader.lines().skip(1).map(mapToCsvData).collect(Collectors.toList());
    }

    public void readCSVLineByLine(BufferedReader br){
        String line = "";
        String[] tempArr;
        while((line = br.readLine()) != null) {
            tempArr = line.split(delimiter);
            for(String tempStr : tempArr) {
                System.out.print(tempStr + " ");
            }
            System.out.println();
        }
    }

    // lambda expression
    private Function<String, CSVData> mapToCsvData = (line)-> {
        final String[] tempArr = line.split(DELEIMETER);
        return new CSVData(Double.parseDouble(tempArr[0]), Byte.parseByte(tempArr[1])==0?false:true);
    };



    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
