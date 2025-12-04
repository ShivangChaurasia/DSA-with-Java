
class Recursion1{

    public static void PrintNum(int n){
        if(n==0){
            return;
        }
        PrintNum(n-1);
        System.out.println(n);
    }

    public static int SumNum(int n, int sum){
        if(n==0){
            return sum;
        }
        sum+=n;
        return SumNum(n-1, sum);
    }
    public static int factorial(int n){
        if(n==1 || n==0){
            return 1;
        }
        int fact = n * factorial(n-1);
        return fact;
    }

    public static void Fibonacci(int a, int b, int n){
        if(n==0){
            return;
        }
        int c = a+b;
        System.out.println(c);
        Fibonacci(b, c, n-1);
    }

    public static int PowerNum(int base, int exp){ // O(n)
        if(exp==0){
            return 1;
        }
        if(base == 0){
            return 0;
        }
        int power = base * PowerNum(base, exp-1);
        return power;
    }

    public static int PowerNum2(int base, int exp){ // O(log n)
        if(exp==0){
            return 1;
        }
        if(base == 0){
            return 0;
        }
        if(exp%2==0){
            return PowerNum2(base, exp/2) * PowerNum2(base, exp/2);
        }else{
            return PowerNum2(base, exp/2) * PowerNum2(base, exp/2) * base;
        }
    }


    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int num = sc.nextInt();
        // Easy problems using recursion:==============================
            // Print numbers from 1 to n/n to 1;----
                // PrintNum(num);

            // Sum of n numbers;----
                // int sum=0;
                // sum = SumNum(num, sum);
                // System.out.println("Sum is: "+sum);

            // Factorial of n---------
                // int fact = factorial(num);
                // System.out.println("Factorial is: "+fact);

            // Fibonacci series of n numbers;---------
                // int a = 0, b=1;
                // System.out.println("Fibonacci Series: ");
                // System.out.println(0);
                // System.out.println(1);
                // Fibonacci(a,b,num-2);

            // Power of a number;--------- O(n)
                // int power = PowerNum(2,num);
                // System.out.println(power);

            // Power of a number;--------- O(log n)
                // int power = PowerNum2(2,num);
                // System.out.println(power);

    }
}
