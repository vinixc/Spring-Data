CREATE FUNCTION procReplaceCPF(v_id integer) RETURNS varchar AS $$
DECLARE 
cpf_out text;
BEGIN
	SELECT "replace"("replace"(cpf,'.',''),'-', '') FROM DOCUMENTS WHERE id_document = v_id INTO cpf_out;
	RETURN cpf_out;
END;
$$ LANGUAGE plpgsql;
