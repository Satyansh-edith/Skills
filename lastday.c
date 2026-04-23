#include <stdio.h>
#include <limits.h>
#include <stdbool.h>

#define MAX 20

int V;

int minKey(int key[], bool mstSet[])
{
    int min = INT_MAX;
    int min_index = -1;

    for (int v = 0; v < V; v++)
    {
        if (!mstSet[v] && key[v] < min)
        {
            min = key[v];
            min_index = v;
        }
    }
    return min_index;
}

void primMST(int graph[MAX][MAX], int start)
{
    int parent[MAX], key[MAX];
    bool mstSet[MAX];

    int from[MAX], to[MAX], wt[MAX];
    int edgeCount = 0, total = 0;

    for (int i = 0; i < V; i++)
    {
        key[i] = INT_MAX;
        mstSet[i] = false;
        parent[i] = -1;
    }

    key[start] = 0;

    for (int count = 0; count < V; count++)
    {
        int u = minKey(key, mstSet);
        mstSet[u] = true;

        if (parent[u] != -1)
        {
            from[edgeCount] = parent[u];
            to[edgeCount] = u;
            wt[edgeCount] = graph[parent[u]][u];
            total += wt[edgeCount];
            edgeCount++;
        }

        for (int v = 0; v < V; v++)
        {
            if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v])
            {
                key[v] = graph[u][v];
                parent[v] = u;
            }
        }
    }

    printf("\nEdges in MST (Traversal Order):\n");
    printf("Edge\tWeight\n");
    for (int i = 0; i < edgeCount; i++)
    {
        printf("%c - %c\t%d\n", 'A' + from[i], 'A' + to[i], wt[i]);
    }

    printf("\nTotal Weight = %d\n", total);
}

int main()
{
    int graph[MAX][MAX];
    char startChar;

    printf("Enter number of vertices: ");
    scanf("%d", &V);

    printf("Enter adjacency matrix:\n");
    for (int i = 0; i < V; i++)
    {
        for (int j = 0; j < V; j++)
        {
            scanf("%d", &graph[i][j]);
        }
    }

    printf("Enter start vertex: ");
    scanf(" %c", &startChar);

    primMST(graph, startChar - 'A');

    return 0;
}