class Main implements Runnable {
    public int desiredNum;

    public Main(int num)
    {
        this.desiredNum = num;
    }

    // Prints task name and sleeps for 1s
    // This Whole process is repeated 5 times
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
            System.out.println("number of divisiors of " + i + " is: " + totalDivingAmount);
            counter=0;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}