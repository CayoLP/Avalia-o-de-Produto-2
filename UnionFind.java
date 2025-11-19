
public class UnionFind {
    int[] pai, rank;

    public UnionFind(int n){
        pai = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++) pai[i] = i;
    }

    public int find(int x){
        if(pai[x] != x)
            pai[x] = find(pai[x]);
        return pai[x];
    }

    public boolean unir(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;

        if(rank[a] < rank[b]) pai[a] = b;
        else if(rank[b] < rank[a]) pai[b] = a;
        else { pai[b] = a; rank[a]++; }

        return true;
    }
}
