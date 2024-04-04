package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class NoIdentificadoTest {

	@Test
	void test() {
		NoIdentificados noI = new NoIdentificados();
		CCDTyE centro = new CCDTyE();
		centro.setFecha_inicio(LocalDate.parse("1980-10-10"));
		
		centro.setFecha_fin(LocalDate.parse("1980-11-10"));
		
		noI.añadirCentro(centro);
		
		
		
		assertEquals(noI.tiempoCautiverio(), 31);
	}

}
