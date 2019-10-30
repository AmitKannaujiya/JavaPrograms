package dp;


/**
 *
 * Dynamic Programming:
 * It is method of store the result of computation of a problem, So that these pre-computed values are used for next computation.
 * insteal of re compution again. this process of storing computations is called memoization. Dynamic programming useses more space
 * to use less memory.
 * there are two ways to do dynamic programing :
     * 1) Optimal Substructures: Optimal Substructures is a way to solve a problem by solving smaller substrucures
     * 	like fib(5) = fib(4) + fib(3);
     * 	To think about substructures, it is a recursive way to solve a problem.
     *
     * 2) Overlapping Subproblems: Overlapping subproblem is when we solve the any subproblems then we get the same subproblem again,
     * like   fib(5) = fib(4) + fib(3)
     * 	   fib(4) = fib(3) + fib(2)
     * here, fib(3) is the overlapping subproblem.
 *
 * Stretegies to Solve DP:
     * 1) Memoization: remember the solutions to the subproblem, so that do not calculate it again.
     * 2) Top/ Down or Bottom/Up approach : in top/Down approach we start with the final result and break down it into smaller sub problem.
     * Generally recursive approach are used here.
     * In Bottom/Up we start with intutive subproblems and solve them and use their results to solve higher states .
     * Generally iterative approach is used .
     *
     * FAST Method :
     * 1) First solution:
     * 2) Analyse the First Solution:
     * 3) Find the subproblems:
     * 4) Turn aroung the Subproblems
 *
 *
 *
 *
 *
 */
public class FibonacciDP {


    int Fib_First(int n) {
        // base case for first fibbo no
        if(n==0) {
            return 0;
        }
        // base case for second fibbo no
        if(n==1) {
            return 1;
        }
        return Fib_First(n-1) + Fib_First(n-2);
    }

    // We can use memoization to store ovelaping sub problem

    int Fib_Top_down(int n) {

        if(n < 2) {
            return n;
        }

        int cache[] = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            cache[i] = -1;
        }
        cache[0] = 0;
        cache[1] = 1;
        return Fib_Top_down(n, cache);
    }

    int Fib_Top_down(int n, int [] cache) {
        if(cache[n] > -1) {
            return cache[n];
        }
        cache[n] = Fib_Top_down(n-1, cache) + Fib_Top_down(n-2, cache);
        return cache[n];

    }
    // solve subproblems iteratively and store in cache to use for higher subproblem solution
    int Fib_bottom_up(int n) {
        int cache[] = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i < n+1; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];

    }
}
