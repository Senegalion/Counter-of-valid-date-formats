package laboratory_5;

public enum Files {
    INPUTFILE("src/laboratory_5/InputData.txt"),
    OUTPUTFILE("src/laboratory_5/MyData.txt");

    private final String fileAddress;

    Files(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public String getFileAddress() {
        return fileAddress;
    }
}
