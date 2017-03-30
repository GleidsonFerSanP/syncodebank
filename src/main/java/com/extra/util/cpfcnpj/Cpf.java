package com.extra.util.cpfcnpj;

import com.extra.exceptions.ValidationException;

public class Cpf extends CpfCnpj{
    
    /**Default Constructor.
     * @param cpf the CPF number
     * @throws ValidationException
     */
    public Cpf(String cpf) throws ValidationException  {
        super(cpf);
        String s = cpf.replaceAll("[^0-9]*","");
        if (s.length() != CPF_DIGITS) {
            throw new ValidationException("O CPF deve ter " +
                    CPF_DIGITS + " dígitos");
        }
    }
    /**Always return false! The class represents a CPF.
     * @see com.extra.util.cpfcnpj.util.extra.cpf.brazilutils.br.cpfcnpj.CpfCnpj#isCnpj()
     */
    public boolean isCnpj() {
        return false;
    }
    /**Always return true! The class represents a CPF. 
     * @see com.extra.util.cpfcnpj.util.extra.cpf.brazilutils.br.cpfcnpj.CpfCnpj#isCpf()
     */
    public boolean isCpf() {
        return true;
    }
}
