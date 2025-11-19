
import java.util.*;

public class Dijkstra {

    public static double executar(Grafo g, int origem){
        double[] dist = new double[g.totalVertices];
        Arrays.fill(dist, 1e18);
        dist[origem] = 0;

        PriorityQueue<double[]> fila = new PriorityQueue<>(Comparator.comparingDouble(a->a[1]));
        fila.add(new double[]{origem, 0});

        while(!fila.isEmpty()){
            double[] atual = fila.poll();
            int u = (int) atual[0];
            if(atual[1] != dist[u]) continue;

            for(Aresta a : g.adj.get(u)){
                if(dist[a.destino] > dist[u] + a.peso){
                    dist[a.destino] = dist[u] + a.peso;
                    fila.add(new double[]{a.destino, dist[a.destino]});
                }
            }
        }

        double soma = 0;
        for(double d : dist) if(d < 1e17) soma += d;
        return soma;
    }
}
