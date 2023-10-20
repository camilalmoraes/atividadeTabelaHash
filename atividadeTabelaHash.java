package TabelaHash;

import java.util.LinkedList;
import java.util.Map.Entry;

public class atividadeTabelaHash<C,V> {
	private int tamanhoTotal;
	private LinkedList<Entry<C, V>>[] nivel1;
	private LinkedList<Entry<C, V>>[][] nivel2;
	
	public atividadeTabelaHash(int tamanhoTotal) {
		this.tamanhoTotal = tamanhoTotal;
		nivel1 = new LinkedList[10];
		
		int i;
		int j;
		for (i=0; i<10; i++) {
			nivel1[i] = new LinkedList<>();
		}
		nivel2 = new LinkedList[10][tamanhoTotal/10];
		for (i=0; i<10; i++) {
			for(j=0; j< tamanhoTotal/10; j++) {
				nivel2[i][j]= new LinkedList<>();
			}
		}
	}
	
	public void insereChaveValor(C chave, V valor) {
		int indiceNivel1 = hash1(chave);
		int indiceNivel2 = hash2(chave);
		int indiceNivel2tabela = indiceNivel2 % (tamanhoTotal/10);
		
		LinkedList<Entry<C, V>> listaNivel2 = nivel2[indiceNivel1][indiceNivel2tabela];
			
		for(Entry<C, V> entry : listaNivel2) {
			if (entry.getChave().equals(chave)) {
				entry.setValor(valor);
				return;
			}
		}
		listaNivel2.add(new Entry<>(chave, valor));
	}
	
	public V get(C chave) {
		int indiceNivel1 = hash1(chave);
		int indiceNivel2 = hash2(chave);
		int indiceNivel2tabela = indiceNivel2 % (tamanhoTotal/10);
		
		LinkedList<Entry<C, V>> listaNivel2 = nivel2[indiceNivel1][indiceNivel2tabela];
			
		for(Entry<C, V> entry : listaNivel2) {
			if (entry.getChave().equals(chave)) {
				return entry.getValor();
			}
		}
		return null;
	}
	private int hash1(C chave) {
		// TODO Auto-generated method stub
		return chave.hashCode() % 7;
	}
	private int hash2(C chave) {
		// TODO Auto-generated method stub
		return chave.hashCode() % 5;
	}
	private static class Entry<C, V>{
		private C chave;
		private V valor;
		
		public Entry(C chave, V valor) {
			this.chave = chave;
			this.valor = valor;
		}
		public C getChave() {
			return chave;
		}
		public V getValor() {
			return valor;
		}
		public void setValor(V valor) {
			this.valor = valor;
		}
	}
	
	public static void main (String[] args) {
		atividadeTabelaHash<String, Integer> tabelaHash = new atividadeTabelaHash<>(1000000);
		
		tabelaHash.insereChaveValor("Ana", 1);
		tabelaHash.insereChaveValor("Pedro", 2);
		
		System.out.println("Ana: " + tabelaHash.get("Ana"));
		System.out.println("Pedro: " + tabelaHash.get("Pedro"));

	}
}
