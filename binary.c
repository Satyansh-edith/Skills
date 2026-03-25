#include <stdio.h>

struct Item {
    int value;
    int index;
};

void sort(struct Item arr[], int n) {
    int i, j;
    struct Item temp;

    for(i = 0; i < n-1; i++) {
        for(j = i+1; j < n; j++) {
            if(arr[i].value > arr[j].value) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

// Binary search (returns one occurrence)
int binarysearch(struct Item arr[], int n, int x) {
    int l = 0, r = n - 1, mid;

    while(l <= r) {
        mid = (l + r) / 2;

        if(arr[mid].value == x)
            return mid;
        else if(x > arr[mid].value)
            l = mid + 1;
        else
            r = mid - 1;
    }
    return -1;
}

int main() {
    int n, i, x, pos;
    struct Item arr[100];

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter elements:\n");
    for(i = 0; i < n; i++) {
        scanf("%d", &arr[i].value);
        arr[i].index = i; // store original index
    }

    // Sort
    sort(arr, n);

    printf("\nEnter searching element: ");
    scanf("%d", &x);

    // Present the sorted array after input
    printf("\nSorted array:\n");
    for(i = 0; i < n; i++) {
        printf("%d ", arr[i].value);
    }

    // Binary Search
    pos = binarysearch(arr, n, x);

    if(pos == -1) {
        printf("Element not found\n");
    } else {
        printf("\nOriginal indices: ");

        int j = pos;
        while(j >= 0 && arr[j].value == x)
            j--;

        j++;

        while(j < n && arr[j].value == x) {
            printf("%d ", arr[j].index);
            j++;
        }
    }

    return 0;
}