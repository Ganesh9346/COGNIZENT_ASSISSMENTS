/*

EXERCISE 7: FINANCIAL FORECASTING
1. Concept of Recursion
Recursion is a programming technique in which a method calls itself to solve a smaller version of 
the same problem. It is useful for problems that can be divided into smaller subproblems. Recursion 
can make certain programs shorter and easier to understand.

2. Recursive Approach for Financial Forecasting
In financial forecasting, the future value can be calculated using the current value and a growth 
rate. A recursive method can repeatedly apply the growth rate until the required number of years is 
reached.

3. Time Complexity
The recursive solution shown in this program makes one recursive call for each year. Therefore, its 
time complexity is O(n), where n is the number of years.

4. Optimization
If a recursive solution performs the same calculations repeatedly, the execution time can increase 
significantly. This problem can be reduced by using techniques such as memoization or dynamic 
programming, where previously calculated values are stored and reused instead of being computed 
again.
*/

public class Exercise7_FinancialForecasting {

    static double futureValue(double amount,double growthRate,int years) {

        if (years == 0) {
            return amount;
        }

        return futureValue(amount * (1 + growthRate),growthRate,years - 1);
    }

    public static void main(String[] args) {

        double presentValue = 10000;
        double growthRate = 0.10;
        int years = 5;

        double result =futureValue(presentValue,growthRate,years);

        System.out.println("Present Value : " + presentValue);
        System.out.println("Growth Rate : " + (growthRate * 100) + "%");
        System.out.println("Years : " + years);
        System.out.println("Future Value : " + result);
    }
}