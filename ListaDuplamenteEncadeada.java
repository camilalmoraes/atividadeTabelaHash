package TabelaHash;

//Criando a classe No
class No<C>{
	C dado;
	No<C> noAnterior;
	No<C> noProximo;
	
	//Criando o construtor da classe No
	public No(C dado) {
		this.dado = dado;
		this.noAnterior = null;
		this.noProximo = null;
	}
}
public class ListaDuplamenteEncadeada<C> {
	private No<C> noCabeca;
	private No<C> noFinal;
	private int size;
	
	public ListaDuplamenteEncadeada() {
		this.noCabeca = null;
		this.noFinal = null;
		this.size = 0;
		}
	private boolean isEmpty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
	//Criando metodo para adicionar um Nó na cabeça da lista
	public void adicionaNoCabeca(C dado) {
		No<C> novoNo = new No<>(dado);
		
		if (isEmpty()) {
			noCabeca = novoNo;
			noFinal = novoNo;
		} else {
			novoNo.noProximo = noCabeca;
			noCabeca.noAnterior = novoNo;
			noCabeca = novoNo;
		}
		size++;
	}
	//Criando metodo para adicionar um Nó no fianl da lista
	public void adicionaNoFinal(C dado) {
		No<C> novoNo = new No<>(dado);
			
		if (isEmpty()) {
			noCabeca = novoNo;
		}else {
			novoNo.noAnterior = noFinal;
			noFinal.noProximo = novoNo;
		}
			noFinal = novoNo;
			size++;
	}
	public C removeNoCabeca() {
		if (isEmpty()) {
			return null;
		}
		
		C removeDado = noCabeca.dado;
		noCabeca = noCabeca.noProximo;
		
		if (noCabeca != null) {
			noCabeca.noAnterior = null;
		} else {
			noFinal = null;
		}
		size--;
		
		return removeDado;
	}
	public C removeNoFinal() {
		if (isEmpty()) {
			return null;
		}
		
		C removeDado = noFinal.dado;
		noFinal = noFinal.noAnterior;
		
		if(noFinal != null) {
			noFinal.noProximo = null;
		} else {
			noCabeca = null;
		}
		size--;
		return removeDado;
	}
	public void imprimeListaCresc() {
		No<C> atual = noCabeca;
		
		while (atual != null) {
			System.out.println(atual.dado + " ");
			atual = atual.noProximo;
		}
		System.out.println();
	}
	public void imprimeListaDecresc (){
		No<C> atual = noFinal;
		
		while (atual != null) {
			System.out.println(atual.dado + " ");
			atual = atual.noAnterior;
		}
		System.out.println();
	}
	
	public static void main (String[] args) {
		ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<>();
		lista.adicionaNoFinal(1);
		lista.adicionaNoFinal(2);
		lista.adicionaNoFinal(3);
		lista.imprimeListaCresc();
		lista.imprimeListaDecresc();
	}
}
