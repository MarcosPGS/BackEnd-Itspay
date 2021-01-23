package com.play.check.util;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;

public class ValidarCPF_CNPJ {
	public static boolean isValidCpf(String cpf) { 
	    CPFValidator cpfValidator = new CPFValidator(); 
	    try{ cpfValidator.assertValid(cpf); 
	    return true; 
	    }catch(Exception e){
	        return false; 
	        } 
	    }
	
	public static boolean isValidCnpj(String cnpj) { 
	    CNPJValidator cnpjValidator = new CNPJValidator(); 
	    try{ 
	    	cnpjValidator.assertValid(cnpj); 
	    return true; 
	    }catch(Exception e){
	        return false; 
	        } 
	    }
}
