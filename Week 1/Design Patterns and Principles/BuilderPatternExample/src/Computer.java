public class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String graphicsCard;
    private boolean isBluetoothEnabled;
    private boolean isWiFiEnabled;

    // Private constructor to prevent direct instantiation
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isWiFiEnabled = builder.isWiFiEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'' +
                ", Graphics='" + graphicsCard + '\'' +
                ", isBluetoothEnabled=" + isBluetoothEnabled +
                ", isWiFiEnabled=" + isWiFiEnabled +
                '}';
    }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private boolean isBluetoothEnabled;
        private boolean isWiFiEnabled;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String GPU) {
            this.graphicsCard = GPU;
            return this;
        }

        public Builder enableBluetooth(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Builder enableWiFi(boolean isWiFiEnabled) {
            this.isWiFiEnabled = isWiFiEnabled;
            return this;
        }

        // Build method to create a Computer instance
        public Computer build() {
            return new Computer(this);
        }
    }
}
