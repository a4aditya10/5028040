public class Test {
    public static void main(String[] args) {
        // To create a Computer with only mandatory attributes
        Computer basicComputer = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();

        System.out.println("Basic Computer: " + basicComputer);

        // To create a Computer with all optional attributes
        Computer advancedComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 3070")
                .enableBluetooth(true)
                .enableWiFi(true)
                .build();

        System.out.println("Advanced Computer: " + advancedComputer);
    }
}
