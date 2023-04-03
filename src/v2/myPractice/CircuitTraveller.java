package v2.myPractice;

public class CircuitTraveller {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int fuel = 0;
        int runningFuelReq = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            runningFuelReq = runningFuelReq + gas[i] - cost[i];
            fuel = fuel + gas[i]  - cost[i];
            if(fuel < 0){
                fuel = 0;
                start = i;
            }
        }

        return runningFuelReq < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        new CircuitTraveller().canCompleteCircuit(gas, cost);
    }
}
