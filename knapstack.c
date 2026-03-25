#include <stdio.h>

// Function to sort objects based on profit/weight ratio
void sort(int n, float p[], float w[], float ratio[]) {
    int i, j;
    float temp;

    for(i = 0; i < n - 1; i++) {
        for(j = i + 1; j < n; j++) {
            if(ratio[i] < ratio[j]) {
                // swap ratio
                temp = ratio[i];
                ratio[i] = ratio[j];
                ratio[j] = temp;

                // swap profit
                temp = p[i];
                p[i] = p[j];
                p[j] = temp;

                // swap weight
                temp = w[i];
                w[i] = w[j];
                w[j] = temp;
            }
        }
    }
}

// Fractional Knapsack function
void knapsack(int n, float m, float p[], float w[]) {
    float x[10], ratio[10], U;
    int i;

    // Step 1: Calculate profit/weight ratio
    for(i = 0; i < n; i++) {
        ratio[i] = p[i] / w[i];
    }

    // Step 2: Sort objects in descending order of ratio
    sort(n, p, w, ratio);

    // Step 3: Initialize x[]
    for(i = 0; i < n; i++) {
        x[i] = 0.0;
    }

    U = m;  // remaining capacity

    // Step 4: Fill knapsack
    for(i = 0; i < n; i++) {
        if(w[i] <= U) {
            x[i] = 1.0;      // take full object
            U = U - w[i];    // reduce capacity
        } else {
            break;
        }
    }

    // Step 5: Take fraction of next object
    if(i < n) {
        x[i] = U / w[i];
    }

    // Step 6: Calculate total weight and profit
    float totalProfit = 0, totalWeight = 0;

    printf("\nSolution:\n");
    printf("x[i] values:\n");

    for(i = 0; i < n; i++) {
        printf("x[%d] = %.2f\n", i+1, x[i]);
        totalProfit += x[i] * p[i];
        totalWeight += x[i] * w[i];
    }

    printf("\nTotal Weight = %.2f", totalWeight);
    printf("\nTotal Profit = %.2f\n", totalProfit);
}

// Main function
int main() {
    int n, i;
    float m, p[10], w[10];

    printf("Enter number of objects: ");
    scanf("%d", &n);

    printf("Enter knapsack capacity: ");
    scanf("%f", &m);

    printf("Enter profits:\n");
    for(i = 0; i < n; i++) {
        scanf("%f", &p[i]);
    }

    printf("Enter weights:\n");
    for(i = 0; i < n; i++) {
        scanf("%f", &w[i]);
    }

    knapsack(n, m, p, w);

    return 0;
}