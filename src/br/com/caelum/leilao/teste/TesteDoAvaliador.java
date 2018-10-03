package br.com.caelum.leilao.teste;

import org.junit.Test;
import org.junit.Assert;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class TesteDoAvaliador {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		//parte 1: cen�rio
		Usuario joao = new Usuario ("Joao");
		Usuario jose = new Usuario ("Jose");
		Usuario maria = new Usuario ("Maria");
		
		Leilao leilao = new Leilao ("Xbox 360 Novo");
		
		leilao.propoe(new Lance (joao, 250.0));
		leilao.propoe(new Lance (jose, 300.0));
		leilao.propoe(new Lance (maria, 400.0));
		
		//parte 2: a��o
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		//parte 3: valida��o
		double maiorEsperado = 400;
		double menorEsperado = 250;
		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		
	}
}
