package grafos;

import javax.swing.JOptionPane;
import java.util.ArrayList;
//Beatriz Cristina, Pâmela Domingos
public class Principal 
{

    public static void main(String[] args)
    {
        ArrayList<String> vertices = new ArrayList<>();
        ArrayList<String[]> arestas = new ArrayList<>();

//        String orientado = JOptionPane.showInputDialog("Grafo orientado s/n");
//        String valorado = JOptionPane.showInputDialog("Grafo valorado s/n");
// Listas - ok
// matriz adjacencia - ok
// matriz incidencia - 
// definir orientado/valorado - 
//

        int cont = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de vertices"));
        for (int i = 1; i<= cont; i++)
        {
            vertices.add(JOptionPane.showInputDialog("Digite um vertice ("+i+")"));
        }

        int cont2 = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de arestas"));
        int nAresta = 0;
        while (true)
        {
            nAresta++;
            String[] aresta = new String[2];
            String vertice1 = "";
            String valor = "";
            while (vertice1.equals(""))
            {
                valor = JOptionPane.showInputDialog("Aresta " + nAresta + " - Digite primeiro vertice");

                for (String vertice : vertices)
                {
                    if (valor.equals(vertice)) 
                    {
                        vertice1 = valor;
                    }
                }
            }
            aresta[0] = vertice1;


            String vertice2 = "";
            while (vertice2.equals("")) 
            {
                valor = JOptionPane.showInputDialog("Aresta " + nAresta + " - Digite segundo vertice");
                for (String vertice : vertices) 
                {
                    if (valor.equals(vertice)) 
                    {
                        vertice2 = valor;
                    }
                }
            }
            aresta[1] = vertice2;

            arestas.add(aresta);

            if (arestas.size() == cont2)
                break;
        }

        String listaArestas = "Lista de Arestas\n";
        listaArestas += "   v1   v2\n";

        for (String[] aresta : arestas) 
        {
            for (Object vertice : aresta) 
            {
                listaArestas += "   "+(String)vertice;
            }
            listaArestas += "\n";
        }
        JOptionPane.showMessageDialog(null, listaArestas);


        String listaAdjacencias = "Lista de Adjacências\n";
        for (String vertice: vertices) 
        {
            listaAdjacencias += vertice+" -> ";
            for (String[] aresta: arestas) 
            {
                if (aresta[0].equals(vertice))
                {
                    listaAdjacencias += aresta[1]+" -> ";
                } else {
                    if (aresta[1].equals(vertice))
                    {
                        listaAdjacencias += aresta[0]+" -> ";
                    }
                }
            }
            listaAdjacencias += "\n";
        }
        JOptionPane.showMessageDialog(null,listaAdjacencias);


        String matrizAdjacencias = "Matriz de Adjacências\n   ";
        for (String vertice: vertices) 
        {
            matrizAdjacencias += vertice+"  ";
        }
        matrizAdjacencias+="\n";
        for (String vertice1: vertices) 
        {
            matrizAdjacencias += vertice1+"  ";
            for (String vertice2: vertices) 
            {
                boolean achou = false;
                for (String[] aresta: arestas) 
                {
                    if ((aresta[0].equals(vertice1) && aresta[1].equals(vertice2)) ||
                            aresta[1].equals(vertice1) && aresta[1].equals(vertice2))
                    {
                        achou = true;

                    }
                }
                if (achou) {
                    matrizAdjacencias += "1  ";
                }else {
                    matrizAdjacencias += "0  ";
                }
            }
            matrizAdjacencias += "\n";
        }
        JOptionPane.showInputDialog(null, matrizAdjacencias);


    }
}