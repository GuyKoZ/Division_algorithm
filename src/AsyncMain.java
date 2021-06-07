class AsyncMain implements Runnable {
    public int desiredNum;
    public static int max;
    public static int maxNumber;

    public AsyncMain(int num)
    {
        this.desiredNum = num;
    }

    public int getDesiredNum() {
        return desiredNum;
    }

    public static int getMax() {
        return max;
    }

    public static int getMaxNumber() {
        return maxNumber;
    }

    public void setDesiredNum(int desiredNum) {
        this.desiredNum = desiredNum;
    }

    public static void setMax(int max) {
        AsyncMain.max = max;
    }

    public static void setMaxNumber(int maxNumber) {
        AsyncMain.maxNumber = maxNumber;
    }
    public void maxNumber(int place, int numToCheck){
        if (place > max ){
            max = place;
            maxNumber = numToCheck;
        }
    }
    // Prints task name and sleeps for 1s
    // This Whole process is repeated 5 times
    @Override
    public void run()
    {
        int counter = 0, totalDivingAmount = 0;
        for(int i = 1; i <= desiredNum; i++)
        {
            for(int j = 1; j <= desiredNum; j++)
            {
                if(j%i==0)
                {
                    totalDivingAmount++;
                    counter++;
                }
            }
            maxNumber(counter,totalDivingAmount);
            System.out.println("number of divisiors of " + i + " is: " + totalDivingAmount);
            counter=0;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The number with the highest amount of dividors is: " + AsyncMain.getMaxNumber() + "and the dividors amount is: " + AsyncMain.getMax());
    }
}