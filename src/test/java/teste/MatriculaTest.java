package teste;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class MatriculaTest {

	Matricula m;
	
	@BeforeEach
	void setUp() {
		m = new Matricula();
	}
	
	@ParameterizedTest
	@DisplayName("Teste Parametrizado 01")
	@CsvFileSource(resources = "/dadosDeTeste.csv", delimiter = ';')
	public void testaConsolidarParcialmente(BigDecimal n1, BigDecimal n2, BigDecimal n3, Integer freq, StatusAprovacao status_esperado) {
		
		m.registrarNota1(n1);
		m.registrarNota2(n2);
		m.registrarNota3(n3);
		m.registrarFrequencia(freq);
		
		m.consolidarParcialmente();
		
		Assertions.assertEquals(status_esperado, m.status());
		
	}
	
}
