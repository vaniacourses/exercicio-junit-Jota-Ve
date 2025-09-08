package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do Carrinho")
public class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();
    }

    @Test
    public void testCarrinhoIniciaVazio(){
        assertEquals(carrinho.getQtdeItems(), 0);
    }

    @Test
    public void testValorCarrinhoVazioEhZero(){
        assertEquals(carrinho.getValorTotal(), 0.0);
    }

    @DisplayName("Testa a adição de um produto ao carrinho")
    @Test
    public void testAddItem() {
        carrinho.addItem(new Produto("Arroz", 5.00));
        Assertions.assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    public void testValorTotalAposAdicionarItem(){
        carrinho.addItem(new Produto("Arroz", 5.00));
        carrinho.addItem(new Produto("Feijão", 6.99));
        assertEquals(carrinho.getValorTotal(), 11.99);
    }

    @Test
    public void testRemoveItem(){
        Produto item = new Produto("Feijão", 6.99);
        carrinho.addItem(item);
        try {
            carrinho.removeItem(item);
        } catch (Exception e) {
            fail("Não deveria lançar exceção");
        }
        assertEquals(carrinho.getQtdeItems(), 0);
    }

    @Test
    public void testRemoveItemInexistente(){
        Produto item = new Produto("Macarrão", 3.99);
        assertThrows(ProdutoNaoEncontradoException.class, () -> {
            carrinho.removeItem(item);
        });
    }

    @Test
    public void testEsvaziarCarrinhoZeraQuantidade(){
        carrinho.addItem(new Produto("Arroz", 5.00));
        carrinho.addItem(new Produto("Feijão", 6.99));
        carrinho.esvazia();
        assertEquals(carrinho.getQtdeItems(), 0);
    }

    @Test
    public void testEsvaziarCarrinhoZeraValor(){
        carrinho.addItem(new Produto("Arroz", 5.00));
        carrinho.addItem(new Produto("Feijão", 6.99));
        carrinho.esvazia();
        assertEquals(carrinho.getValorTotal(), 0.0);
    }

}
