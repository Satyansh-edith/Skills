#include <stdio.h>
#define MAX 10
#define INF 99999

int V;

void printMatrix(int dist[MAX][MAX]) {
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            if (dist[i][j] == INF)
                printf("INF ");
            else
                printf("%d ", dist[i][j]);
        }
        printf("\n");
    }
}

// recursive path print
void printPath(int u, int v, int next[MAX][MAX]) {
    if (next[u][v] == -1) return;
    printf("%d", u + 1);
    while (u != v) {
        u = next[u][v];
        printf("->%d", u + 1);
    }
}

void floydWarshall(int graph[MAX][MAX]) {
    int dist[MAX][MAX], next[MAX][MAX];

    // init
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            dist[i][j] = graph[i][j];
            if (i != j && graph[i][j] != INF)
                next[i][j] = j;
            else
                next[i][j] = -1;
        }
    }

    // algo
    for (int k = 0; k < V; k++) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                    next[i][j] = next[i][k];
                }
            }
        }
        printf("\nA^%d:\n", k + 1);
        printMatrix(dist);
    }

    // FINAL PATH (correct)
    printf("\nPath:\n");
    for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {
            if (i != j && dist[i][j] != INF) {
                printf("%d □ %d : ", i + 1, j + 1);
                printPath(i, j, next);
                printf(" = %d\n", dist[i][j]);
            }
        }
    }
}

int main() {
    int graph[MAX][MAX], choice;

    while (1) {
        printf("\n--- MENU ---\n");
        printf("1. Enter Graph\n");
        printf("2. Apply Floyd Warshall\n");
        printf("3. Exit\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        switch (choice) {
        case 1:
            printf("Enter number of vertices: ");
            scanf("%d", &V);

            printf("Enter adjacency matrix (99999 for INF):\n");
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    scanf("%d", &graph[i][j]);
            break;

        case 2:
            floydWarshall(graph);
            break;

        case 3:
            return 0;
        }
    }
}