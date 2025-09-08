package carrinho;

import java.util.ArrayList;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class Carrinho {

	private ArrayList<Produto> items;

	public Carrinho() {
		items = new ArrayList<Produto>();
	}

	public double getValorTotal() {
		double valorTotal = 0.0;

		for (Produto item : items) {
			valorTotal += item.getPreco();
		}

		return valorTotal;
	}

	public void addItem(Produto item) {
		items.add(item);
	}

	public void removeItem(Produto item) throws ProdutoNaoEncontradoException {
		if (!items.remove(item)) {
			throw new ProdutoNaoEncontradoException();
		}
	}

	public int getQtdeItems() {
		return items.size();
	}

	public void esvazia() {
		items.clear();
	}


}
