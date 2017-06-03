package graph2;

public class Graph2 {
	int nvert;
	CelulaVert [] vertices;
	int cont;
	
	void Travessia(){
		for(int v = 1; v <= nvert; v++)
			vertices[v].visited = false;
		cont = 0;
		for(int v = 1; v <= nvert; v++)
			if(vertices[v].visited == false)
				BuscaProf(v);
	}
	
	void BuscaProf(int v){
		CelulaAdj p;
		vertices[v].visited = true;
		cont++;
		vertices[v].nvis = cont;
		p = vertices[v].adjs;
		while(p!=null){
			if(vertices[p.vert].visited == false)
				BuscaProf(p.vert);
			p = p.next;
		}
	}
	
}
