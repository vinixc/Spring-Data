CREATE FUNCTION funcConcat(v_id integer)  RETURNS varchar AS $$
DECLARE
    v_cidade text;
	v_rua text;
BEGIN
    SELECT city from addresses where id_address = v_id INTO v_cidade;
	SELECT street from addresses where id_address = v_id INTO v_rua;
    RETURN v_cidade || ' - ' || v_rua;
END;
$$ LANGUAGE plpgsql;
