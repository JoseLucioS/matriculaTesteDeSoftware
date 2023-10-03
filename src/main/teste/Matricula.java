package teste;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Matricula {
	
	private static final BigDecimal TRES = BigDecimal.valueOf(3l);
	
	private static final BigDecimal QUATRO = BigDecimal.valueOf(4l);
	
	private static final BigDecimal SEIS = BigDecimal.valueOf(6l);
	
	private static final BigDecimal SETE = BigDecimal.valueOf(7l);
	
	private Turma turma;

	private Aluno aluno;

	private BigDecimal nota1;

	private BigDecimal nota2;

	private BigDecimal nota3;
	
	private Integer frequencia;

	private StatusAprovacao status;

	public BigDecimal nota1() {
		return this.nota1;
	}

	public BigDecimal nota2() {
		return this.nota2;
	}

	public BigDecimal nota3() {
		return this.nota3;
	}

	public StatusAprovacao status() {
		return this.status;
	}
	
	public Integer frequencia() {
		return frequencia;
	}

	public void registrarFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
	}

	public void registrarNota1(BigDecimal nota1) {
		this.nota1 = nota1;
	}

	public void registrarNota2(BigDecimal nota2) {
		this.nota2 = nota2;
	}

	public void registrarNota3(BigDecimal nota3) {
		this.nota3 = nota3;
	}

	/**
	 * Segue as regras estabelecidas pelos artigos do regulamento de graduação da UFRN: http://www.sistemas.ufrn.br/download/sigaa/public/regulamento_dos_cursos_de_graduacao.pdf
	 * 
	 * A partir do artigo 104, 106, 108, 113
	 */
	public void consolidarParcialmente() {
		
		BigDecimal soma = nota1().add(nota2()).add(nota3());
		BigDecimal mediaParcial = soma.divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP);
		
		//FREQUENCIA < 75
		if (frequencia() < 75) {

			if (mediaParcial.compareTo(TRES) < 0) {
				this.status = StatusAprovacao.REMF;
			} else {
				this.status = StatusAprovacao.REPF;
			}

		//FREQUENCIA >= 75
		} else {
			if(mediaParcial.compareTo(TRES) < 0) {
				
				this.status = StatusAprovacao.REP;
				
			} else if(mediaParcial.compareTo(SEIS) < 0) {
				
				this.status = StatusAprovacao.REC;
				
			} else if(mediaParcial.compareTo(SETE) < 0) {
				if(nota1.compareTo(QUATRO) < 0 || nota2.compareTo(QUATRO) < 0 || nota3.compareTo(QUATRO) < 0) {
					
					this.status = StatusAprovacao.REC;
					
				} else {
					
					this.status = StatusAprovacao.APRN;
					
				}
			} else {
				
				this.status = StatusAprovacao.APR;
				
			}
		}
	}

//		if (mediaParcial.compareTo(BigDecimal.valueOf(7)) >= 0) {
//			if(frequencia() >= 75) {
//				status = StatusAprovacao.APR;
//			} else {
//				status = StatusAprovacao.REPF;
//			}
//			
//		} else if(mediaParcial.compareTo(BigDecimal.valueOf(5)) >= 0 && mediaParcial.compareTo(BigDecimal.valueOf(7)) < 0) {
//			if(frequencia() >= 75) {
//				if(nota1().compareTo(BigDecimal.valueOf(3)) >= 0 && nota2().compareTo(BigDecimal.valueOf(3)) >= 0 && nota3().compareTo(BigDecimal.valueOf(3)) >= 0) {
//					status = StatusAprovacao.APRN;
//				} else {
//					status = StatusAprovacao.REC;
//				}
//				
//			} else {
//				status = StatusAprovacao.REPF;
//			}
//		} else if(mediaParcial.compareTo(BigDecimal.valueOf(3)) >= 0 && mediaParcial.compareTo(BigDecimal.valueOf(5)) < 0) {
//			if(frequencia() >= 75) {
//				status = StatusAprovacao.REC;
//			} else {
//				status = StatusAprovacao.REPF;
//			}
//		} else if (frequencia() >= 75){
//			status = StatusAprovacao.REP;
//		} else {
//			status = StatusAprovacao.REMF;
//		}
//		
//		this.status = status;
//
//	}


}
