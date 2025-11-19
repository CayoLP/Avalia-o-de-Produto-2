import java.io.*;
import java.util.*;

public class Principal {

    public static Grafo carregar(String caminho) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        String linha;
        int n = 0;
        List<String> linhas = new ArrayList<>();

        while((linha = br.readLine()) != null){
            linhas.add(linha);
            if(linha.startsWith("p")){
                String[] t = linha.split("\\s+");
                n = Integer.parseInt(t[2]);
            }
        }
        br.close();

        Grafo g = new Grafo(n);

        for(String s : linhas){
            if(s.startsWith("a")){
                String[] t = s.split("\\s+");
                int u = Integer.parseInt(t[1]) - 1;
                int v = Integer.parseInt(t[2]) - 1;
                double peso = Double.parseDouble(t[3]);
                g.adicionarAresta(u, v, peso);
            }
        }

        return g;
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos arquivos deseja carregar? ");
        int quantidade = sc.nextInt();
        sc.nextLine(); // limpar buffer

        String[] arquivos = new String[quantidade];

        for(int i=0; i<quantidade; i++){
            System.out.print("Digite o nome do arquivo " + (i+1) + ": ");
            arquivos[i] = sc.nextLine();
        }

        for(String caminho : arquivos){

            Grafo g = carregar(caminho);

            long t1 = System.nanoTime();
            double dj = Dijkstra.executar(g, 0);
            long t2 = System.nanoTime();

            long t3 = System.nanoTime();
            double kr = Kruskal.executar(g);
            long t4 = System.nanoTime();

            long t5 = System.nanoTime();
            double pr = Prim.executar(g);
            long t6 = System.nanoTime();

            System.out.println("Arquivo: " + caminho);
            System.out.println("Vértices: " + g.totalVertices + "  Arestas: " + g.arestas.size());
            System.out.println("Dijkstra: " + dj + "   Tempo: " + (t2-t1)/1e9 + "s");
            System.out.println("Kruskal : " + kr + "   Tempo: " + (t4-t3)/1e9 + "s");
            System.out.println("Prim    : " + pr + "   Tempo: " + (t6-t5)/1e9 + "s");
            System.out.println();
        }

        sc.close();
    }
}
