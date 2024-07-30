class FinancialForecasting {
    public double predictFutureValue(double[] pastValues, int years) {
        if (years == 0) {
            return pastValues[pastValues.length - 1];
        }
        double growthRate = pastValues[pastValues.length - 1] / pastValues[pastValues.length - 2];
        double[] newValues = new double[pastValues.length + 1];
        System.arraycopy(pastValues, 0, newValues, 0, pastValues.length);
        newValues[newValues.length - 1] = pastValues[pastValues.length - 1] * growthRate;
        return predictFutureValue(newValues, years - 1);
    }

    public double predictFutureValueOptimized(double[] pastValues, int years) {
        double currentValue = pastValues[pastValues.length - 1];
        double growthRate = pastValues[pastValues.length - 1] / pastValues[pastValues.length - 2];

        for (int i = 0; i < years; i++) {
            currentValue *= growthRate;
        }
        return currentValue;
    }
}
public class Main {
    public static void main(String[] args) {
        // Create an instance of FinancialForecasting
        FinancialForecasting forecasting = new FinancialForecasting();

        // Define an array of past values (e.g., stock prices, revenue, etc.)
        double[] pastValues = {100.0, 110.0, 121.0, 133.1};

        // Define the number of years to forecast
        int years = 3;

        // Predict future value using the recursive method
        double futureValueRecursive = forecasting.predictFutureValue(pastValues, years);
        System.out.println("Predicted future value (Recursive) after " + years + " years: " + futureValueRecursive);

        // Predict future value using the optimized method
        double futureValueOptimized = forecasting.predictFutureValueOptimized(pastValues, years);
        System.out.println("Predicted future value (Optimized) after " + years + " years: " + futureValueOptimized);
    }
}
