package com.extra.validators;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.extra.annotations.ValidCpf;
import com.extra.util.cpfcnpj.Cpf;


public class CpfValidator implements ConstraintValidator<ValidCpf, String> {
	private static List<String> cpfsInvalidos;

	static {
		cpfsInvalidos = new ArrayList<String>();
		cpfsInvalidos.add("00000000000");
		cpfsInvalidos.add("11111111111");
		cpfsInvalidos.add("99999999999");
		cpfsInvalidos.add("00011122233");
		cpfsInvalidos.add("11122233344");
	}

    @Override
    public void initialize(final ValidCpf constraintAnnotation) {
    }

    @Override
    public boolean isValid(final String username, final ConstraintValidatorContext context) {
        return (validateCpf(username));
    }

    private static boolean validateCpf(final String cpf) {
    	if(cpf == null || cpf.trim().length() == 0) {
			return false;
		} else if(cpfsInvalidos.contains(cpf)) {
			return false;
		} else if( ! Cpf.isValid(cpf)) {
			return false;
		}

		return true;
    }

    public static boolean ehCpfValido(String email){
    	return (validateCpf(email));
    }
}
