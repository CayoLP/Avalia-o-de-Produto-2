
import java.util.*;

public class Kruskal {

    public static double executar(Grafo g){
        UnionFind uf = new UnionFind(g.totalVertices);
        List<Aresta> lista = new ArrayList<>(g.arestas);
        lista.sort(Comparator.comparingDouble(a -> a.peso));

        double custo = 0;
        int usados = 0;

        for(Aresta a : lista){
            if(uf.unir(a.origem, a.destino)){
                custo += a.peso;
                usados++;
                if(usados == g.totalVertices - 1) break;
            }
        }
        return custo;
    }
}
