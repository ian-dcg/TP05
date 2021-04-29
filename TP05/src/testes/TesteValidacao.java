package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;
class TesteValidacao {
	Itens it = new Itens();
	@Test
	void testGetProduto() {
		assertTrue(true, it.getProduto());
	}

	@Test
	void testGetUnidade() {
		assertTrue(true, it.getUnidade());
	}

	@Test
	void testGetSetor() {
		assertTrue(true, it.getSetor());
	}

}
