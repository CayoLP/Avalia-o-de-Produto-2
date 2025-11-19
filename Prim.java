
import java.util.*;

public class Prim {

    public static double executar(Grafo g){
        boolean[] visitado = new boolean[g.totalVertices];
        PriorityQueue<Aresta> fila = new PriorityQueue<>(Comparator.comparingDouble(a->a.peso));

        visitado[0] = true;
        fila.addAll(g.adj.get(0));

        double custo = 0;
        int usados = 1;

        while(!fila.isEmpty() && usados < g.totalVertices){
            Aresta a = fila.poll();
            if(visitado[a.destino]) continue;

            visitado[a.destino] = true;
            custo += a.peso;
            usados++;

            fila.addAll(g.adj.get(a.destino));
        }

        return custo;
    }
}
